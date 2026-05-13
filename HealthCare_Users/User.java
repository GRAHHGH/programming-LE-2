package HealthCare_Users;

public abstract class User {

    private String name;
    private int age;
    private String userID;

    public User(String name, int age, String userID){
        setAge(age);
        setName(name);
        this.userID = userID;
    }

    public abstract String getRole();
    public abstract void treatPatient(Patient patient);

    @Override
    public String toString() {
        return "Name: " + getName() + " | Age: " + getAge() + " | ID: " + getUserID();
    }

    public void setName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name invalid");
        }
        else
            this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age > 120 || age < 0){
            throw new IllegalArgumentException("Age invalid");
        }
        else    
            this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }
    public String getUserID(){
        return userID;
    }
    
}
