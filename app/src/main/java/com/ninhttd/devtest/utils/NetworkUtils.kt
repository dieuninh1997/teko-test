package com.ninhttd.devtest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

import com.ninhttd.devtest.TekoApplication

object NetworkUtils {
    val isNetworkAvailable: Boolean
        get() {
            val cm = TekoApplication.appContext!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = cm.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnectedOrConnecting
        }
}
