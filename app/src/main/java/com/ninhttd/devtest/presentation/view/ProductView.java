package com.ninhttd.devtest.presentation.view;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ProductView {
    @Setter
    @Getter
    private String sku; //ma san pham
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private Color color;
    @Setter
    @Getter
    private List<Image> images;
    @Setter
    @Getter
    private Price price;


    public ProductView(String sku, String name, Color color, List<Image> images, Price price) {
        this.sku = sku;
        this.name = name;
        this.color = color;
        this.images = images;
        this.price = price;
    }

    class Color {
        private String code;
        private String name;
    }

    class Image {
        private String url;
        private String priority;
    }

    class Price {
        private String supplierSalePrice;
        private String sellPrice;
    }


}

