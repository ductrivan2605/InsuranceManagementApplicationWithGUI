package src.model;

public class PolicyHolder extends User {
    private String policyNumber;
    public PolicyHolder(String userId, String username, String password, String fullName,
                        String email, String policyNumber) {
        super(userId, username, password, fullName, email);
        this.policyNumber = policyNumber;
    }
    @Override
    public String getUserType() {
        return "PolicyHolder";
    }
}

