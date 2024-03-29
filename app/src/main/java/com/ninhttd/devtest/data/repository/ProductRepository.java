package com.ninhttd.devtest.data.repository;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.entity.ProductEntity;
import com.ninhttd.devtest.data.entity.ProductLevel1;
import com.ninhttd.devtest.data.entity.ProductLevel2;
import com.ninhttd.devtest.data.local.TekoDb;
import com.ninhttd.devtest.data.remote.TekoApi;


import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.functions.Function;

@Singleton
public class ProductRepository {
    private static final String TAG = "ProductRepository";
    private TekoApi tekoApi;
    private TekoDb tekoDb;

    @Inject
    public ProductRepository(TekoApi tekoApi, TekoDb tekoDb) {
        this.tekoApi = tekoApi;
        this.tekoDb = tekoDb;
    }

    public Single<ResponseDTO<ProductLevel1>> getProductList() {
        return tekoApi.getProductList().map(productLevel1ResponseDTO ->
        {

            saveProducts(productLevel1ResponseDTO.getResult().getProductEntities());
            return productLevel1ResponseDTO;
        });
    }

    public Single<ResponseDTO<ProductLevel1>> loadMore(int page) {
        return tekoApi.getProductList(page).map(
                productLevel1ResponseDTO ->
                {
                    saveProducts(productLevel1ResponseDTO.getResult().getProductEntities());
                    return productLevel1ResponseDTO;
                });
    }

    public void saveProducts(List<ProductEntity> productEntities) {
        tekoDb.productDao().save(productEntities);
    }

    public Single<ResponseDTO<ProductLevel2>> getProductDetail(String sku) {
        return tekoApi.getProductDetail(sku);
    }

    public Single<List<ProductEntity>> getProductListDb() {
        return tekoDb.productDao().getAll();
    }

    public Single<List<ProductEntity>> search1(String key) {
        return tekoDb.productDao().getAll()
                .map(productEntities -> Lists.newArrayList(Collections2.filter(productEntities, input -> input.getDisplayName().toLowerCase().contains(key))));

    }
    public Single<List<ProductEntity>> search(String key) {
        return tekoDb.productDao().search("%"+key+"%");

    }


}
