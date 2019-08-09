package com.ninhttd.devtest.base;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import java.util.List;

public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(T obj);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<T> objs);

    @Update
    void update(T obj);

    @Delete
    void delete(T obj);
}
