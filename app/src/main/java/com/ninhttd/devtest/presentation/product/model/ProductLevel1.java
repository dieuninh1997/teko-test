package com.ninhttd.devtest.presentation.product.model;

import com.google.gson.annotations.SerializedName;
import com.ninhttd.devtest.presentation.product.model.Product;

import java.util.List;

public class ProductLevel1 {
    @SerializedName("products")
  public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
}

