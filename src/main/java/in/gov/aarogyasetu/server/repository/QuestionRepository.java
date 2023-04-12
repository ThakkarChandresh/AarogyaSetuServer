package in.gov.aarogyasetu.server.repository;

import java.util.List;


public interface QuestionRepository
{

    List<String> getAllQuestions();

    int getMinPositiveAnswerCount();

}
