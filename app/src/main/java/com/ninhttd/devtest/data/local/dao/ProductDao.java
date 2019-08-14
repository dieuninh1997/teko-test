package com.ninhttd.devtest.data.local.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.ninhttd.devtest.base.BaseDao;
import com.ninhttd.devtest.data.entity.ProductEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProductDao extends BaseDao<ProductEntity> {
    @Query("select * from ProductEntity")
    Single<List<ProductEntity>> getAll();

    @Query("select * from ProductEntity")
    List<ProductEntity> getAllNoThread();

    @Query("select * from ProductEntity where mDisplayName like :key")
    Single<List<ProductEntity>> search(String key);
}
