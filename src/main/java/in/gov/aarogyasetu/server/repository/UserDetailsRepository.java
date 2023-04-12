package in.gov.aarogyasetu.server.repository;

import in.gov.aarogyasetu.server.model.User;


public interface UserDetailsRepository
{

    int addOrUpdate(User user);

    User getUser(int userID);

}
