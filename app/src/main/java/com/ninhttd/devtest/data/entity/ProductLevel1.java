package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductLevel1 {
    @SerializedName("products")
  public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}

