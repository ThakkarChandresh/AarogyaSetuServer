package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.model.Hospital;

import java.util.List;


public interface HospitalService
{

    List<Hospital> getHospitals(boolean filterByArea, int userID);

    Hospital getHospitalInformation(int hospitalID);

    boolean bookBed(int userID, int hospitalID);

    void checkOutBed(int userID, int hospitalID);

}
