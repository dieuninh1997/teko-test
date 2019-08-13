package com.ninhttd.devtest.data.repository;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.local.TekoDb;
import com.ninhttd.devtest.data.remote.TekoApi;
import com.ninhttd.devtest.data.entity.Product;
import com.ninhttd.devtest.data.entity.ProductLevel1;
import com.ninhttd.devtest.data.entity.ProductLevel2;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.functions.Function;

@Singleton
public class ProductRepository {
    private static final String TAG = "ProductRepository";
    private TekoApi tekoApi;
    private TekoDb tekoDb;
    private Product product;

    @Inject
    public ProductRepository(TekoApi tekoApi, TekoDb tekoDb) {
        this.tekoApi = tekoApi;
        this.tekoDb = tekoDb;
    }


    public Single<ResponseListDTO<Product>> getProductList(String channel,
                                                           String visitorId,
                                                           String q,
                                                           String terminal) {
        return tekoApi.getProductList(channel, visitorId, q, terminal);
    }


    public Single<ResponseDTO<ProductLevel1>> getProductList() {
        return tekoApi.getProductList().map(productLevel1ResponseDTO ->
        {
            saveProducts(productLevel1ResponseDTO.getResult().getProducts());
            return productLevel1ResponseDTO;
        });
    }

    public Single<ResponseDTO<ProductLevel1>> loadMore(int page) {
        return tekoApi.getProductList(page).map(
                productLevel1ResponseDTO ->
                {
                    saveProducts(productLevel1ResponseDTO.getResult().getProducts());
                    return productLevel1ResponseDTO;
                });
    }

    public void saveProducts(List<Product> products) {
        tekoDb.productDao().save(products);
    }

    public Single<ResponseDTO<ProductLevel2>> getProductDetail(String sku) {
        return tekoApi.getProductDetail(sku);
    }

    public List<Product> getProductListDb() {
        return tekoDb.productDao().getAll();
    }

    public List<Product> search(String key) {
        List<Product> searchResult = Lists.newArrayList(Collections2.filter(tekoDb.productDao().getAll(), input -> input.getDisplayName().toLowerCase().contains(key)));
        return searchResult;
    }

}
