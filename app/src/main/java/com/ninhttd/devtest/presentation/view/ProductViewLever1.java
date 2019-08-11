package com.ninhttd.devtest.presentation.view;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ProductViewLever1 {
    @SerializedName("products")
  public List<ProductView> products;

    public List<ProductView> getProducts() {
        return products;
    }
}

