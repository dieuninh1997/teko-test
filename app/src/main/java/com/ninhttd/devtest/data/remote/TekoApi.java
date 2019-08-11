package com.ninhttd.devtest.data.remote;

import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.presentation.view.ProductView;
import com.ninhttd.devtest.presentation.view.ProductViewLever1;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TekoApi {

    @GET("search")
    Single<ResponseListDTO<ProductView>> getProductList(
            @Query("channel") String channel,
            @Query("visitorId") String visitorId,
            @Query("q") String q,
            @Query("terminal") String terminal);

    @GET("search/?channel=pv_online&visitorId=&q=&terminal=CP01")
    Single<ResponseDTO<ProductViewLever1>> getProductList();
}
