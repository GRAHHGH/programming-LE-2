package HealthCare_Users;

public class Nurse extends User {

    private boolean canCheckBP;
    private boolean canAdministerMedicine;

    public Nurse(String name, int age, String userID, boolean canCheckBP, boolean canAdministerMedicine) {
        super(name, age, userID);
        this.canCheckBP = canCheckBP;
        this.canAdministerMedicine = canAdministerMedicine;
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    @Override
    public String toString() {
        return "\n--- Nurse Profile: " + getName() + " ---\n" + 
               super.toString() + "\n" +
               "Can Check BP: " + canCheckBP + " | Can Administer Meds: " + canAdministerMedicine;
    }

    @Override
    public void treatPatient(Patient patient) {
        System.out.println("\n=== NURSE ACTION PANEL ===");
        System.out.println("Nurse " + getName() + " is attending to Patient: " + patient.getName());
        
        if (getCanCheckBP()) {
            System.out.println(" -> Action: Taking new Blood Pressure and Heart Rate vitals...");
            patient.setHeartRate((int)(Math.random() * 40) + 60); 
            patient.setBloodPressure("120/80"); 
        }
        
        if (getCanAdministerMedicine()) {
            System.out.println(" -> Action: Administering scheduled medications...");
            patient.setIsMedicationAdministered(true);
            System.out.println(" -> Result: Patient medication marked as ADMINISTERED.");
        }
        System.out.println("==========================");
    }
    public void setCanCheckBP(boolean canCheckBP){
        this.canCheckBP = canCheckBP;
    }
    
    public boolean getCanCheckBP(){ 
        return canCheckBP;
    }
    
    public void setCanAdministerMedicine(boolean canAdministerMedicine){
        this.canAdministerMedicine = canAdministerMedicine;
    }
    
    public boolean getCanAdministerMedicine(){
        return canAdministerMedicine;
    }

}