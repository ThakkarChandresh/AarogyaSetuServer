package in.gov.aarogyasetu.server.service;

import java.util.List;


public interface QuestionService
{

    List<String> getAllQuestions();

    boolean isCoronaPositive(List<Object> answers);

}
