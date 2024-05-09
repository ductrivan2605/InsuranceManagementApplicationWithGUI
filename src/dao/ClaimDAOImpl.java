/**
 * @author <Van Duc Tri - s3978223>
 */
package src.dao;

import src.model.Claim;
import src.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static src.util.DatabaseConnection.*;

public class ClaimDAOImpl implements ClaimDataAccessObject {
    private final String ADD_CLAIM_SQL = "INSERT INTO claims (claim_id, policy_number, date_filed, description, status, amount_claimed, surveyor_id, receiver_bank, receiver_name, receiver_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String GET_CLAIM_SQL = "SELECT * FROM claims WHERE claim_id = ?";
    private final DatabaseConnection databaseConnection;

    public ClaimDAOImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }


    @Override
    public void add(Claim claim) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            databaseConnection.connect();
            connection = databaseConnection.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement(ADD_CLAIM_SQL);
                statement.setString(1, claim.getId());
                statement.setDate(2, claim.getClaimDate()); // Using getter for claimDate
                statement.setString(3, claim.getInsuredPerson());
                statement.setString(4, claim.getCardNumber());
                statement.setDate(5, claim.getExamDate()); // Using getter for examDate
                // Handle documents (assuming conversion to comma-separated string)
                String documentString = String.join(",", claim.getDocuments());
                statement.setString(6, documentString);
                statement.setDouble(7, claim.getClaimAmount());
                statement.setString(8, claim.getStatus());
                statement.setString(9, claim.getReceiverBank());
                statement.setString(10, claim.getReceiverName());
                statement.setString(11, claim.getReceiverNumber());
                statement.executeUpdate();
            } else {
             throw new Exception("Failed to connect to table");
            }
        } catch (SQLException e) {
            throw new Exception("Error adding claim: " + e.getMessage());
        } finally {
            closeResources(connection, statement);
        }
    }

    @Override
    public Claim getOne(String claimId) throws Exception {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Claim claim = null;
        try {
            databaseConnection.connect();
            statement = connection.prepareStatement(GET_CLAIM_SQL);
            statement.setString(1, claimId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Extract data from ResultSet and create a Claim object
                claim = new Claim(
                        resultSet.getString("claim_id"),
                        resultSet.getDate("date_filed"),
                        resultSet.getString("policy_number"), // Assuming this maps to insuredPerson in Claim model
                        resultSet.getString("description"),  // Assuming this maps to cardNumber in Claim model
                        resultSet.getDate("exam_date"),
                        convertDocumentsToList(resultSet.getString("documents")),
                        resultSet.getDouble("amount_claimed"),
                        resultSet.getString("status"),
                        resultSet.getString("receiver_bank"),  // Assuming this maps to receiverBank in Claim model
                        resultSet.getString("receiver_name"),  // Assuming this maps to receiverName in Claim model
                        resultSet.getString("receiver_number")  // Assuming this maps to receiverNumber in Claim model
                );
            }
        } catch (SQLException e) {
            throw new Exception("Error retrieving claim: " + e.getMessage());
        } finally {
            closeResources(connection, statement, resultSet);
        }
        return claim;
    }
    private void closeResources(Connection connection, PreparedStatement statement) throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
    private List<String> convertDocumentsToList(String documentString) {
        if (documentString == null || documentString.isEmpty()) {
            return new ArrayList<>();

