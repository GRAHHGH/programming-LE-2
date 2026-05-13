package MainPage;

import java.util.Scanner;
import HealthCare_Users.*;
import LoginSystem.*;

public class StaffDashBoard {

    private Scanner scanner;
    private UserDataManager userDataManager; 

    public StaffDashBoard(UserDataManager userDataManager) {
        this.userDataManager = userDataManager;
        this.scanner = new Scanner(System.in);
    }

    // This is the method will call from the Login class
    public void openDashboard(User loggedInStaff) {
        boolean inDashboard = true;
        
        while(inDashboard) {
            System.out.println("\n--- STAFF DASHBOARD ---");
            System.out.println("[1] Add New Patient Record");
            System.out.println("[2] View My Profile");
            System.out.println("[3] Logout");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();
            
            switch(choice) {
                case "1":
                    System.out.print("\nEnter Patient Name: ");
                    String pName = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int pAge = scanner.nextInt();
                    scanner.nextLine(); // clear buffer
                    System.out.print("Enter Patient Blood Type: ");
                    String bType = scanner.nextLine();
                    
                    String pID = "PT-" + (int)(Math.random() * 10000); 
                    
                    Patient newPatient = new Patient(pID, bType, pName, pAge, "None");
                    
                    // Saves directly to the shared database!
                    userDataManager.addPatientRecord(newPatient);
                    System.out.println("Success! Patient Record created for: " + pName);
                    break;
                    
                case "2":
                    System.out.println(loggedInStaff.toString());
                    break;
                    
                case "3":
                    System.out.println("Logging out...");
                    inDashboard = false; 
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}