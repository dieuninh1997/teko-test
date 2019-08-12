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
        gson = new GsonBuilder().registerTypeAdapter(LocalDate.class,
                new LocalDateAdapter())
                .registerTypeAdapter(Date.class, new GmtDateTypeAdapter())
                .create();
        this.appComponent = DaggerAppComponent.builder().application(this)
                .appModule(new AppModule(this))

                .build();
        appComponent.inject(this);
        sharedPrefsHelper = SharedPrefsHelper.getInstance();
    }

    public static Context getAppContext() {
        return mContext;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


    class LocalDateAdapter implements JsonSerializer<org.joda.time.LocalDate>,
            JsonDeserializer<org.joda.time.LocalDate> {

        @Override
        public org.joda.time.LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

            String dateAsString = json.getAsString();
            if (json.isJsonNull() || dateAsString.length() == 0) {
                return null;
            }
            return new org.joda.time.LocalDate(dateAsString);
        }

        @Override
        public JsonElement serialize(org.joda.time.LocalDate date,
                                     Type typeOfSrc,
                                     JsonSerializationContext context) {
            return new JsonPrimitive(date.toString(DateUtils.GSON_PARSER_DATE));
        }
    }

    class GmtDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

        private final SimpleDateFormat dateFormat;

        private GmtDateTypeAdapter() {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            try {
                synchronized (dateFormat) {
                    return dateFormat.parse(json.getAsString());
                }
            } catch (ParseException e) {
                throw new JsonSyntaxException(json.getAsString(), e);
            }
        }

        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext context) {
            synchronized (dateFormat) {
                String dateFormatAsString = dateFormat.format(date);
                return new JsonPrimitive(dateFormatAsString);
            }
        }
    }
}

