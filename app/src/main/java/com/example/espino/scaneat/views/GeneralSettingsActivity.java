package com.example.espino.scaneat.views;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.espino.scaneat.R;


public class GeneralSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.general_settings);
    }
}
