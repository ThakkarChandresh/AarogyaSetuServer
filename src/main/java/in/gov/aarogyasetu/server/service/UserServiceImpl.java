package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.model.User;
import in.gov.aarogyasetu.server.repository.UserDetailsRepository;
import in.gov.aarogyasetu.server.repository.UserDetailsRepositoryImpl;

import java.util.Map;


public class UserServiceImpl implements UserService
{

    private UserServiceImpl()
    {


    }

    private static UserServiceImpl userServiceInstance = null;

    public static UserServiceImpl getInstance()
    {

        if (userServiceInstance == null)
        {

            userServiceInstance = new UserServiceImpl();

        }

        return userServiceInstance;

    }

    private final UserDetailsRepository userDetailsRepository = UserDetailsRepositoryImpl.getInstance();

    private final CityService cityService = CityServiceImpl.getInstance();

    @Override
    public int register(Map<String, Object> userDetail)
    {

        User user = new User(userDetail.get("fullName").toString(), Long.parseLong(userDetail.get("contactNumber").toString()), userDetail.get("city").toString(), userDetail.get("symptoms").toString(), userDetail.get("medicines").toString(), userDetail.get("status").toString(), userDetail.get("password").toString());

        int activeCase = this.cityService.getActiveCases(user.getCity());

        this.cityService.updateActiveCases(user.getCity(), ++activeCase);

        return this.userDetailsRepository.addOrUpdate(user);

    }

    @Override
    public boolean validateCredentials(Map<String, Object> userCredentials)
    {

        int userID = Integer.parseInt(userCredentials.get("userID").toString());

        String password = userCredentials.get("password").toString();

        return this.userDetailsRepository.getUser(userID) != null && this.userDetailsRepository.getUser(userID).getPassword().equals(password);

    }

    @Override
    public User getUser(int userID)
    {

        return this.userDetailsRepository.getUser(userID);
    }

    @Override
    public void updateUser(User user)
    {

        this.userDetailsRepository.addOrUpdate(user);
    }

}
