package com.ninhttd.devtest.presentation.product.model;

import com.google.gson.annotations.SerializedName;

public class ProductLevel2 {
    @SerializedName("product")
    public Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
