package in.gov.aarogyasetu.server.repository;

import java.util.HashMap;


public class TokenRepositoryImpl implements TokenRepository
{

    private TokenRepositoryImpl()
    {

    }

    private static TokenRepositoryImpl tokenRepositoryInstance = null;

    public static TokenRepositoryImpl getInstance()
    {

        if (tokenRepositoryInstance == null)
        {

            tokenRepositoryInstance = new TokenRepositoryImpl();

        }

        return tokenRepositoryInstance;
    }

    private final HashMap<Integer, String> tokens = new HashMap<>();

    @Override
    public synchronized String getToken(int userID)
    {

        return this.tokens.get(userID);
    }

    @Override
    public synchronized void addOrUpdateToken(int userID, String token)
    {

        this.tokens.put(userID, token);
    }

    @Override
    public synchronized void removeToken(int userID)
    {

        this.tokens.remove(userID);
    }

}
