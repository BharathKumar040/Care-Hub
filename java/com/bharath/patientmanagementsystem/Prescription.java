package com.bharath.patientmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import java.io.Serializable;

public class Prescription  {

    String medname,pudate, pid, presid, runsout;
    int perDay, days;
    String pickedUp;

    public Prescription(String medname, int perDay, int days, String pid, String presid,String pickedUp, String runsout, String pudate) {
        this.medname = medname;
        this.perDay = perDay;
        this.days = days;
        this.pickedUp = pickedUp;
        this.pid = pid;
        this.runsout = runsout;
        this.pudate = pudate;
        this.presid = presid;
    }

    public Prescription()
    {

    }

    public String getPresid() {
        return presid;
    }

    public String getMedname() {
        return medname;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public int getPerDay() {
        return perDay;
    }

    public void setPerDay(int perDay) {
        this.perDay = perDay;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getPid() {
        return pid;
    }

    public String getPudate() {
        return pudate;
    }

    public void setPudate(String pudate) {
        this.pudate = pudate;
    }

    public String getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(String pickedUp) {
        this.pickedUp = pickedUp;
    }

    public String getRunsout() {
        return runsout;
    }

    public void setRunsout(String runsout) {
        this.runsout = runsout;
    }
}