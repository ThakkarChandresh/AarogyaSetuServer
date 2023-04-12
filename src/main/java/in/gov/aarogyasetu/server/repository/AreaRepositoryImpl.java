package in.gov.aarogyasetu.server.repository;

import java.util.HashMap;


public class AreaRepositoryImpl implements AreaRepository
{

    // Singleton Architecture
    private AreaRepositoryImpl()
    {

    }

    private static AreaRepositoryImpl areaRepositoryInstance = null;

    // Factory Method
    public static AreaRepositoryImpl getInstance()
    {

        if (areaRepositoryInstance == null)
        {

            areaRepositoryInstance = new AreaRepositoryImpl();

        }

        return areaRepositoryInstance;

    }

    private final HashMap<String, Integer> areas = new HashMap<>();

    @Override
    public synchronized Integer getActiveCases(String area)
    {

        return areas.get(area);
    }

    @Override
    public synchronized void addArea(String area, int activeCase)
    {

        areas.put(area, activeCase);

    }

    @Override
    public synchronized void updateActiveCases(String area, int updatedActiveCases)
    {

        areas.put(area, updatedActiveCases);

    }

}
