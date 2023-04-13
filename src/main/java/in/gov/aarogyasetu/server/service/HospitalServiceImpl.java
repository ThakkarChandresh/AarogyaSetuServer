package in.gov.aarogyasetu.server.service;

import in.gov.aarogyasetu.server.model.Hospital;
import in.gov.aarogyasetu.server.model.User;
import in.gov.aarogyasetu.server.repository.HospitalRepository;
import in.gov.aarogyasetu.server.repository.HospitalRepositoryImpl;

import java.util.List;
import java.util.stream.Collectors;


public class HospitalServiceImpl implements HospitalService
{

    private HospitalServiceImpl()
    {

    }

    private static HospitalServiceImpl hospitalServiceInstance = null;

    public static HospitalServiceImpl getInstance()
    {

        if (hospitalServiceInstance == null)
        {
            hospitalServiceInstance = new HospitalServiceImpl();
        }
        return hospitalServiceInstance;
    }

    private final HospitalRepository hospitalRepository = HospitalRepositoryImpl.getInstance();

    private final UserService userService = UserServiceImpl.getInstance();

    @Override
    public List<Hospital> getHospitals(boolean filterByCity, int userID)
    {

        if (filterByCity)
        {
            return this.hospitalRepository.getAllHospitals().stream().filter(hospital -> hospital.getCity().equalsIgnoreCase(this.userService.getUser(userID).getCity())).collect(Collectors.toList());
        }
        else
        {
            return this.hospitalRepository.getAllHospitals();
        }
    }

    @Override
    public Hospital getHospitalInformation(int hospitalID)
    {

        return this.hospitalRepository.getHospitalInformation(hospitalID);
    }

    @Override
    public boolean bookBed(int userID, int hospitalID)
    {

        boolean result = false;

        int availableBeds = this.hospitalRepository.getAvailableBeds(hospitalID);

        if (availableBeds > 0)
        {
            User user = this.userService.getUser(userID);

            user.setAdmittedToHospital(hospitalID);

            this.userService.updateUser(user);

            this.hospitalRepository.updateBeds(hospitalID, --availableBeds);

            result = true;
        }
        return result;
    }

    @Override
    public void checkOutBed(int userID, int hospitalID)
    {

        int availableBeds = this.hospitalRepository.getAvailableBeds(hospitalID);

        User user = this.userService.getUser(userID);

        user.setAdmittedToHospital(-1);

        this.userService.updateUser(user);

        this.hospitalRepository.updateBeds(hospitalID, ++availableBeds);

    }

}
