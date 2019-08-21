package com.ninhttd.devtest.data.local.dao

import androidx.room.Dao
import androidx.room.Query

import com.ninhttd.devtest.base.BaseDao
import com.ninhttd.devtest.data.entity.ProductEntity

import io.reactivex.Single

@Dao
interface ProductDao : BaseDao<ProductEntity> {
    @get:Query("select * from ProductEntity")
    val all: Single<List<ProductEntity>>

    @get:Query("select * from ProductEntity")
    val allNoThread: List<ProductEntity>

    @Query("select * from ProductEntity where displayName like :key")
    fun search(key: String): Single<List<ProductEntity>>
}
