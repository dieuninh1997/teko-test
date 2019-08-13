package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActiveFlashSale {
    @SerializedName("code")
    private String mCode;
    @SerializedName("values")
    private List<Object> mValues;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public List<Object> getValues() {
        return mValues;
    }

    public void setValues(List<Object> values) {
        mValues = values;
    }
}
