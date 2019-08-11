package com.ninhttd.devtest.data.remote.interceptor;

import android.text.TextUtils;

import com.ninhttd.devtest.data.local.UserHolder;
import com.ninhttd.devtest.utils.AppUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request result;
        Request originRequest = chain.request();
        result=createHeaderAuthentication(originRequest);

        return chain.proceed(result);
    }

    private Request createHeaderAuthentication(Request originRequest) {
        Request.Builder builder=originRequest.newBuilder()
                .removeHeader(AppUtil.HEADER_AUTHENTICATION_KEY)
                .addHeader("Accept","application/json");
        if(!TextUtils.isEmpty(UserHolder.getInstance().getToken())){
            builder.addHeader(AppUtil.HEADER_AUTHENTICATION_KEY, "Bearer " + UserHolder.getInstance().getToken());
        }
        return builder.build();
    }
}
