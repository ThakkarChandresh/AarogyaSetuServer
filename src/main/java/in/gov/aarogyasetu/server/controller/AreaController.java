package in.gov.aarogyasetu.server.controller;

import in.gov.aarogyasetu.server.service.AreaService;
import in.gov.aarogyasetu.server.service.AreaServiceImpl;
import org.json.JSONObject;


public class AreaController
{

    private AreaController()
    {

    }

    private static AreaController areaControllerInstance = null;

    public static AreaController getInstance()
    {

        if (areaControllerInstance == null)
        {

            areaControllerInstance = new AreaController();

        }

        return areaControllerInstance;
    }


    private final AreaService areaService = AreaServiceImpl.getInstance();

    public JSONObject getActiveCases(String area)
    {

        JSONObject response = new JSONObject();

        try
        {
            response.put("StatusCode", 200);

            response.put("StatusMessage", "OK");

            response.put("ResponseBody", new JSONObject().put("activeCases", this.areaService.getActiveCases(area)));

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
