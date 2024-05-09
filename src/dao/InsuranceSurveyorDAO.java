package src.dao;

import src.model.Claim;
import src.model.User;

import java.util.List;

public interface InsuranceSurveyorDAO {
    void requestMoreInfo(String claimId, String message) throws Exception;

    void proposeClaim(Claim claim) throws Exception;

    List<Claim> getClaims(String surveyorId, String filter) throws Exception;  // Filtering options

    List<User> getUsers(String surveyorId, String filter) throws Exception;  // Filtering options
}
