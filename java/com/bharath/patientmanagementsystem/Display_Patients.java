package com.bharath.patientmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class Display_Patients extends AppCompatActivity {

    ListView lvAllPatients;
    DatabaseReference DBPatients;
    ArrayList<Patient> patients = new ArrayList<Patient>();
    //Button btnDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_patients);
        lvAllPatients = findViewById(R.id.lvAllPatients);
        // btnDetails = findViewById(R.id.btnPatientDetails);
        DBPatients = FirebaseDatabase.getInstance().getReference("patients");
        DBPatients.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                patients.clear();
                for(DataSnapshot PatientSS : dataSnapshot.getChildren()){
                    Float age = PatientSS.getValue(Patient.class).getAge();
                    Float height = PatientSS.getValue(Patient.class).getHeight();
                    Float weight = PatientSS.getValue(Patient.class).getWeight();
                    String name = PatientSS.getValue(Patient.class).getName();
                    String doctorName = PatientSS.getValue(Patient.class).getDoctorName();
                    String id = PatientSS.getValue(Patient.class).getId();
                    String gender = PatientSS.getValue(Patient.class).getGender();
                    //ArrayList<DocComment> dc =


                    //String id = PatientSS.getValue(String.class);
                    //Toast.makeText(Display_Patients.this,id,Toast.LENGTH_SHORT);
                    Patient p = new Patient(name,id,gender,age,height,weight,doctorName);
                    patients.add(p);
                }
                PatientList adapter = new PatientList(Display_Patients.this, patients);
                lvAllPatients.setAdapter(adapter);
                lvAllPatients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent i = new Intent(Display_Patients.this, PatientDetails.class);
                        Patient pclicked = (Patient)patients.get(position);
                        i.putExtra("Patient",pclicked);
                        startActivity(i);

                    }});


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Display_Patients.this, "ERROR!", Toast.LENGTH_SHORT).show();
            }
        });



    }

}