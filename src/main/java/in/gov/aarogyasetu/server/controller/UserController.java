package in.gov.aarogyasetu.server.controller;

import in.gov.aarogyasetu.server.service.TokenService;
import in.gov.aarogyasetu.server.service.TokenServiceImpl;
import in.gov.aarogyasetu.server.service.UserService;
import in.gov.aarogyasetu.server.service.UserServiceImpl;
import in.gov.aarogyasetu.server.util.BaseMethods;
import in.gov.aarogyasetu.server.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.json.JSONObject;

import java.util.Map;


public class UserController
{

    private UserController()
    {


    }

    private static UserController userControllerInstance;

    private final UserService userService = UserServiceImpl.getInstance();

    private final TokenService tokenService = TokenServiceImpl.getInstance();

    public static UserController getInstance()
    {

        if (userControllerInstance == null)
        {

            userControllerInstance = new UserController();

        }

        return userControllerInstance;

    }

    public JSONObject register(Map<String, Object> userDetail)
    {

        JSONObject response = new JSONObject();

        try
        {
            response.put("StatusCode", 200);

            response.put("StatusMessage", "OK");

            response.put("ResponseBody", new JSONObject().put("message", "\nRegistration Successful\nYour UserID is: " + this.userService.register(userDetail)));
        }
        catch (Exception exception)
        {
            response.put("StatusCode", 500);

            response.put("StatusMessage", "Internal Server Error");
        }
        return response;
    }

    public JSONObject login(Map<String, Object> userCredentials)
    {

        JSONObject response = new JSONObject();

        try
        {
            boolean status = this.userService.validateCredentials(userCredentials);

            JSONObject responseBody = new JSONObject().put("status", status);

            if (status)
            {
                response.put("StatusCode", 200);

                response.put("StatusMessage", "OK");

                String token = JWTUtil.getJWT(userCredentials.get("userID").toString());

                responseBody.put("access-token", token);

                this.tokenService.addOrUpdateToken(Integer.parseInt(userCredentials.get("userID").toString()), token);
            }
            else
            {

                response.put("StatusCode", 401);

                response.put("StatusMessage", "Unauthorized");

                responseBody.put("message", "Incorrect userid or password!");

            }

            response.put("ResponseBody", responseBody);
        }
        catch (Exception exception)
        {
            response.put("StatusCode", 500);

            response.put("StatusMessage", "Internal Server Error");
        }

        return response;
    }

    public JSONObject logout(String token)
    {

        JSONObject response = new JSONObject();

        JSONObject responseBody = new JSONObject();

        int userID;

        try
        {
            if ((userID = BaseMethods.validateToken(token)) != -1)
            {
                response.put("StatusCode", 200);

                response.put("StatusMessage", "OK");

                responseBody.put("message", "Logged Out Successfully");

                this.tokenService.removeToken(userID);
            }
            else
            {
                response.put("StatusCode", 401);

                response.put("StatusMessage", "Unauthorized");

                responseBody.put("message", "Already Logged Out!");
            }
            response.put("ResponseBody", responseBody);
        }
        catch (ExpiredJwtException exception)
        {
            response.put("StatusCode", 401);

            response.put("StatusMessage", "Unauthorized");

            responseBody.put("message", "Session Timed Out!");

            response.put("ResponseBody", responseBody);
        }
        catch (Exception exception)
        {
            response.put("StatusCode", 500);

            response.put("StatusMessage", "Internal Server Error");
        }
        return response;
    }

}
