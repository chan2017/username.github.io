package com.example.farahshadid.callyourmother;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

// This is the splash screen activity, it decides whether to launch the contact picker activity or launch straight
// into the home activity
public class SplashActivity extends AppCompatActivity {
    final static String PREF_KEY = "firstLaunch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Check if this is the first app launch
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if (pref.getBoolean(PREF_KEY, true)) {
            // Choose contacts
            startActivity(new Intent(SplashActivity.this, ContactActivity.class));
        } else {
            // Launch home activity
            startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        }

        // Exit if users come back
        finish();
    }
}
