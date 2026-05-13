package LoginSystem;

import java.util.Scanner;

public class Login {
    
    Scanner scanner = new Scanner(System.in);
    UserDataManager userDataManager = new UserDataManager();

    boolean isRunning = true;
    String loginInputChoice;
    boolean isRegistered;
    boolean isUserExist;

    public void mainMenu(){
        while(isRunning){
            System.out.println("MENU");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.print("Choose an option: ");
                loginInputChoice = scanner.nextLine();   
            this.LoginLogic();
        }
    }

    public void LoginLogic(){

        switch(this.loginInputChoice){
            case "1":
                    this.RegisterMenu();
                break;
            case "2":
                    this.LoginMenu();
                    isRunning = false;
                break;
            case "3":
                System.out.println("Exit");
                isRunning = false;
                break;
            default:    
                System.out.println("Invalid Choice");     

        }
    }

    public void RegisterMenu(){
        System.out.print("Enter a new Username: ");
            String newUsername = scanner.nextLine();
            isRegistered = userDataManager.userExist(newUsername);
        if(isRegistered){
            System.out.println("That User is already taken");
        }
        else{
            System.out.print("Enter a new Password: ");
            String newPassword = scanner.nextLine();
            isRegistered = userDataManager.registerUser(newUsername, newPassword);
            System.out.println("Account Created!");
        }
        
    }

    public void LoginMenu(){
        System.out.print("Enter a Username: ");
            String loginUser = scanner.nextLine();
        System.out.print("Enter a Password: ");
            String loginPassword = scanner.nextLine();
        
        isUserExist = userDataManager.authenticateUser(loginUser, loginPassword);

        if(isUserExist){
            System.out.println("Welcome " + loginUser + "!");
        }
        else{
            System.out.println("this user doesnt exist!");
            isRunning = true;
            mainMenu();
        }
        
    }
   
}
