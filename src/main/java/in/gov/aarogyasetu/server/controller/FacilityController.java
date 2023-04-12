package in.gov.aarogyasetu.server.controller;

import in.gov.aarogyasetu.server.exceptions.NoSuchHospitalException;
import in.gov.aarogyasetu.server.service.*;
import in.gov.aarogyasetu.server.util.BaseMethods;
import in.gov.aarogyasetu.server.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.json.JSONObject;


public class FacilityController
{

    private FacilityController()
    {

    }

    private static FacilityController facilityControllerInstance = null;

    private final HospitalService hospitalService = HospitalServiceImpl.getInstance();

    private final TokenService tokenService = TokenServiceImpl.getInstance();

    private final UserService userService = UserServiceImpl.getInstance();

    public static FacilityController getInstance()
    {

        if (facilityControllerInstance == null)
        {
            facilityControllerInstance = new FacilityController();
        }

        return facilityControllerInstance;
    }

    public JSONObject getHospitalsList(boolean filterByArea, String token)
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

                responseBody.put("hospitals", this.hospitalService.getHospitals(filterByArea, userID));

                token = JWTUtil.getJWT(String.valueOf(userID));

                responseBody.put("access-token", token);

                this.tokenService.addOrUpdateToken(userID, token);
            }
            else
            {
                response.put("StatusCode", 401);

                response.put("StatusMessage", "Unauthorized");

                responseBody.put("message", "Logged Out! You may be logged in from other device!");
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

    public JSONObject bookBed(int hospitalID, String token)
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

                if (this.userService.getUser(userID).getAdmittedToHospital() == -1)
                {
                    if (this.hospitalService.bookBed(userID, hospitalID))
                    {
                        responseBody.put("message", "We've Booked A Bed For You At: " + this.hospitalService.getHospitalInformation(hospitalID).getHospitalName());
                    }
                    else
                    {
                        responseBody.put("message", "Unable to book bed");
                    }
                }
                else
                {
                    responseBody.put("message", "You Have Already Booked One Bed At: " + this.hospitalService.getHospitalInformation(this.userService.getUser(userID).getAdmittedToHospital()).getHospitalName());
                }

                token = JWTUtil.getJWT(String.valueOf(userID));

                responseBody.put("access-token", token);

                this.tokenService.addOrUpdateToken(userID, token);
            }
            else
            {
                response.put("StatusCode", 401);

                response.put("StatusMessage", "Unauthorized");

                responseBody.put("message", "Logged Out! You may be logged in from other device!");
            }
            response.put("ResponseBody", responseBody);
        }
        catch (NoSuchHospitalException exception)
        {
            response.put("StatusCode", 400);

            response.put("StatusMessage", "Bad Request!");

            responseBody.put("message", exception.getMessage());

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

    public JSONObject checkOutBed(String token)
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

                if (this.userService.getUser(userID).getAdmittedToHospital() != -1)
                {
                    this.hospitalService.checkOutBed(userID, this.userService.getUser(userID).getAdmittedToHospital());

                    responseBody.put("message", "Done! Checked Out !\nWe Wish You A Better Healthy Life Ahead! Thank You!");
                }
                else
                {
                    responseBody.put("message", "You have not booked any bed yet!");
                }

                token = JWTUtil.getJWT(String.valueOf(userID));

                responseBody.put("access-token", token);

                this.tokenService.addOrUpdateToken(userID, token);
            }
            else
            {
                response.put("StatusCode", 401);

                response.put("StatusMessage", "Unauthorized");

                responseBody.put("message", "Logged Out! You may be logged in from other device!");
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
