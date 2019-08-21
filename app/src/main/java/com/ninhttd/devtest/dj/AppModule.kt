package com.ninhttd.devtest.dj

import android.app.Application
import android.content.Context
import com.ninhttd.devtest.BuildConfig
import com.ninhttd.devtest.data.api.TekoApi
import com.ninhttd.devtest.data.local.TekoDb
import com.ninhttd.devtest.data.remote.interceptor.AuthInterceptor
import com.ninhttd.devtest.data.remote.interceptor.NetworkInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(private val mApplication: Application) {
    private val TIME_OUT = 2 * 60L

    private val unsafeOkHttpClient: HttpLoggingInterceptor
        get() {
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.NONE
            }
            return logging
        }

    @Provides
    internal fun provideContext(): Context {
        return mApplication
    }

    @Singleton
    @Provides
    internal fun provideTekoApi(): TekoApi {
        val baseUrl = "https://listing-stg.services.teko.vn/api/"
        val httpLoggingInterceptor = unsafeOkHttpClient
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(NetworkInterceptor())
                .addInterceptor(AuthInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(TekoApi::class.java)
    }


    @Singleton
    @Provides
    internal fun provideTekoDb(): TekoDb {
        return TekoDb.tekoDb
    }


}
