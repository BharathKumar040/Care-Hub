package com.bharath.patientmanagementsystem.data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.bharath.patientmanagementsystem.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser = new LoggedInUser(
                    java.util.UUID.randomUUID().toString(), "Arul");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}