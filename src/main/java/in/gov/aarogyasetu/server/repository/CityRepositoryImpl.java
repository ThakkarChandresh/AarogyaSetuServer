package in.gov.aarogyasetu.server.repository;

import java.util.HashMap;


public class CityRepositoryImpl implements CityRepository
{

    // Singleton Architecture
    private CityRepositoryImpl()
    {

    }

    private static CityRepositoryImpl cityRepositoryInstance = null;

    // Factory Method
    public static CityRepositoryImpl getInstance()
    {

        if (cityRepositoryInstance == null)
        {

            cityRepositoryInstance = new CityRepositoryImpl();

        }

        return cityRepositoryInstance;

    }

    private final HashMap<String, Integer> citys = new HashMap<>();

    @Override
    public synchronized Integer getActiveCases(String city)
    {

        return citys.get(city);
    }

    @Override
    public synchronized void addCity(String city, int activeCase)
    {

        citys.put(city, activeCase);

    }

    @Override
    public synchronized void updateActiveCases(String city, int updatedActiveCases)
    {

        citys.put(city, updatedActiveCases);

    }

}
