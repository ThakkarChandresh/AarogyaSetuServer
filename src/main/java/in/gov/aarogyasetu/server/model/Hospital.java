package in.gov.aarogyasetu.server.model;

import in.gov.aarogyasetu.server.util.BaseMethods;


public class Hospital
{

    private final int hospitalID = BaseMethods.getUniqueId();

    private String hospitalName;

    private String doctorName;

    private String area;

    private long contactNumber;

    private int availableBeds;

    public Hospital(String hospitalName, String doctorName, String area, long doctorContactNumber, int availableBeds)
    {

        this.hospitalName = hospitalName;

        this.doctorName = doctorName;

        this.area = area;

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

    public String getArea()
    {

        return area;
    }

    public void setArea(String area)
    {

        this.area = area;
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
