package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.repository.QuestionRepository;
import in.gov.aarogyasetu.server.repository.QuestionRepositoryImpl;

import java.util.List;


public class QuestionServiceImpl implements QuestionService
{

    // Singleton Architecture
    private QuestionServiceImpl()
    {

    }

    private static QuestionServiceImpl questionServiceImplInstance = null;

    // Factory Method
    public static QuestionServiceImpl getInstance()
    {

        if (questionServiceImplInstance == null)
        {

            questionServiceImplInstance = new QuestionServiceImpl();

        }

        return questionServiceImplInstance;

    }

    private final QuestionRepository questionRepository = QuestionRepositoryImpl.getInstance();

    @Override
    public List<String> getAllQuestions()
    {

        return this.questionRepository.getAllQuestions();
    }

    @Override
    public boolean isCoronaPositive(List<Object> answers)
    {

        return answers.stream().filter(answer -> answer.toString().equalsIgnoreCase("Yes")).count() >= this.questionRepository.getMinPositiveAnswerCount();

    }

}
