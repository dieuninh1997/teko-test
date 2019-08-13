
package com.ninhttd.devtest.data.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Attribute {

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
