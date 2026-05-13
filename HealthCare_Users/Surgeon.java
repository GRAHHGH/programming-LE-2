package HealthCare_Users;

import java.util.Scanner;

// LEVEL 3 INHERITANCE: Surgeon extends Doctor (which extends User)
public class Surgeon extends Doctor {

    // Unique encapsulated fields just for Surgeons
    private String operatingRoom;
    private boolean isOperating;

    public Surgeon(String name, int age, String userID, int maxPatients, String specialization, boolean canAdmitPatients, boolean canDiagnose, String operatingRoom) {
        // The 'super' keyword calls the Doctor constructor!
        super(name, age, userID, maxPatients, specialization, canAdmitPatients, canDiagnose);
        
        this.operatingRoom = operatingRoom;
        this.isOperating = false; 
    }

    // Encapsulation for the new fields
    public String getOperatingRoom() { return operatingRoom; }
    
    public void setIsOperating(boolean isOperating) { this.isOperating = isOperating; }
    public boolean getIsOperating() { return isOperating; }

    // Override getRole so the dashboard greets them properly
    @Override
    public String getRole() {
        return "Surgeon";
    }

    // We Override the Doctor's treatPatient method to add a Surgery option!
    @Override
    public void treatPatient(Patient patient) {
        Scanner scanner = new Scanner(System.in);
        boolean viewingPatient = true;

        while (viewingPatient) {
            System.out.println("\n=== SURGEON ACTION PANEL (OR: " + operatingRoom + ") ===");
            System.out.println("Dr. " + getName() + " is reviewing Patient: " + patient.getName());
            
            if (getCanDiagnose()) System.out.println("[1] Add Diagnosis to Record");
            if (getCanAdmitPatients()) System.out.println("[2] Admit Patient to Hospital Room");
            
            System.out.println("[3] Perform Emergency Surgery"); 
            System.out.println("[4] Finish & Return to Dashboard");
            System.out.print("Select an action: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    patient.setIsDiagnosed(true);
                    System.out.println(" -> Result: Patient has been marked as DIAGNOSED.");
                    break;
                case "2":
                    patient.setIsAdmitted(true);
                    System.out.println(" -> Result: Patient has been officially ADMITTED.");
                    break;
                case "3":
                    // A custom surgical action
                    this.isOperating = true;
                    patient.setIsAdmitted(true); // Surgery requires admission!
                    System.out.println(" -> Result: Surgery performed successfully in " + operatingRoom + ". Patient automatically admitted for recovery.");
                    this.isOperating = false;
                    break;
                case "4":
                    System.out.println("Closing Surgeon Panel...");
                    viewingPatient = false; 
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}