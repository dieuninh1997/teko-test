package com.ninhttd.devtest.presentation.product.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Product {
    @Setter
    private String sku; //ma san pham


    @Setter
    @Getter
    private Color color;

    @Setter
    private Price price;

    public String getSku() {
        return sku;
    }

    public Price getPrice() {
        return price;
    }

    private List<Image> images;
    private String displayName;

    public String getDisplayName() {
        return displayName;
    }

    public List<Image> getImages() {
        return images;
    }

    public Product(String sku, String displayName, Color color, List<Image> images, Price price) {
        this.sku = sku;
        this.displayName = displayName;
        this.color = color;
        this.images = images;
        this.price = price;
    }

    public class Color {
        private String code;
        private String name;
    }

    public class Image {
        private String url;
        private String priority;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public class Price {
        private String supplierSalePrice;
        private String sellPrice;

        public String getSupplierSalePrice() {
            return supplierSalePrice;
        }

        public void setSupplierSalePrice(String supplierSalePrice) {
            this.supplierSalePrice = supplierSalePrice;
        }

        public String getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(String sellPrice) {
            this.sellPrice = sellPrice;
        }
    }


}

