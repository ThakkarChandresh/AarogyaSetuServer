package in.gov.aarogyasetu.server.model;

import in.gov.aarogyasetu.server.util.UtilityMethods;


public class Hospital
{

    private final int hospitalID = UtilityMethods.getUniqueId();

    private String hospitalName;

    private String doctorName;

    private String city;

    private long contactNumber;

    private int availableBeds;

    public Hospital(String hospitalName, String doctorName, String city, long doctorContactNumber, int availableBeds)
    {

        this.hospitalName = hospitalName;

        this.doctorName = doctorName;

        this.city = city;

        this.contactNumber = doctorContactNumber;

        this.availableBeds = availableBeds;
    }

    public int getHospitalID()
    {

        return hospitalID;
    }

    public String getHospitalName()
    {

        return hospitalName;
    }

    public void setHospitalName(String hospitalName)
    {

        this.hospitalName = hospitalName;
    }

    public String getDoctorName()
    {

        return doctorName;
    }

    public void setDoctorName(String doctorName)
    {

        this.doctorName = doctorName;
    }

    public String getCity()
    {

        return city;
    }

    public void setCity(String city)
    {

        this.city = city;
    }

    public long getContactNumber()
    {

        return contactNumber;
    }

    public void setContactNumber(long contactNumber)
    {

        this.contactNumber = contactNumber;
    }

    public int getAvailableBeds()
    {

        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds)
    {

        this.availableBeds = availableBeds;
    }

}
