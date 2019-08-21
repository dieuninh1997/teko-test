package com.ninhttd.devtest.data.remote.interceptor

import com.ninhttd.devtest.data.remote.exception.NetworkException
import com.ninhttd.devtest.utils.NetworkUtils

import java.io.IOException

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtils.isNetworkAvailable) {
            throw NetworkException()
        }
        return chain.proceed(chain.request())
    }
}
