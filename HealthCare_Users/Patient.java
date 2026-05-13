package HealthCare_Users;

public class Patient {

    // patients information
    private String name;
    private int age;
    private String patientID;
    private String bloodType;

    // patients vitals
    private int heartRate;
    private String bloodPressure;

    public Patient(String name, int age, String patientID, String bloodType){
        this.name = name;
        this.age = age;
        this.patientID = patientID;
        this.bloodType = bloodType;

        this.heartRate = 0;
        this.bloodPressure = "N/A";
    }

    public void printPatientInfo() {
        System.out.println("\n--- Patient Record: " + patientID + " ---");
        System.out.println("Name: " + name + " | Age: " + age + " | Blood Type: " + bloodType);
        System.out.println("Vitals -> HR: " + heartRate + " bpm | BP: " + bloodPressure);
    }

    //getters and setters
    public void setName(String name){
        if(name == null){
            System.out.println("Name invalid");
        }
        else
            this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age > 120 || age < 0){
            System.out.println("Age Invalid");
        }
        else    
            this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setPatientID(String patientID){
        this.patientID = patientID;
    }

    public String getPatientID(){
        return patientID;
    }

    public void setBloodType(String bloodType){
        this.bloodType = bloodType;
    }

    public String getBloodType(){
        return bloodType;
    }

    public void setHeartRate(int heartRate){
        this.heartRate = heartRate;
    }

    public int getHeartRate(){
        return heartRate;
    }

    public void setBloodPressure(String bloodPressure){
        this.bloodPressure = bloodPressure;
    }

    public String getBloodPressure(){
        return bloodPressure;
    }

}
