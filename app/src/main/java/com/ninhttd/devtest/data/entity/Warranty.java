
package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Warranty {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("months")
    private Long mMonths;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Long getMonths() {
        return mMonths;
    }

    public void setMonths(Long months) {
        mMonths = months;
    }

}
