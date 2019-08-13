package com.ninhttd.devtest.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.ninhttd.devtest.base.BaseDao;
import com.ninhttd.devtest.data.entity.Product;

import java.util.List;

@Dao
public interface ProductDao extends BaseDao<Product> {
    @Query("select * from product")
    List<Product> getAll();

    @Query("select * from product where mDisplayName like :key")
    List<Product> search(String key);
}
