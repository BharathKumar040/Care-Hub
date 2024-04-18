package com.bharath.patientmanagementsystem.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}