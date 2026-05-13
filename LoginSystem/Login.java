package LoginSystem;

import java.util.Scanner;

import HealthCare_Users.*;
import MainPage.StaffDashBoard;


public class Login {
    
    private Scanner scanner = new Scanner(System.in);
    private UserDataManager userDataManager = new UserDataManager();
    private boolean isRunning = true;
    private StaffDashBoard staffDashBoard = new StaffDashBoard(userDataManager);

    public void mainMenu(){
        while(isRunning){
            System.out.println("\n--- MENU ---");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
            
            // Local variable, created fresh every loop
            String loginInputChoice = scanner.nextLine();   
            this.LoginLogic(loginInputChoice); 
        }
    }

    // Pass the choice in as an argument
    private void LoginLogic(String choice){
        switch(choice){
            case "1":
                this.RegisterMenu();
                break;
            case "2":
                this.LoginMenu();
                break;
            case "3":
                System.out.println("Exiting System. Goodbye!");
                isRunning = false;
                break;
            default:    
                System.out.println("Invalid Choice. Please try again.");     
        }
    }

    private void RegisterMenu(){
        System.out.print("Enter a new Username: ");
        String newUsername = scanner.nextLine();
        
        if(userDataManager.userExist(newUsername)){
            System.out.println("Error: That Username is already taken.");
            return; 
        } 
        
        System.out.print("Enter a new Password: ");
        String newPassword = scanner.nextLine();

        // Only Staff can register an account now!
        System.out.println("\nWhat type of Staff account are you creating?");
        System.out.println("[1] Doctor");
        System.out.println("[2] Nurse");
        System.out.print("Choice: ");
        String roleChoice = scanner.nextLine();

        System.out.print("Enter your real Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear scanner buffer

        User newUserProfile = null;

        if (roleChoice.equals("1")) {
            newUserProfile = new Doctor(name, age, newUsername, 10, "General", true, true);
        } 
        else if (roleChoice.equals("2")){
            newUserProfile = new Nurse(name, age, newUsername, true, true);
        } 
        else{
            System.out.println("Error: Invalid choice.");
            return;
        }

        // Save the staff member
        userDataManager.registerStaff(newUsername, newPassword, newUserProfile);
        System.out.println("\nSuccess: " + newUserProfile.getRole() + " Account Created!");
    }

    private void LoginMenu(){
        System.out.print("Enter a Username: ");
        String loginUser = scanner.nextLine();
        System.out.print("Enter a Password: ");
        String loginPassword = scanner.nextLine();
        
        if(userDataManager.authenticateUser(loginUser, loginPassword)){
            User loggedInUser = userDataManager.getUserProfile(loginUser);
            System.out.println("\nLogin Successful! Welcome, " + loggedInUser.getRole() + " " + loggedInUser.getName() + ".");
            
            // --- NEW: Call the separate class! ---
            staffDashBoard.openDashboard(loggedInUser); 
            
        } else {
            System.out.println("Error: Invalid username or password!");
        }
    }
}