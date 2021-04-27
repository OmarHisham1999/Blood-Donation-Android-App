package com.example.blooddonation;

public class Hospitaljava {
    String HId;
    String HName;
    String HArea;
    String HCity;
    int Registrationnum;

    public Hospitaljava(String HId, String HName, String HArea, String HCity, int Registrationnum) {

        HId = HId;
        HName = HName;
        HCity = HCity;
        HArea = HArea;
        Registrationnum = Registrationnum;


    }

    String getHId() {
        return HId;
    }

    String getHName() {
        return HName;
    }

    String getHCity() {
        return HCity;
    }

    String getHArea() {
        return HArea;
    }

    int getRegistrationnum() {
        return Registrationnum;
    }

    public void setHId(String HId) {
        this.HId = HId;
    }

    public void setHName(String HName) {
        this.HName = HName;
    }

    public void setHArea(String HArea) {
        this.HArea = HArea;
    }

    public void setHCity(String HCity) {
        this.HCity = HCity;
    }

    public void setRegistrationnum(int registrationnum) {
        Registrationnum = registrationnum;
    }
}