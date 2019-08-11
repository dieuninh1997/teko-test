package com.ninhttd.devtest.data.repository;

import android.util.Log;

import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.data.remote.TekoApi;
import com.ninhttd.devtest.presentation.view.ProductView;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class TekoRepository {
    private static final String TAG="TekoRepository";
    private TekoApi tekoApi;

    @Inject
    public TekoRepository(TekoApi tekoApi) {
        this.tekoApi = tekoApi;
    }


    public Single<ResponseListDTO<ProductView>> getProductList(String channel,
                                                               String visitorId,
                                                               String q,
                                                               String terminal) {
        Log.e(TAG, "getProductList params: (channel: "+channel+", visitorId: "+visitorId+", q: "+q+", terminal: "+terminal+")");
        Log.e(TAG, "tekoApi.getProductList: "+tekoApi.getProductList(channel, visitorId, q, terminal));

        return tekoApi.getProductList(channel, visitorId, q, terminal);
    }


    public Single<ResponseListDTO<ProductView>> getProductList() {
        Log.e(TAG, "tekoApi.getProductList no params: "+tekoApi.getProductList());
        return tekoApi.getProductList();
    }

}
