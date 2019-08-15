package com.ninhttd.devtest;

import android.app.Application;
import android.content.Context;

import com.ninhttd.devtest.data.dj.AppComponent;
import com.ninhttd.devtest.data.dj.AppModule;
import com.ninhttd.devtest.data.dj.DaggerAppComponent;
import com.ninhttd.devtest.data.local.SharedPrefsHelper;

public class TekoApplication extends Application {
    private static Context mContext;
    private AppComponent appComponent;
    private SharedPrefsHelper sharedPrefsHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        this.appComponent = DaggerAppComponent.builder().application(this).appModule(new AppModule(this)).build();
        appComponent.inject(this);
        sharedPrefsHelper = SharedPrefsHelper.getInstance();
    }

    public static Context getAppContext() {
        return mContext;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

