
package com.ninhttd.devtest.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
@Entity
public class Status {

    @ColumnInfo
    @SerializedName("publish")
    private Boolean mPublish;

    @PrimaryKey
    @SerializedName("sale")
    private String mSale;

    public Boolean getPublish() {
        return mPublish;
    }

    public void setPublish(Boolean publish) {
        mPublish = publish;
    }

    public String getSale() {
        return mSale;
    }

    public void setSale(String sale) {
        mSale = sale;
    }

}
