package com.bharath.patientmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionList extends ArrayAdapter<Prescription> {
    Activity context;
    List<Prescription> pres;

    public PrescriptionList (Activity context, ArrayList<Prescription> pres)
    {
        super(context,R.layout.lv_all_pres,pres);
        this.context = context;
        this.pres = pres;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.lv_all_pres,null,true);
        TextView tvMN = (TextView) v.findViewById(R.id.tvMN);
        TextView tvPD = (TextView)v.findViewById(R.id.tvPD);
        TextView tvD = (TextView)v.findViewById(R.id.tvD);
        TextView tvPU = (TextView)v.findViewById(R.id.tvPU);
        Prescription p = pres.get(position);
        tvMN.setText("Medication : "+ p.getMedname());
        tvPD.setText("Dosage per day : "+ p.getPerDay());
        tvD.setText("No. of Days : "+ p.getDays());
        String pu = p.getPickedUp();
        if(pu.equals("false"))
            tvPU.setText("Medication has not been picked up yet");
        else
            tvPU.setText("Medication last picked up on "+p.getPudate());
        return v;
    }
}