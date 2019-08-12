package com.ninhttd.devtest.data.repository;

import android.util.Log;

import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.remote.TekoApi;
import com.ninhttd.devtest.presentation.product.model.Product;
import com.ninhttd.devtest.presentation.product.model.ProductLevel1;
import com.ninhttd.devtest.presentation.product.model.ProductLevel2;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

@Singleton
public class TekoRepository {
    private static final String TAG="TekoRepository";
    private TekoApi tekoApi;

    @Inject
    public TekoRepository(TekoApi tekoApi) {
        this.tekoApi = tekoApi;
    }


    public Single<ResponseListDTO<Product>> getProductList(String channel,
                                                           String visitorId,
                                                           String q,
                                                           String terminal) {
        return tekoApi.getProductList(channel, visitorId, q, terminal);
    }


    public Single<ResponseDTO<ProductLevel1>> getProductList() {
        return tekoApi.getProductList();
    }

    public Single<ResponseDTO<ProductLevel1>> loadMore(int page)
    {
        return tekoApi.getProductList(page);
    }

    public Single<ResponseDTO<ProductLevel2>> getProductDetail(String sku) {
        return tekoApi.getProductDetail(sku);
    }
}
