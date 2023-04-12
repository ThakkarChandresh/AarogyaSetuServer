package in.gov.aarogyasetu.server.util;

import in.gov.aarogyasetu.server.repository.TokenRepository;
import in.gov.aarogyasetu.server.repository.TokenRepositoryImpl;

import java.util.concurrent.atomic.AtomicInteger;


public class BaseMethods
{

    private static final AtomicInteger ID = new AtomicInteger(1000);

    private final static TokenRepository TOKEN_REPOSITORY = TokenRepositoryImpl.getInstance();

    public static int getUniqueId()
    {

        return ID.getAndIncrement();

    }

    public static int validateToken(String token)
    {

        int result = -1;

        if (token != null)
        {
            int userId = Integer.parseInt(JWTUtil.validateToken(token));

            if (TOKEN_REPOSITORY.getToken(userId).equals(token))
            {
                result = userId;
            }

        }
        return result;
    }

}
