package com.example.blooddonation;

public class Userjava {

    String UserId;
    String UserName;
    String UserBloodtype;
    String UserEmail;
    int UserPhone;
    String UserArea;
    String UserCity;

    public Userjava(String UserId, String UserName, String UserBloodtype, String UserEmail, int UserPhone, String UserArea, String UserCity) {

        UserId = UserId;
        UserName = UserName;
        UserBloodtype = UserBloodtype;
        UserEmail = UserEmail;
        UserPhone = UserPhone;
        UserArea = UserArea;
        UserCity = UserCity;
    }

    public String getUserId() {
        return UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserBloodtype() {
        return UserBloodtype;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserArea() {
        return UserArea;
    }

    public int getUserPhone() {
        return UserPhone;
    }

    public String getUserCity() {
        return UserCity;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserBloodtype(String userBloodtype) {
        UserBloodtype = userBloodtype;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public void setUserPhone(int userPhone) {
        UserPhone = userPhone;
    }

    public void setUserArea(String userArea) {
        UserArea = userArea;
    }

    public void setUserCity(String userCity) {
        UserCity = userCity;
    }


}