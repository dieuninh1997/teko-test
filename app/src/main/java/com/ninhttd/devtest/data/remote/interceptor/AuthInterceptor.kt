package com.ninhttd.devtest.data.remote.interceptor

import android.text.TextUtils

import com.ninhttd.devtest.data.local.UserHolder
import com.ninhttd.devtest.utils.AppUtil

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val result: Request
        val originRequest = chain.request()
        result = createHeaderAuthentication(originRequest)

        return chain.proceed(result)
    }

    private fun createHeaderAuthentication(originRequest: Request): Request {
        val builder = originRequest.newBuilder()
                .removeHeader(AppUtil.HEADER_AUTHENTICATION_KEY)
                .addHeader("Accept", "application/json")
//        if (!TextUtils.isEmpty(UserHolder.getInstance().token)) {
//            builder.addHeader(AppUtil.HEADER_AUTHENTICATION_KEY, "Bearer " + UserHolder.getInstance().token!!)
//        }
        return builder.build()
    }
}
