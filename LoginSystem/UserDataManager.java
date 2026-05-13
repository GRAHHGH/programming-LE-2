package LoginSystem;

import java.util.HashMap;
import HealthCare_Users.*;

public class UserDataManager {

    private HashMap<String, String> userDatabase;
    private HashMap<String, Patient> patientDatabase;

    public UserDataManager() {
        this.userDatabase = new HashMap<>();
        this.patientDatabase = new HashMap<>();
    }

    // login and register logic 
    public boolean registerUser(String username, String password){
        if(userDatabase.containsKey(username)){
            return false;
        }

        userDatabase.put(username, password);
            return true;
    }

    public boolean authenticateUser(String username, String password){
        if(userDatabase.containsKey(username)){
            return userDatabase.get(username).equals(password);
        }
        return false;
    }

    public boolean userExist(String username){
        return userDatabase.containsKey(username);
    }
      
}
