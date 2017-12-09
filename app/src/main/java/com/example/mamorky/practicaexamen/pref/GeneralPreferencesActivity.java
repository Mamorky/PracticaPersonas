package com.example.mamorky.practicaexamen.pref;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.example.mamorky.practicaexamen.R;

/**
 * Created by mamorky on 9/12/17.
 */

public class GeneralPreferencesActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
    }
}
