package in.gov.aarogyasetu.server.repository;

public interface CityRepository
{

    Integer getActiveCases(String city);

    void addCity(String city, int activeCase);

    void updateActiveCases(String city, int updatedActiveCases);

}
