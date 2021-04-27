package com.example.blooddonation;

public class HospitalDBHelper {

    String registrationnumber, password, email,location;

    public HospitalDBHelper() {
    }

    public HospitalDBHelper(String registrationnumber, String password, String email, String location) {
        this.registrationnumber = registrationnumber;
        this.password = password;
        this.email = email;
        this.location = location;
    }

    public String getRegistrationnumber() {
        return registrationnumber;
    }

    public void setRegistrationnumber(String registrationnumber) {
        this.registrationnumber = registrationnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
