package in.gov.aarogyasetu.server.service;

public interface CityService
{

    int getActiveCases(String city);

    void addCity(String city, int activeCases);

    void updateActiveCases(String city, int updatedActiveCases);

}
