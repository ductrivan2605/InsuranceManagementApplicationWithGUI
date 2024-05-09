package src.service;
import src.model.User;

public interface UserService {
    void addUser(User user) throws Exception;

    void updateUser(User user) throws Exception;  // Restrict update to specific fields

    void deleteUser(String userId) throws Exception;  // Restricted functionality

    User getUser(String userId) throws Exception;

    boolean hasRole(String userId, String role) throws Exception;

}
