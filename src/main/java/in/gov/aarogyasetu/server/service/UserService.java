package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.model.User;

import java.util.Map;


public interface UserService
{

    int register(Map<String, Object> userDetail);

    boolean validateCredentials(Map<String, Object> userCredentials);

    User getUser(int userID);

    void updateUser(User user);

}
