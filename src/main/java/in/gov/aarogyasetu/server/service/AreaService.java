package in.gov.aarogyasetu.server.service;

public interface AreaService
{

    int getActiveCases(String area);

    void addArea(String area, int activeCases);

    void updateActiveCases(String area, int updatedActiveCases);

}
