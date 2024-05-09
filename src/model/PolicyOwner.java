package src.model;

import java.util.List;

public class PolicyOwner extends User {

    private List<String> beneficiaryIds;  // List of dependent user IDs

    public PolicyOwner(String userId, String username, String password, String fullName,
                       String email, List<String> beneficiaryIds) {
        super(userId, username, password, fullName, email);
        this.beneficiaryIds = beneficiaryIds;
    }

    @Override
    public String getUserType() {
        return "PolicyOwner";
    }

    // Inherited setters from User

    public void setBeneficiaryIds(List<String> beneficiaryIds) throws Exception {
        // Implement logic to add/remove beneficiaries and update their user status if needed
        // Ensure proper authorization checks and validation

        this.beneficiaryIds = beneficiaryIds;
    }
}
