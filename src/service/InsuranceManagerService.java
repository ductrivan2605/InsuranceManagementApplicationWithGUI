package src.service;

import src.model.Claim;
import src.model.User;

import java.util.List;

public interface InsuranceManagerService {

    void approveClaim(String claimId) throws Exception;

    void rejectClaim(String claimId, String reason) throws Exception;

    List<Claim> getClaims(String managerId, String filter) throws Exception;  // Filtering options

    List<User> getUsers(String managerId, String filter) throws Exception;  // Filtering options

    List<User> getSurveyors(String managerId) throws Exception;
}
