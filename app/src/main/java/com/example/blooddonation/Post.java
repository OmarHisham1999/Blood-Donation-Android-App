package com.example.blooddonation;

public class Post {
    String bloodtype;
    String status;
    String description;
    int numberofdonors;
    String hospitalname;
    String hospitalid;
    int progress;
    String postid;



    public Post(String bloodtype, String description, String status, int numberofdonors, String hospitalname, String hospitalid, String postid, int progress) {
        bloodtype = bloodtype;
        description = description;
        status = status;
        numberofdonors = numberofdonors;
        hospitalid = hospitalid;
        hospitalname = hospitalname;
        postid = postid;
        progress = progress;
    }



    public String getBloodtype() {
        return bloodtype;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getNumberofdonors() {
        return numberofdonors;
    }

    public String getHospitalid() {
        return hospitalid;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public String getpostid() {
        return postid;
    }

    public int getProgress() {
        return progress;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumberofdonors(int numberofdonors) {
        this.numberofdonors = numberofdonors;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public void setHospitalid(String hospitalid) {
        this.hospitalid = hospitalid;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }
}
