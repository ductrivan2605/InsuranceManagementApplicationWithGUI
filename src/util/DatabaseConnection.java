package src.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static final String URL = "jdbc:postgresql://ep-old-frost-a1v0y414.ap-southeast-1.aws.neon.tech/claiminsurancesystem?&sslmode=require";
    public static final String username = "claiminsurancesystem_owner";
    public static final String password = "pSFcMzs4X7Kk";
    public void connect() {
        try(Connection connection = DriverManager.getConnection(URL, username, password);){
            if(connection != null) {
                System.out.println("Connected to database");
            } else {
                System.out.println("Failure!");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Failed to register JDBC driver: " + e.getMessage());
        }

        return DriverManager.getConnection(URL, username, password);
    }
}
