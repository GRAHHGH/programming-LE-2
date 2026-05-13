package HealthCare_Users;
import java.util.Scanner;

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
        // We create a local scanner just for the Doctor's menu
        Scanner scanner = new Scanner(System.in);
        boolean viewingPatient = true;

        while (viewingPatient) {
            System.out.println("\n=== DOCTOR ACTION PANEL ===");
            System.out.println("Dr. " + getName() + " is reviewing Patient: " + patient.getName());
            
            if (getCanDiagnose()) {
                System.out.println("[1] Add Diagnosis to Record");
            }
            if (getCanAdmitPatients()) {
                System.out.println("[2] Admit Patient to Hospital Room");
            }
            System.out.println("[3] Finish & Return to Dashboard");
            System.out.print("Select an action: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    if (getCanDiagnose()) {
                        patient.setIsDiagnosed(true);
                        System.out.println(" -> Result: Patient has been marked as DIAGNOSED.");
                    } else {
                        System.out.println(" -> Error: You lack permissions to diagnose.");
                    }
                    break;
                    
                case "2":
                    if (getCanAdmitPatients()) {
                        patient.setIsAdmitted(true);
                        System.out.println(" -> Result: Patient has been officially ADMITTED.");
                    } else {
                        System.out.println(" -> Error: You lack permissions to admit patients.");
                    }
                    break;
                    
                case "3":
                    System.out.println("Closing Doctor Panel...");
                    viewingPatient = false; 
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
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
