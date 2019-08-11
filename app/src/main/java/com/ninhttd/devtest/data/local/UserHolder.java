package com.ninhttd.devtest.data.local;

import com.ninhttd.devtest.custom.LogUtils;

public class UserHolder {
    private static final String TOKEN_KEY = "user_token";

    public static UserHolder instance;
    private SharedPrefsHelper sharedPrefsHelper;


    public static UserHolder getInstance() {
        if (instance == null) {
            instance = new UserHolder();
            instance.sharedPrefsHelper = SharedPrefsHelper.getInstance();
        }
        return instance;
    }

    public boolean checkDataExits(){
        return sharedPrefsHelper.get(SharedPrefsHelper.KEY_FIRST_RUN, false);

    }

    public void setToken(String token) {
        sharedPrefsHelper.put(TOKEN_KEY, token);
    }

    public String getToken() {
        LogUtils.debugLog(this, "token: " + sharedPrefsHelper.get(TOKEN_KEY));
        return sharedPrefsHelper.get(TOKEN_KEY);
    }

}
