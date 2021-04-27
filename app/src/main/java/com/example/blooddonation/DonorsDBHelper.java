package com.example.blooddonation;

public class DonorsDBHelper {

    String name,password,email,phone,bloodtype,city,area;

    public DonorsDBHelper() {
    }

    public DonorsDBHelper(String name, String password, String email, String phone, String bloodtype, String city, String area) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.bloodtype = bloodtype;
        this.city = city;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
