
package com.ninhttd.devtest.presentation.product.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("allActiveFlashSales")
    private List<Object> mAllActiveFlashSales;
    @SerializedName("attributeGroups")
    private List<AttributeGroup> mAttributeGroups;
    @SerializedName("attributeSet")
    private AttributeSet mAttributeSet;
    @SerializedName("attributes")
    private List<Attribute> mAttributes;
    @SerializedName("brand")
    private Brand mBrand;
    @SerializedName("categories")
    private List<Category> mCategories;
    @SerializedName("color")
    private Color mColor;
    @SerializedName("createdAt")
    private String mCreatedAt;
    @SerializedName("displayName")
    private String mDisplayName;
    @SerializedName("flashSales")
    private List<Object> mFlashSales;
    @SerializedName("images")
    private List<Image> mImages;
    @SerializedName("magentoId")
    private Object mMagentoId;
    @SerializedName("name")
    private String mName;
    @SerializedName("objective")
    private Objective mObjective;
    @SerializedName("price")
    private Price mPrice;
    @SerializedName("productLine")
    private ProductLine mProductLine;
    @SerializedName("productType")
    private ProductType mProductType;
    @SerializedName("promotionPrices")
    private List<Object> mPromotionPrices;
    @SerializedName("promotions")
    private List<Object> mPromotions;
    @SerializedName("rating")
    private Rating mRating;
    @SerializedName("seoInfo")
    private SeoInfo mSeoInfo;
    @SerializedName("sku")
    private String mSku;
    @SerializedName("status")
    private Status mStatus;
    @SerializedName("stocks")
    private List<Object> mStocks;
    @SerializedName("tags")
    private List<Object> mTags;
    @SerializedName("taxOut")
    private Object mTaxOut;
    @SerializedName("totalAvailable")
    private Object mTotalAvailable;
    @SerializedName("url")
    private Object mUrl;
    @SerializedName("warranty")
    private Warranty mWarranty;

    public List<Object> getAllActiveFlashSales() {
        return mAllActiveFlashSales;
    }

    public void setAllActiveFlashSales(List<Object> allActiveFlashSales) {
        mAllActiveFlashSales = allActiveFlashSales;
    }

    public List<AttributeGroup> getAttributeGroups() {
        return mAttributeGroups;
    }

    public void setAttributeGroups(List<AttributeGroup> attributeGroups) {
        mAttributeGroups = attributeGroups;
    }

    public AttributeSet getAttributeSet() {
        return mAttributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        mAttributeSet = attributeSet;
    }

    public List<Attribute> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        mAttributes = attributes;
    }

    public Brand getBrand() {
        return mBrand;
    }

    public void setBrand(Brand brand) {
        mBrand = brand;
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public Color getColor() {
        return mColor;
    }

    public void setColor(Color color) {
        mColor = color;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public List<Object> getFlashSales() {
        return mFlashSales;
    }

    public void setFlashSales(List<Object> flashSales) {
        mFlashSales = flashSales;
    }

    public List<Image> getImages() {
        return mImages;
    }

    public void setImages(List<Image> images) {
        mImages = images;
    }

    public Object getMagentoId() {
        return mMagentoId;
    }

    public void setMagentoId(Object magentoId) {
        mMagentoId = magentoId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Objective getObjective() {
        return mObjective;
    }

    public void setObjective(Objective objective) {
        mObjective = objective;
    }

    public Price getPrice() {
        return mPrice;
    }

    public void setPrice(Price price) {
        mPrice = price;
    }

    public ProductLine getProductLine() {
        return mProductLine;
    }

    public void setProductLine(ProductLine productLine) {
        mProductLine = productLine;
    }

    public ProductType getProductType() {
        return mProductType;
    }

    public void setProductType(ProductType productType) {
        mProductType = productType;
    }

    public List<Object> getPromotionPrices() {
        return mPromotionPrices;
    }

    public void setPromotionPrices(List<Object> promotionPrices) {
        mPromotionPrices = promotionPrices;
    }

    public List<Object> getPromotions() {
        return mPromotions;
    }

    public void setPromotions(List<Object> promotions) {
        mPromotions = promotions;
    }

    public Rating getRating() {
        return mRating;
    }

    public void setRating(Rating rating) {
        mRating = rating;
    }

    public SeoInfo getSeoInfo() {
        return mSeoInfo;
    }

    public void setSeoInfo(SeoInfo seoInfo) {
        mSeoInfo = seoInfo;
    }

    public String getSku() {
        return mSku;
    }

    public void setSku(String sku) {
        mSku = sku;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

    public List<Object> getStocks() {
        return mStocks;
    }

    public void setStocks(List<Object> stocks) {
        mStocks = stocks;
    }

    public List<Object> getTags() {
        return mTags;
    }

    public void setTags(List<Object> tags) {
        mTags = tags;
    }

    public Object getTaxOut() {
        return mTaxOut;
    }

    public void setTaxOut(Object taxOut) {
        mTaxOut = taxOut;
    }

    public Object getTotalAvailable() {
        return mTotalAvailable;
    }

    public void setTotalAvailable(Object totalAvailable) {
        mTotalAvailable = totalAvailable;
    }

    public Object getUrl() {
        return mUrl;
    }

    public void setUrl(Object url) {
        mUrl = url;
    }

    public Warranty getWarranty() {
        return mWarranty;
    }

    public void setWarranty(Warranty warranty) {
        mWarranty = warranty;
    }

}
