package in.gov.aarogyasetu.server.controller;

import in.gov.aarogyasetu.server.service.CityService;
import in.gov.aarogyasetu.server.service.CityServiceImpl;
import org.json.JSONObject;


public class CityController
{

    private CityController()
    {

    }

    private static CityController cityControllerInstance = null;

    public static CityController getInstance()
    {

        if (cityControllerInstance == null)
        {

            cityControllerInstance = new CityController();

        }

        return cityControllerInstance;
    }


    private final CityService cityService = CityServiceImpl.getInstance();

    public JSONObject getActiveCases(String city)
    {

        JSONObject response = new JSONObject();

        try
        {
            response.put("StatusCode", 200);

            response.put("StatusMessage", "OK");

            response.put("ResponseBody", new JSONObject().put("activeCases", this.cityService.getActiveCases(city)));

            return response;
        }
        catch (Exception exception)
        {
            response.put("StatusCode", 500);

            response.put("StatusMessage", "Internal Server Error!");

            return response;
        }
    }

}
