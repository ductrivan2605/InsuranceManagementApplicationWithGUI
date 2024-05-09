package src.dao;

import src.model.Claim;

import java.sql.SQLException;
import java.util.List;

public interface ClaimDataAccessObject {
    void add(Claim claim) throws Exception;
    Claim getOne(String claimId) throws Exception;
    List<Claim> getAll();
}
