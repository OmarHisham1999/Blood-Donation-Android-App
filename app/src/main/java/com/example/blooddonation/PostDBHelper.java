package com.example.blooddonation;

public class PostDBHelper {

    String bloodtype, status, numberofdonors, patientname, hospitalemail,hospitallocation;

    public PostDBHelper() {
    }

    public PostDBHelper(String bloodtype, String status, String numberofdonors, String patientname, String hospitalemail, String hospitallocation) {
        this.bloodtype = bloodtype;
        this.status = status;
        this.numberofdonors = numberofdonors;
        this.patientname = patientname;
        this.hospitalemail = hospitalemail;
        this.hospitallocation = hospitallocation;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumberofdonors() {
        return numberofdonors;
    }

    public void setNumberofdonors(String numberofdonors) {
        this.numberofdonors = numberofdonors;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getHospitalemail() {
        return hospitalemail;
    }

    public void setHospitalemail(String hospitalemail) {
        this.hospitalemail = hospitalemail;
    }

    public String getHospitallocation() {
        return hospitallocation;
    }

    public void setHospitallocation(String hospitallocation) {
        this.hospitallocation = hospitallocation;
    }
}
