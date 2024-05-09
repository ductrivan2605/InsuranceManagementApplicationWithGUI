package src.service;
import java.util.ArrayList;
import java.util.List;

import src.model.Claim;

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private List<Claim> claims;

    public ClaimProcessManagerImpl() {
        this.claims = new ArrayList<>();
    }

    @Override
    public void add(Claim claim) {
        claims.add(claim);
    }
    @Override
    public Claim getOne(String claimId) {
        for (Claim claim : claims) {
            if (claim.getId().equals(claimId)) {
                return claim;
            }
        }
        return null;
    }

    @Override
    public List<Claim> getAll() {
        return claims;
    }

    @Override
    public List<Claim> getClaims(String userId) throws Exception {
        return null;
    }
}