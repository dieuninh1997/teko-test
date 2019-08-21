package com.ninhttd.devtest

import android.app.Application
import android.content.Context

import com.ninhttd.devtest.dj.AppComponent
import com.ninhttd.devtest.dj.AppModule
import com.ninhttd.devtest.dj.DaggerAppComponent
import com.ninhttd.devtest.data.local.SharedPrefsHelper

class TekoApplication : Application() {
    var appComponent: AppComponent? = null
        private set
    private var sharedPrefsHelper: SharedPrefsHelper? = null

    override fun onCreate() {
        super.onCreate()
        appContext = this
        this.appComponent = DaggerAppComponent.builder().application(this).appModule(AppModule(this)).build()
        appComponent!!.inject(this)
        sharedPrefsHelper = SharedPrefsHelper.instance
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}

