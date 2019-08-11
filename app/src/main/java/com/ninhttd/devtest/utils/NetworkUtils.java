package com.ninhttd.devtest.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ninhttd.devtest.TekoApplication;

public class NetworkUtils {
    public static boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) TekoApplication.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}
