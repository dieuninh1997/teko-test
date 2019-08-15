package com.ninhttd.devtest;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;
import com.ninhttd.devtest.data.dj.AppComponent;
import com.ninhttd.devtest.data.dj.AppModule;
import com.ninhttd.devtest.data.dj.DaggerAppComponent;
import com.ninhttd.devtest.data.local.SharedPrefsHelper;
import com.ninhttd.devtest.utils.DateUtils;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.TimeZone;

public class TekoApplication extends Application {
    private static Context mContext;
    private AppComponent appComponent;
    private SharedPrefsHelper sharedPrefsHelper;
    public static Gson gson;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        gson = new GsonBuilder().create();
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

