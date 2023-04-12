package in.gov.aarogyasetu.server.repository;

public interface AreaRepository
{

    Integer getActiveCases(String area);

    void addArea(String area, int activeCase);

    void updateActiveCases(String area, int updatedActiveCases);

}
