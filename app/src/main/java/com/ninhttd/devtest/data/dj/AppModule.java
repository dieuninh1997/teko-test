package com.ninhttd.devtest.data.dj;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.ninhttd.devtest.BuildConfig;
import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.data.local.TekoDb;
import com.ninhttd.devtest.data.remote.TekoApi;
import com.ninhttd.devtest.data.remote.interceptor.AuthInterceptor;
import com.ninhttd.devtest.data.remote.interceptor.NetworkInterceptor;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

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

//    @Provides
//    public Application provideApplication() {
//        return mApplication;
//    }

    @Singleton
    @Provides
    TekoApi provideTekoApi() {
        String baseUrl = "https://listing-stg.services.teko.vn/api/";
        HttpLoggingInterceptor logging = getUnsafeOkHttpClient();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .addInterceptor(new NetworkInterceptor())
                .addInterceptor(new AuthInterceptor())
                .addInterceptor(logging)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(TekoApplication.gson))
                .client(httpClient.build())
                .build()
                .create(TekoApi.class);
    }

    private HttpLoggingInterceptor getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };
            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);
            builder.readTimeout(45, TimeUnit.SECONDS);
            builder.connectTimeout(2, TimeUnit.MINUTES);


            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            }else {
                logging.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            return logging;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return TekoApplication.gson;
    }

    @Singleton
    @Provides
    TekoDb provideTekoDb() {
        return TekoDb.getTekoDb();
    }


}
