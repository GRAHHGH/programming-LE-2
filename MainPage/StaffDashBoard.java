package MainPage;

import java.util.Scanner;
import HealthCare_Users.*;
import LoginSystem.*;

public class StaffDashBoard {

    private Scanner scanner;
    private UserDataManager userDataManager; 
    boolean inDashboard = true;

    public StaffDashBoard(UserDataManager userDataManager) {
        this.userDataManager = userDataManager;
        this.scanner = new Scanner(System.in);
    }

    // This is the method will call from the Login class
    public void openDashboard(User loggedInStaff) {

        while(inDashboard) {
            System.out.println("\n=======================");
            System.out.println("--- STAFF DASHBOARD ---");
            System.out.println("=======================");
            System.out.println("[1] Add New Patient Record");
            System.out.println("[2] View My Profile");
            System.out.println("[3] View Patient Record");
            System.out.println("[4] Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            
            switch(choice) {
                case "1":
                    this.newPatientRecord();
                    break;
                    
                case "2":
                    System.out.println(loggedInStaff.toString());
                    break;

                case "3":
                    this.viewPatientRecord(loggedInStaff);
                    break; 

                case "4":
                    System.out.println("Logging out...");
                    inDashboard = false; 
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void viewPatientRecord(User loggedInStaff){
        System.out.println("\n--- HOSPITAL PATIENT DATABASE ---");
                    
        java.util.Collection<Patient> allPatients = userDataManager.getAllPatients();
                    
        if (allPatients.isEmpty()) {
            System.out.println("There are no patients currently registered in the system.");
            return;
        } 
                    
        for (Patient p : allPatients) {
            System.out.println(p.toString());
        }

        System.out.print("\nEnter Patient ID to interact (or type 'cancel'): ");
        String targetID = scanner.nextLine();
                    
        if(targetID.equalsIgnoreCase("cancel")) 
            return;

        Patient selectedPatient = null;
            for (Patient p : allPatients) {
                if (p.getPatientID().equals(targetID)) {
                    selectedPatient = p;
                    break;
                }
            }
        if (selectedPatient != null) {
            loggedInStaff.treatPatient(selectedPatient);
        } else {
            System.out.println("Error: Patient ID not found.");
        }
    }

    public void newPatientRecord(){
        System.out.print("\nEnter Patient Name: ");
        String pName = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int pAge = scanner.nextInt();
            scanner.nextLine(); 
        System.out.print("Enter Patient Blood Type: ");
        String bType = scanner.nextLine();
                    
        String pID = "PT-" + (int)(Math.random() * 10000); 
                    
        Patient newPatient = new Patient(pID, bType, pName, pAge, "None");
                                      
        userDataManager.addPatientRecord(newPatient);
        System.out.println("Success! Patient Record created for: " + pName);
    }
}