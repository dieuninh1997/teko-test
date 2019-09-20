package com.ninhttd.devtest.data.api

import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.entity.ProductLevel1
import com.ninhttd.devtest.data.entity.ProductLevel2

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TekoApi {
    @get:GET("search/?channel=pv_online&visitorId=&q=&terminal=CP01")
    val productList: Single<ResponseDTO<ProductLevel1>>


    @GET("search/?channel=pv_online&visitorId=&q=&terminal=CP01")
    fun getProductList(@Query("_page") page: Int): Single<ResponseDTO<ProductLevel1>>

    @GET("products/{product_sku}")
    fun getProductDetail(@Path("product_sku") sku: String): Single<ResponseDTO<ProductLevel2>>
}
