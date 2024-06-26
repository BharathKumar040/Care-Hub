package com.bharath.patientmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bharath.patientmanagementsystem.ui.login.Slot;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dashboard extends AppCompatActivity {


    Button btnAddPatient, btnAllPatients, btnLogOut, btnAllowSlot, btnSche;
    SharedPreferences sharedPreferences;
    private long backPressedTime;
    private Toast backToast;
    DatabaseReference DBSlots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        btnAddPatient = findViewById(R.id.btnAddPatient);
        btnAllPatients = findViewById(R.id.btnAllPatients);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnAllowSlot = findViewById(R.id.btnAllowSlot);
        btnSche = findViewById(R.id.btnSche);

        btnAllPatients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,Display_Patients.class));
            }
        });

        btnAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,AcceptData.class));
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        btnAllowSlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBSlots = FirebaseDatabase.getInstance().getReference("Name Appointments");
                Calendar calendar = Calendar.getInstance();
                //Date today = calendar.getTime();
                calendar.add(Calendar.DAY_OF_YEAR,1);
                String date = DateFormat.getDateInstance().format(calendar.getTime());
                String m = DBSlots.push().getKey();
                Slot a = new Slot("9:00 AM - 10:00 AM",1,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("10:15 AM - 11:15 AM",2,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("11:30 AM - 12:30 AM",3,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("1:30 PM - 2:30 PM",4,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("2:45 PM - 3:45 PM",5,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("4:00 PM - 5:00 PM",6,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("5:15 PM - 6:15 PM",7,date,m);
                DBSlots.child(m).setValue(a);
                m = DBSlots.push().getKey();
                a = new Slot("6:30 PM - 7:30 PM",8,date,m);
                DBSlots.child(m).setValue(a);

                Toast.makeText(Dashboard.this, "Slots created!", Toast.LENGTH_SHORT).show();

            }
        });

        btnSche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,DocSchedule.class));
            }
        });
    }

    private void logoutUser() {
        FirebaseAuth.getInstance().signOut();
        updateLoggedInStatus(false);
        Toast.makeText(Dashboard.this, "Logged out", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Dashboard.this, MainActivity.class));
        finish();
    }

    private void updateLoggedInStatus(boolean isLoggedIn) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.apply();
    }
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }


}