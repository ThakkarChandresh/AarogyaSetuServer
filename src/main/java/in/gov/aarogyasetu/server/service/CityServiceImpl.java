package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.repository.CityRepository;
import in.gov.aarogyasetu.server.repository.CityRepositoryImpl;


public class CityServiceImpl implements CityService
{

    // Singleton Architecture
    private CityServiceImpl()
    {

    }

    private static CityServiceImpl cityServiceImplInstance = null;

    // Factory Method
    public static CityServiceImpl getInstance()
    {

        if (cityServiceImplInstance == null)
        {

            cityServiceImplInstance = new CityServiceImpl();

        }

        return cityServiceImplInstance;

    }

    private final CityRepository cityRepository = CityRepositoryImpl.getInstance();

    @Override
    public int getActiveCases(String city)
    {

        if (cityRepository.getActiveCases(city) == null)
        {

            this.cityRepository.addCity(city, 0);

        }

        return this.cityRepository.getActiveCases(city);

    }

    @Override
    public void addCity(String city, int activeCases)
    {

        this.cityRepository.addCity(city, activeCases);

    }

    @Override
    public void updateActiveCases(String city, int updatedActiveCases)
    {

        this.cityRepository.updateActiveCases(city, updatedActiveCases);

    }


}
