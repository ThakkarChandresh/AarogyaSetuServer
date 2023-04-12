package in.gov.aarogyasetu.server.repository;

import in.gov.aarogyasetu.server.model.Hospital;

import java.util.List;


public interface HospitalRepository
{

    List<Hospital> getAllHospitals();

    int getAvailableBeds(int hospitalID);

    void updateBeds(int hospitalID, int beds);

    Hospital getHospitalInformation(int hospitalID);

}
