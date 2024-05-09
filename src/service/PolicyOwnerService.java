package src.service;

import src.model.Claim;

import java.util.List;

public interface PolicyOwnerService {
    void addBeneficiary(String policyOwnerId, String dependentId) throws Exception;

    void removeBeneficiary(String policyOwnerId, String dependentId) throws Exception;

    List<Claim> getClaims(String policyOwnerId) throws Exception;

    double calculateYearlyPremium(String policyOwnerId) throws Exception;
}

