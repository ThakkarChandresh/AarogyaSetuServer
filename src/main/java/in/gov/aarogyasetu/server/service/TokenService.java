package in.gov.aarogyasetu.server.service;

public interface TokenService
{

    String getToken(int userID);

    void addOrUpdateToken(int userID, String token);

    void removeToken(int userID);

}
