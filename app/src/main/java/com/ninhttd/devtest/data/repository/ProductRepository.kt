package com.ninhttd.devtest.data.repository

import com.google.common.collect.Collections2
import com.google.common.collect.Lists
import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.data.entity.ProductLevel1
import com.ninhttd.devtest.data.entity.ProductLevel2
import com.ninhttd.devtest.data.local.TekoDb
import com.ninhttd.devtest.data.api.TekoApi

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Single

@Singleton
class ProductRepository @Inject
constructor(private val tekoApi: TekoApi, private val tekoDb: TekoDb) {

    val productList: Single<ResponseDTO<ProductLevel1>>
        get() = tekoApi.productList.map { productLevel1ResponseDTO ->

            saveProducts(productLevel1ResponseDTO.result!!.productEntities)
            productLevel1ResponseDTO
        }

    val productListDb: Single<List<ProductEntity>>
        get() = tekoDb.productDao().all

    fun loadMore(page: Int): Single<ResponseDTO<ProductLevel1>> {
        return tekoApi.getProductList(page).map { productLevel1ResponseDTO ->
            saveProducts(productLevel1ResponseDTO.result!!.productEntities)
            productLevel1ResponseDTO
        }
    }

    fun saveProducts(productEntities: List<ProductEntity>?) {
        tekoDb.productDao().save(productEntities!!)
    }

    fun getProductDetail(sku: String): Single<ResponseDTO<ProductLevel2>> {
        return tekoApi.getProductDetail(sku)
    }

    fun search1(key: String): Single<List<ProductEntity>> {
        return tekoDb.productDao().all
                .map { productEntities ->
                    Lists.newArrayList(Collections2.filter(productEntities) { input ->
                        input!!.displayName!!.toLowerCase().contains(key)
                    })

                }

    }

    fun search(key: String): Single<List<ProductEntity>> {
        return tekoDb.productDao().search("%$key%")

    }

    companion object {
        private val TAG = "ProductRepository"
    }


}
