package src.service;

import src.model.Claim;

import java.util.List;

public interface ClaimProcessManager {
    void add(Claim claim);
    Claim getOne(String claimId);
    List<Claim> getAll();
    List<Claim> getClaims(String userId) throws Exception;
}
