package com.ninhttd.devtest.data.dj;

import android.app.Application;
import android.content.Context;

import com.ninhttd.devtest.BuildConfig;
import com.ninhttd.devtest.data.local.TekoDb;
import com.ninhttd.devtest.data.remote.TekoApi;
import com.ninhttd.devtest.data.remote.interceptor.AuthInterceptor;
import com.ninhttd.devtest.data.remote.interceptor.NetworkInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private final long TIME_OUT = 2 * 60L;

    private Application mApplication;

    public AppModule(Application app) {
        mApplication = app;
    }

    @Provides
    Context provideContext() {
        return mApplication;
    }

    @Singleton
    @Provides
    TekoApi provideTekoApi() {
        String baseUrl = "https://listing-stg.services.teko.vn/api/";
        HttpLoggingInterceptor httpLoggingInterceptor = getUnsafeOkHttpClient();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(new NetworkInterceptor())
                .addInterceptor(new AuthInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(TekoApi.class);
    }

    private HttpLoggingInterceptor getUnsafeOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return logging;
    }


    @Singleton
    @Provides
    TekoDb provideTekoDb() {
        return TekoDb.getTekoDb();
    }


}
