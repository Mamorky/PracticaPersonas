package com.example.mamorky.practicaexamen.data.pref;

import android.content.SharedPreferences;

import com.example.mamorky.practicaexamen.pref.Preferencias;

/**
 * Created by mamorky on 9/12/17.
 */

public class AppPreferencesHelper implements GeneralPreferenceHelper{

    private static AppPreferencesHelper instance;
    private final SharedPreferences preferences;

    public static AppPreferencesHelper getInstance() {
        if(instance == null)
            instance = new AppPreferencesHelper();
        return instance;
    }

    private AppPreferencesHelper() {
        this.preferences = Preferencias.preferences;
    }

    public String getPrefName(){
        String name = preferences.getString(PREF_USER_NAME,null);
        return name;
    }

    public boolean getPrefSocialEnable(){
        boolean socialEnable = preferences.getBoolean(PREF_ENABLE_SOCIAL,false);
        return socialEnable;
    }

    public void setPrefName(String name){
        preferences.edit().putString(PREF_USER_NAME,name);
    }

    public void setPrefSocialEnable(boolean activo){
        preferences.edit().putBoolean(PREF_ENABLE_SOCIAL,activo);
    }

    public SharedPreferences getPreferences() {
        return preferences;
    }
}
