package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;

public class ProductLevel2 {
    @SerializedName("productEntity")
    public ProductEntity productEntity;

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
