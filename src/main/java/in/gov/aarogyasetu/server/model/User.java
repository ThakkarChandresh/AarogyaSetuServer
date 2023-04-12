package in.gov.aarogyasetu.server.model;

import in.gov.aarogyasetu.server.util.BaseMethods;


public class User
{

    private final int userID = BaseMethods.getUniqueId();

    private String fullName;

    private long contactNumber;

    private String area;

    private String symptoms;

    private String medicines;

    private String status;

    private String password;

    private int admittedToHospital = -1;

    public User(String fullName, long contactNumber, String area, String symptoms, String medicines, String status, String password)
    {

        this.fullName = fullName;

        this.contactNumber = contactNumber;

        this.area = area;

        this.symptoms = symptoms;

        this.medicines = medicines;

        this.status = status;

        this.password = password;
    }

    public int getUserId()
    {

        return userID;
    }

    public String getFullName()
    {

        return fullName;
    }

    public void setFullName(String fullName)
    {

        this.fullName = fullName;
    }

    public long getContactNumber()
    {

        return contactNumber;
    }

    public void setContactNumber(long contactNumber)
    {

        this.contactNumber = contactNumber;
    }

    public String getArea()
    {

        return area;
    }

    public void setArea(String area)
    {

        this.area = area;
    }

    public String getSymptoms()
    {

        return symptoms;
    }

    public void setSymptoms(String symptoms)
    {

        this.symptoms = symptoms;
    }

    public String getMedicines()
    {

        return medicines;
    }

    public void setMedicines(String medicines)
    {

        this.medicines = medicines;
    }

    public String getStatus()
    {

        return status;
    }

    public void setStatus(String status)
    {

        this.status = status;
    }

    public String getPassword()
    {

        return password;
    }

    public void setPassword(String password)
    {

        this.password = password;
    }

    public int getAdmittedToHospital()
    {

        return admittedToHospital;
    }

    public void setAdmittedToHospital(int admittedToHospital)
    {

        this.admittedToHospital = admittedToHospital;
    }

}
