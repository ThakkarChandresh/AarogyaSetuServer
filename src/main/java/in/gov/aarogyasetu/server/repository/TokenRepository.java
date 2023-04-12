package in.gov.aarogyasetu.server.repository;

public interface TokenRepository
{

    String getToken(int userID);

    void addOrUpdateToken(int userID, String token);

    void removeToken(int userID);

}
