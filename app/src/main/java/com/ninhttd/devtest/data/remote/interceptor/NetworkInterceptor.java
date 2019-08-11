package com.ninhttd.devtest.data.remote.interceptor;

import com.ninhttd.devtest.data.remote.exception.NetworkException;
import com.ninhttd.devtest.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        if(!NetworkUtils.isNetworkAvailable()){
            throw new NetworkException();
        }
        return chain.proceed(chain.request());
    }
}
