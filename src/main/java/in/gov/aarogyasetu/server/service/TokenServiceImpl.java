package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.repository.TokenRepository;
import in.gov.aarogyasetu.server.repository.TokenRepositoryImpl;


public class TokenServiceImpl implements TokenService
{

    private TokenServiceImpl()
    {

    }

    private static TokenServiceImpl tokenServiceInstance = null;

    private final TokenRepository tokenRepository = TokenRepositoryImpl.getInstance();

    public static TokenServiceImpl getInstance()
    {

        if (tokenServiceInstance == null)
        {
            tokenServiceInstance = new TokenServiceImpl();
        }
        return tokenServiceInstance;
    }

    @Override
    public String getToken(int userID)
    {

        return tokenRepository.getToken(userID);
    }

    @Override
    public void addOrUpdateToken(int userID, String token)
    {

        this.tokenRepository.addOrUpdateToken(userID, token);
    }

    @Override
    public void removeToken(int userID)
    {

        this.tokenRepository.removeToken(userID);
    }

}
