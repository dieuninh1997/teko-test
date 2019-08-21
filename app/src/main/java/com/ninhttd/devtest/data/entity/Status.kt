package com.ninhttd.devtest.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName


@Entity
class Status {

    @ColumnInfo
    @SerializedName("publish")
    var publish: Boolean? = null

    @PrimaryKey
    @SerializedName("sale")
    var sale: String? = null

}
