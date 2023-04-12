package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.repository.AreaRepository;
import in.gov.aarogyasetu.server.repository.AreaRepositoryImpl;


public class AreaServiceImpl implements AreaService
{

    // Singleton Architecture
    private AreaServiceImpl()
    {

    }

    private static AreaServiceImpl areaServiceImplInstance = null;

    // Factory Method
    public static AreaServiceImpl getInstance()
    {

        if (areaServiceImplInstance == null)
        {

            areaServiceImplInstance = new AreaServiceImpl();

        }

        return areaServiceImplInstance;

    }

    private final AreaRepository areaRepository = AreaRepositoryImpl.getInstance();

    @Override
    public int getActiveCases(String area)
    {

        if (areaRepository.getActiveCases(area) == null)
        {

            this.areaRepository.addArea(area, 0);

        }

        return this.areaRepository.getActiveCases(area);

    }

    @Override
    public void addArea(String area, int activeCases)
    {

        this.areaRepository.addArea(area, activeCases);

    }

    @Override
    public void updateActiveCases(String area, int updatedActiveCases)
    {

        this.areaRepository.updateActiveCases(area, updatedActiveCases);

    }


}
