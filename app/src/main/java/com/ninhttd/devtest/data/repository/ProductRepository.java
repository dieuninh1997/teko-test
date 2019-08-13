package com.ninhttd.devtest.data.repository;

import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.local.TekoDb;
import com.ninhttd.devtest.data.remote.TekoApi;
import com.ninhttd.devtest.data.entity.Product;
import com.ninhttd.devtest.data.entity.ProductLevel1;
import com.ninhttd.devtest.data.entity.ProductLevel2;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class ProductRepository {
    private static final String TAG = "ProductRepository";
    private TekoApi tekoApi;
    private Product product;

    @Inject
    public ProductRepository(TekoApi tekoApi) {
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

    public Single<ResponseDTO<ProductLevel1>> loadMore(int page) {
        return tekoApi.getProductList(page);
    }

    public Single<ResponseDTO<ProductLevel2>> getProductDetail(String sku) {
        return  tekoApi.getProductDetail(sku);
    }

    public List<Product> getProductListDb() {
        return TekoDb.getTekoDb().productDao().getAll();
    }

}
