package in.gov.aarogyasetu.server.repository;

import in.gov.aarogyasetu.server.exceptions.NoSuchHospitalException;
import in.gov.aarogyasetu.server.model.Hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HospitalRepositoryImpl implements HospitalRepository
{

    private HospitalRepositoryImpl()
    {

        Hospital hospitalOne = new Hospital("Zydus Hospitals", "Dr. Chandresh", "Ahmedabad", 8401547875L, 10);

        hospitals.put(hospitalOne.getHospitalID(), hospitalOne);

        Hospital hospitalTwo = new Hospital("Jivraj Mehta", "Dr. Deven", "Ahmedabad", 8401547876L, 20);

        hospitals.put(hospitalTwo.getHospitalID(), hospitalTwo);

        Hospital hospitalThree = new Hospital("Marengo CIMS Hospital", "Dr. Mihir", "Ahmedabad", 8401547877L, 5);

        hospitals.put(hospitalThree.getHospitalID(), hospitalThree);

        Hospital hospitalFour = new Hospital("Sagar Hospital", "Dr. Sagar", "Surat", 8401547878L, 30);

        hospitals.put(hospitalFour.getHospitalID(), hospitalFour);

        Hospital hospitalFive = new Hospital("Ansh Women Hospital", "Dr. Ansh", "Surat", 8401547879L, 15);

        hospitals.put(hospitalFive.getHospitalID(), hospitalFive);

        Hospital hospitalSix = new Hospital("Jankalyan Hospital", "Dr. Purvi", "Rajkot", 8401547881L, 29);

        hospitals.put(hospitalSix.getHospitalID(), hospitalSix);

        Hospital hospitalSeven = new Hospital("Gujarat Child Care Hospital", "Dr. Manas", "Vadodra", 8401547882L, 22);

        hospitals.put(hospitalSeven.getHospitalID(), hospitalSeven);
    }

    private static HospitalRepositoryImpl hospitalRepositoryInstance = null;

    public static HospitalRepositoryImpl getInstance()
    {

        if (hospitalRepositoryInstance == null)
        {
            hospitalRepositoryInstance = new HospitalRepositoryImpl();
        }
        return hospitalRepositoryInstance;
    }

    private final HashMap<Integer, Hospital> hospitals = new HashMap<>();

    @Override
    public synchronized List<Hospital> getAllHospitals()
    {

        return new ArrayList<>(this.hospitals.values());
    }

    @Override
    public synchronized int getAvailableBeds(int hospitalID)
    {

        if (this.hospitals.get(hospitalID) == null)
        {
            throw new NoSuchHospitalException("No Hospital With Given Id!");
        }
        return this.hospitals.get(hospitalID).getAvailableBeds();
    }

    @Override
    public synchronized void updateBeds(int hospitalID, int beds)
    {

        this.hospitals.get(hospitalID).setAvailableBeds(beds);

    }

    @Override
    public Hospital getHospitalInformation(int hospitalID)
    {

        return this.hospitals.get(hospitalID);
    }

}
