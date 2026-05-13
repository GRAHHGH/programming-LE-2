package HealthCare_Users;

public class Patient extends User{

    // patients information
    private String patientID;
    private String bloodType;
    private boolean isDiagnosed;
    private boolean isMedicationAdministered;

    // patients vitals
    private int heartRate;
    private String bloodPressure;

    public Patient(String patientID, String bloodType, String name, int age, String userID){
        super(name, age, userID);
        this.patientID = patientID;
        this.bloodType = bloodType;
        this.heartRate = 0;
        this.bloodPressure = "N/A";

        this.isDiagnosed = false;
        this.isMedicationAdministered = false;
    }

    @Override
    public String toString() {
        String diagStatus = isDiagnosed ? "YES" : "NO";
        String medStatus = isMedicationAdministered ? "YES" : "NO";

        return "\n--- Patient Record: " + patientID + " ---\n" + 
               super.toString() + " | Blood Type: " + bloodType + "\n" +
               "Vitals -> HR: " + heartRate + " bpm | BP: " + bloodPressure + "\n" +
               "[Checklist] Diagnosed: " + diagStatus + " | Meds Administered: " + medStatus;
    }

    @Override
    public void treatPatient(Patient patient) {
        throw new UnsupportedOperationException("Unimplemented method 'treatPatient'");
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

    public void setIsDiagnosed(boolean isDiagnosed) {
        this.isDiagnosed = isDiagnosed;
    }
    
    public boolean getIsDiagnosed() {
        return isDiagnosed;
    }

    public void setIsMedicationAdministered(boolean isMedicationAdministered) {
        this.isMedicationAdministered = isMedicationAdministered;
    }

    public boolean getIsMedicationAdministered() {
        return isMedicationAdministered;
    }

}
