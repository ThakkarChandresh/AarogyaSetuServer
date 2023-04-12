package in.gov.aarogyasetu.server.repository;

import java.util.ArrayList;
import java.util.List;


public class QuestionRepositoryImpl implements QuestionRepository
{

    // Singleton Architecture
    private QuestionRepositoryImpl()
    {

        questions.add("1.Have you been in close contact with a confirmed case of Covid-19? (Yes/No)");

        questions.add("2.Have you travelled corona affected area in last 14 days? (Yes/No)");

        questions.add("3.Is your body temperature above 99°F? (Yes/No)");

        questions.add("4.Do you have dry cough or runny nose or headache or difficulty in breathing? (Yes/No)");

        questions.add("5.Do you observe these symptoms since last 48 hours or more? (Yes/No)");

        questions.add("6.Do you have asthma or cancer or diabetes from before? (Yes/No)");

    }

    private static QuestionRepositoryImpl questionRepositoryInstance = null;

    // Factory Method
    public static QuestionRepositoryImpl getInstance()
    {

        if (questionRepositoryInstance == null)
        {

            questionRepositoryInstance = new QuestionRepositoryImpl();

        }

        return questionRepositoryInstance;

    }

    private final List<String> questions = new ArrayList<>();

    @Override
    public List<String> getAllQuestions()
    {

        return new ArrayList<>(questions);
    }

    @Override
    public int getMinPositiveAnswerCount()
    {

        return 4;
    }

}
