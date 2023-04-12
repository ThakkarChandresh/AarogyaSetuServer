package in.gov.aarogyasetu.server.repository;

import in.gov.aarogyasetu.server.model.User;

import java.util.HashMap;


public class UserDetailsRepositoryImpl implements UserDetailsRepository
{

    private UserDetailsRepositoryImpl()
    {


    }

    private static UserDetailsRepositoryImpl userDetailsRepositoryInstance = null;

    public static UserDetailsRepositoryImpl getInstance()
    {

        if (userDetailsRepositoryInstance == null)
        {

            userDetailsRepositoryInstance = new UserDetailsRepositoryImpl();

        }

        return userDetailsRepositoryInstance;
    }

    private static final HashMap<Integer, User> userDetails = new HashMap<>();

    @Override
    public synchronized int addOrUpdate(User user)
    {

        userDetails.put(user.getUserId(), user);

        return user.getUserId();

    }

    @Override
    public synchronized User getUser(int userID)
    {

        return userDetails.get(userID);

    }

}
