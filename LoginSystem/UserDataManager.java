package LoginSystem;

import java.util.Collection;
import java.util.HashMap;
import HealthCare_Users.*;

public class UserDataManager {

    private HashMap<String, String> staffDatabase; 
    private HashMap<String, User> staffProfiles; 
    private HashMap<String, Patient> patientRecords;

    public UserDataManager() {
        this.staffDatabase = new HashMap<>();
        this.staffProfiles = new HashMap<>();
        this.patientRecords = new HashMap<>(); 
    }

    // Register Staff (Requires Password)
    public boolean registerStaff(String username, String password, User newProfile){
        if(staffDatabase.containsKey(username)){
            return false;
        }
        staffDatabase.put(username, password);
        staffProfiles.put(username, newProfile);
        return true;
    }

    // Authenticate Staff
    public boolean authenticateUser(String username, String password){
        if(staffDatabase.containsKey(username)){
            return staffDatabase.get(username).equals(password);
        }
        return false;
    }

    public boolean userExist(String username){
        return staffDatabase.containsKey(username);
    }

    public User getUserProfile(String username) {
        return staffProfiles.get(username);
    }
  
    // Add a patient directly to the records 
    public void addPatientRecord(Patient patient) {
        patientRecords.put(patient.getPatientID(), patient);
    }

    public Collection<Patient> getAllPatients() {
        return patientRecords.values(); 
    }
}