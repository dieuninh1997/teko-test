package com.ninhttd.devtest.data.local

import android.content.Context
import android.content.SharedPreferences

import com.ninhttd.devtest.TekoApplication

class SharedPrefsHelper {

    fun put(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun put(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    @JvmOverloads
    operator fun get(key: String, defaultValue: String = ""): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    operator fun get(key: String, defaultValue: Boolean): Boolean? {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun removeAllKey() {
        sharedPreferences.edit().clear().apply()
        instance.put(KEY_FIRST_RUN, false)
    }

    fun clearAllKey() {
        removeAllKey()
    }

    companion object {

        var PREF_KEY = "teko_key"
        var KEY_FIRST_RUN = "first_run"

        private val sharedPreferences = TekoApplication.appContext!!.getSharedPreferences(SharedPrefsHelper.PREF_KEY, Context.MODE_PRIVATE)
        val instance = SharedPrefsHelper()
    }
}
