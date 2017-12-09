package com.example.mamorky.practicaexamen.pref;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.mamorky.practicaexamen.data.pref.AppPreferencesHelper;

/**
 * Created by mamorky on 9/12/17.
 */

public class Preferencias extends Application{

    private AppPreferencesHelper preferencesHelper;
    public static SharedPreferences preferences;

    @Override
    public void onCreate() {
        super.onCreate();
        preferencesHelper = AppPreferencesHelper.getInstance();
    }

    public AppPreferencesHelper getPreferencesHelper(){
        return preferencesHelper;
    }

    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return super.getSharedPreferences(name, mode);
    }
}
