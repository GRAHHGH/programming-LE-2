package HealthCare_Users;

public class Doctor extends User{

    private int maxPatients;
    private String specialization;
    private boolean canAdmitPatients;
    private boolean canDiagnose;

    public Doctor(String name, int age, String userID, int maxPatients, String specialization, boolean canAdmitPatients, boolean canDiagnose) {
        super(name, age, userID);
        setMaxPatients(maxPatients);
        this.specialization = specialization;
        this.canAdmitPatients = canAdmitPatients;
        this.canDiagnose = canDiagnose;
    }

    @Override
    public void treatPatient(Patient patient) {
        System.out.println("\n=== DOCTOR ACTION PANEL ===");
        System.out.println("Dr. " + getName() + " is reviewing Patient: " + patient.getName());
        
        if (getCanDiagnose()) {
            System.out.println(" -> Action: Diagnosing patient illness...");
            patient.setIsDiagnosed(true); 
            System.out.println(" -> Result: Patient has been marked as DIAGNOSED.");
        } else {
            System.out.println(" -> Note: Not authorized to diagnose.");
        }
        
        if (getCanAdmitPatients()) {
            System.out.println(" -> Action: Approving patient for hospital admission...");
        }
        System.out.println("===========================");
    }

    @Override
    public String toString() {
        return "\n--- Doctor Profile --- \n" + 
            super.toString() + 
            "\nSpecialization: " + specialization + " | Max Patients: " + maxPatients;
    }
    
    @Override
    public String getRole() {
        return "Doctor";
    }

    public void setMaxPatients(int maxPatients){
        if(maxPatients > 10 || maxPatients < 0){
            throw new IllegalArgumentException("Doctor can only have between 0 and 10 patients.");
        }
        this.maxPatients = maxPatients;
    }
    public int getMaxPatients(){
        return maxPatients;
    }

    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public String getSpecialization(){
        return specialization;
    }

    public void setCanAdmitPatients(boolean canAdmitPatients){
        this.canAdmitPatients = canAdmitPatients;
    }
    public boolean getCanAdmitPatients(){
        return canAdmitPatients;
    }

    public void setCanDiagnose(boolean canDiagnose){
        this.canDiagnose = canDiagnose;
    }
    public boolean getCanDiagnose(){
        return canDiagnose;
    }
    
}
