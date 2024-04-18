package com.bharath.patientmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Patient implements Serializable
{

    String name,id,gender, doctorName;
    float age, height, weight;
    private static final AtomicInteger counter = new AtomicInteger(0);





    public Patient(String name,String id, String gender, float age, float height, float weight, String doctorName) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.doctorName = doctorName;
        //comments = new ArrayList();
    }
    public Patient()
    {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /*public ArrayList<DocComment> getComments() {
        return comments;
    }
    public void setComments(ArrayList<DocComment> comments) {
        this.comments = comments;
    }
     */
}
