
package com.ninhttd.devtest.presentation.product.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Price {

    @SerializedName("sellPrice")
    private Object mSellPrice;
    @SerializedName("supplierSalePrice")
    private Object mSupplierSalePrice;

    public Object getSellPrice() {
        return mSellPrice;
    }

    public void setSellPrice(Object sellPrice) {
        mSellPrice = sellPrice;
    }

    public Object getSupplierSalePrice() {
        return mSupplierSalePrice;
    }

    public void setSupplierSalePrice(Object supplierSalePrice) {
        mSupplierSalePrice = supplierSalePrice;
    }

}
