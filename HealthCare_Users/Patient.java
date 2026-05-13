package HealthCare_Users;

public class Patient extends User{

    // patients information
    private String patientID;
    private String bloodType;

    // patients vitals
    private int heartRate;
    private String bloodPressure;

    public Patient(String patientID, String bloodType, String name, int age, String userID){
        super(name, age, userID);
        this.patientID = patientID;
        this.bloodType = bloodType;
        this.heartRate = 0;
        this.bloodPressure = "N/A";
    }

    @Override
    public String toString() {
        return "\n--- Patient Record: " + patientID + " ---\n" + 
               super.toString() + " | Blood Type: " + bloodType + "\n" +
               "Vitals -> HR: " + heartRate + " bpm | BP: " + bloodPressure;
    }

    //getters and setters
    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public String getPatientID(){
        return patientID;
    }

    public void setBloodType(String bloodType){
        this.bloodType = bloodType;
    }

    public String getBloodType(){
        return bloodType;
    }

    public void setHeartRate(int heartRate){
        this.heartRate = heartRate;
    }

    public int getHeartRate(){
        return heartRate;
    }

    public void setBloodPressure(String bloodPressure){
        this.bloodPressure = bloodPressure;
    }

    public String getBloodPressure(){
        return bloodPressure;
    }

    @Override
    public String getRole() {
        return "Patient";
    }


}
