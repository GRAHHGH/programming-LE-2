package HealthCare_Users;

import java.util.Scanner;

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
        // Local scanner for the Nurse's menu
        Scanner scanner = new Scanner(System.in);
        boolean viewingPatient = true;

        while (viewingPatient) {
            System.out.println("\n=== NURSE ACTION PANEL ===");
            System.out.println("Nurse " + getName() + " is attending to Patient: " + patient.getName());
            
            // Build the menu based on Nurse permissions
            if (getCanCheckBP()) {
                System.out.println("[1] Take Vitals (Blood Pressure & Heart Rate)");
            }
            if (getCanAdministerMedicine()) {
                System.out.println("[2] Administer Scheduled Medication");
            }
            System.out.println("[3] Finish & Return to Dashboard");
            System.out.print("Select an action: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    if (getCanCheckBP()) {
                        // Simulate taking vitals with random numbers!
                        int randomHR = (int)(Math.random() * 40) + 60; // Random HR between 60-100
                        patient.setHeartRate(randomHR);
                        patient.setBloodPressure("120/80"); // Standard BP for simplicity
                        System.out.println(" -> Result: Vitals updated successfully. (HR: " + randomHR + ", BP: 120/80)");
                    } else {
                        System.out.println(" -> Error: You lack permissions to take vitals.");
                    }
                    break;
                    
                case "2":
                    if (getCanAdministerMedicine()) {
                        // Change the Patient's state!
                        patient.setIsMedicationAdministered(true);
                        System.out.println(" -> Result: Patient medication officially marked as ADMINISTERED.");
                    } else {
                        System.out.println(" -> Error: You lack permissions to administer medicine.");
                    }
                    break;
                    
                case "3":
                    System.out.println("Closing Nurse Panel...");
                    viewingPatient = false; 
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
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