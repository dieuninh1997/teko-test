
package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.Expose;

import java.util.List;

@SuppressWarnings("unused")
public class MProduct {

    @Expose
    private List<Object> allActiveFlashSales;
    @Expose
    private List<AttributeGroup> attributeGroups;
    @Expose
    private AttributeSet attributeSet;
    @Expose
    private List<Attribute> attributes;
    @Expose
    private Brand brand;
    @Expose
    private List<Category> categories;
    @Expose
    private Color color;
    @Expose
    private String createdAt;
    @Expose
    private String displayName;
    @Expose
    private List<Object> flashSales;
    @Expose
    private List<Image> images;
    @Expose
    private Object magentoId;
    @Expose
    private String name;
    @Expose
    private Objective objective;
    @Expose
    private Price price;
    @Expose
    private ProductLine productLine;
    @Expose
    private ProductType productType;
    @Expose
    private List<Object> promotionPrices;
    @Expose
    private List<Object> promotions;
    @Expose
    private Rating rating;
    @Expose
    private SeoInfo seoInfo;
    @Expose
    private String sku;
    @Expose
    private Status status;
    @Expose
    private List<Object> stocks;
    @Expose
    private List<Object> tags;
    @Expose
    private Object taxOut;
    @Expose
    private Object totalAvailable;
    @Expose
    private Object url;
    @Expose
    private Warranty warranty;

    public List<Object> getAllActiveFlashSales() {
        return allActiveFlashSales;
    }

    public void setAllActiveFlashSales(List<Object> allActiveFlashSales) {
        this.allActiveFlashSales = allActiveFlashSales;
    }

    public List<AttributeGroup> getAttributeGroups() {
        return attributeGroups;
    }

    public void setAttributeGroups(List<AttributeGroup> attributeGroups) {
        this.attributeGroups = attributeGroups;
    }

    public AttributeSet getAttributeSet() {
        return attributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        this.attributeSet = attributeSet;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Object> getFlashSales() {
        return flashSales;
    }

    public void setFlashSales(List<Object> flashSales) {
        this.flashSales = flashSales;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Object getMagentoId() {
        return magentoId;
    }

    public void setMagentoId(Object magentoId) {
        this.magentoId = magentoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<Object> getPromotionPrices() {
        return promotionPrices;
    }

    public void setPromotionPrices(List<Object> promotionPrices) {
        this.promotionPrices = promotionPrices;
    }

    public List<Object> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Object> promotions) {
        this.promotions = promotions;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public SeoInfo getSeoInfo() {
        return seoInfo;
    }

    public void setSeoInfo(SeoInfo seoInfo) {
        this.seoInfo = seoInfo;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Object> getStocks() {
        return stocks;
    }

    public void setStocks(List<Object> stocks) {
        this.stocks = stocks;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public Object getTaxOut() {
        return taxOut;
    }

    public void setTaxOut(Object taxOut) {
        this.taxOut = taxOut;
    }

    public Object getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(Object totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

}
