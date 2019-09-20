package com.ninhttd.devtest.base

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(objs: List<T>)

    @Update
    fun update(obj: T)

    @Delete
    fun delete(obj: T)
}
