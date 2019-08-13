package com.ninhttd.devtest.data.remote;

import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.entity.Product;
import com.ninhttd.devtest.data.entity.ProductLevel1;
import com.ninhttd.devtest.data.entity.ProductLevel2;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TekoApi {

    @GET("search")
    Single<ResponseListDTO<Product>> getProductList(
            @Query("channel") String channel,
            @Query("visitorId") String visitorId,
            @Query("q") String q,
            @Query("terminal") String terminal);

    @GET("search/?channel=pv_online&visitorId=&q=&terminal=CP01")
    Single<ResponseDTO<ProductLevel1>> getProductList();


    @GET("search/?channel=pv_online&visitorId=&q=&terminal=CP01")
    Single<ResponseDTO<ProductLevel1>> getProductList(@Query("_page") int page);

    @GET("products/{product_sku}")
    Single<ResponseDTO<ProductLevel2>> getProductDetail(@Path("product_sku") String sku);
}
