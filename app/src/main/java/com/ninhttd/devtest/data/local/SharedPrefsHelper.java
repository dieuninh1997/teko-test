package com.ninhttd.devtest.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.ninhttd.devtest.TekoApplication;

public class SharedPrefsHelper {

    public static String PREF_KEY = "teko_key";
    public static String KEY_FIRST_RUN = "first_run";

    private static SharedPreferences sharedPreferences = TekoApplication.getAppContext().getSharedPreferences(SharedPrefsHelper.PREF_KEY, Context.MODE_PRIVATE);
    private static SharedPrefsHelper instance = new SharedPrefsHelper();

    public static SharedPrefsHelper getInstance() {
        return instance;
    }

    public void put(String key, String value) {
        sharedPreferences.edit().putString(key, value).apply();
    }

    public void put(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public String get(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    public Boolean get(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    public String get(String key) {
        return get(key, "");
    }

    public void removeAllKey(){
        sharedPreferences.edit().clear().apply();
        getInstance().put(KEY_FIRST_RUN, false);
    }

    public void clearAllKey(){
        removeAllKey();
    }
}
