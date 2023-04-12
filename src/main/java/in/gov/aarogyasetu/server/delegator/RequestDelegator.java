package in.gov.aarogyasetu.server.delegator;

import in.gov.aarogyasetu.server.controller.AreaController;
import in.gov.aarogyasetu.server.controller.CoronaStatusController;
import in.gov.aarogyasetu.server.controller.FacilityController;
import in.gov.aarogyasetu.server.controller.UserController;
import org.json.JSONObject;


public class RequestDelegator
{

    public static JSONObject delegateRequest(JSONObject request)
    {

        String choice = request.getString("RequestCode");

        switch (choice)
        {
            case "0" ->
            {
                return CoronaStatusController.getInstance().getAllQuestions();
            }

            case "1" ->
            {
                return CoronaStatusController.getInstance().getCoronaStatus(request.getJSONObject("RequestBody").getJSONArray("answers").toList());
            }

            case "2" ->
            {
                return AreaController.getInstance().getActiveCases(request.getJSONObject("RequestBody").getString("area"));
            }

            case "3" ->
            {
                return UserController.getInstance().login(request.getJSONObject("RequestBody").getJSONObject("userCredentials").toMap());
            }

            case "4" ->
            {
                return UserController.getInstance().logout(request.getJSONObject("RequestBody").getString("token"));
            }

            case "5" ->
            {
                return UserController.getInstance().register(request.getJSONObject("RequestBody").getJSONObject("userDetails").toMap());
            }

            case "6" ->
            {
                return FacilityController.getInstance().getHospitalsList(request.getJSONObject("RequestBody").getBoolean("filterByArea"), request.getJSONObject("RequestBody").getString("token"));
            }
            case "7" ->
            {
                return FacilityController.getInstance().bookBed(request.getJSONObject("RequestBody").getInt("hospitalID"), request.getJSONObject("RequestBody").getString("token"));
            }
            case "8" ->
            {
                return FacilityController.getInstance().checkOutBed(request.getJSONObject("RequestBody").getString("token"));
            }
            default ->
            {
                return new JSONObject().put("StatusCode", 400).put("StatusMessage", "Bad Request").put("ResponseBody", new JSONObject().put("message", "Invalid Request Code!"));
            }

        }

    }

}
