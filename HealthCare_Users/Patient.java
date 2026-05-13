package HealthCare_Users;

import Bill.Billable;

public class Patient extends User implements Billable{

    // patients information
    private String patientID;
    private String bloodType;
    private boolean isDiagnosed;
    private boolean isMedicationAdministered;
    private boolean isEmergency;
    private boolean isAdmitted;

    // patients vitals
    private int heartRate;
    private String bloodPressure;

    public Patient(String patientID, String bloodType, String name, int age, String userID, boolean isEmergency){
        super(name, age, userID);
        this.patientID = patientID;
        this.bloodType = bloodType;
        this.isEmergency = isEmergency;
        this.heartRate = 0;
        this.bloodPressure = "N/A";

        this.isDiagnosed = false;
        this.isMedicationAdministered = false;
        this.isAdmitted = false;
    }

    public Patient(String patientID, String name, int age, String userID, boolean isEmergency) {
        this(patientID, "Unknown", name, age, userID, isEmergency);
    }

    @Override
    public double calculateBill() {
        double total = 0.0;
        
        total += 500.0; // Base fee for walking into the hospital
        
        // Add charges based on their encapsulated checklist!
        if (this.getIsEmergency()) total += 1500.0;
        if (this.getIsDiagnosed()) total += 800.0;
        if (this.getIsMedicationAdministered()) total += 300.0;
        if (this.getIsAdmitted()) total += 2500.0;
        
        return total;
    }
    @Override
    public void printInvoice() {
        System.out.println("\n=================================");
        System.out.println("   HOSPITAL INVOICE: " + this.getName());
        System.out.println("=================================");
        System.out.println("Emergency Charge: " + (this.getIsEmergency() ? "$1500.00" : "$0.00"));
        System.out.println("Diagnosis Fee:    " + (this.getIsDiagnosed() ? "$800.00" : "$0.00"));
        System.out.println("Medication Fee:   " + (this.getIsMedicationAdministered() ? "$300.00" : "$0.00"));
        System.out.println("Admission Room:   " + (this.getIsAdmitted() ? "$2500.00" : "$0.00"));
        System.out.println("---------------------------------");
        System.out.println("TOTAL DUE:        $" + calculateBill());
        System.out.println("=================================\n");
    }

    @Override
    public String toString() {
        String diagStatus = isDiagnosed ? "YES" : "NO";
        String medStatus = isMedicationAdministered ? "YES" : "NO";
        String admitStatus = isAdmitted ? "YES" : "NO";
        String emergencyAlert = isEmergency ? "[EMERGENCY PATIENT] " : "[Standard Care] ";

        return "\n--- " + emergencyAlert + "Record: " + patientID + " ---\n" + 
               super.toString() + " | Blood Type: " + bloodType + "\n" +
               "Vitals -> HR: " + heartRate + " bpm | BP: " + bloodPressure + "\n" +
               "[Checklist] Diagnosed: " + diagStatus + " | Meds Administered: " + medStatus + " | Admitted: " + admitStatus;
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

    public void setIsMedicationAdministered(boolean isMedicationAdministered){
        this.isMedicationAdministered = isMedicationAdministered;
    }

    public boolean getIsMedicationAdministered(){
        return isMedicationAdministered;
    }

    public void setIsAdmitted(boolean isAdmitted){ 
        this.isAdmitted = isAdmitted; 
    }
    public boolean getIsAdmitted() { 
        return isAdmitted; 
    }

    public void setIsEmergency(boolean isEmergency){ 
        this.isEmergency = isEmergency; 
    }
    public boolean getIsEmergency(){ 
        return isEmergency; 
    }


}
