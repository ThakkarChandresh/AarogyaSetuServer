package in.gov.aarogyasetu.server.controller;

import in.gov.aarogyasetu.server.service.QuestionService;
import in.gov.aarogyasetu.server.service.QuestionServiceImpl;
import org.json.JSONObject;

import java.util.List;


public class CoronaStatusController
{

    private CoronaStatusController()
    {

    }

    private static CoronaStatusController coronaStatusControllerInstance = null;

    public static CoronaStatusController getInstance()
    {

        if (coronaStatusControllerInstance == null)
        {

            coronaStatusControllerInstance = new CoronaStatusController();

        }

        return coronaStatusControllerInstance;
    }

    private final QuestionService questionService = QuestionServiceImpl.getInstance();

    public JSONObject getAllQuestions()
    {

        JSONObject response = new JSONObject();

        try
        {
            response.put("StatusCode", 200);

            response.put("StatusMessage", "OK");

            response.put("ResponseBody", new JSONObject().put("questions", this.questionService.getAllQuestions()));
        }
        catch (Exception exception)
        {
            response.put("StatusCode", 500);

            response.put("StatusMessage", "Internal Server Error");
        }
        return response;
    }

    public JSONObject getCoronaStatus(List<Object> answers)
    {

        JSONObject response = new JSONObject();

        try
        {
            response.put("StatusCode", 200);

            response.put("StatusMessage", "OK");

            response.put("ResponseBody", new JSONObject().put("result", this.questionService.isCoronaPositive(answers)));

        }
        catch (Exception exception)
        {
            response.put("StatusCode", 500);

            response.put("StatusMessage", "Internal Server Error");
        }
        return response;
    }

}
