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