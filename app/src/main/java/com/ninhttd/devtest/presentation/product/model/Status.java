
package com.ninhttd.devtest.presentation.product.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Status {

    @SerializedName("publish")
    private Boolean mPublish;
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
