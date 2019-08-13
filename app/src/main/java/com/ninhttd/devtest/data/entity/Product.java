
package com.ninhttd.devtest.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity
public class Product {
    @ColumnInfo
    @SerializedName("allActiveFlashSales")
    private ArrayList<ActiveFlashSale> mAllActiveFlashSales;

    @ColumnInfo
    @SerializedName("attributeGroups")
    private ArrayList<AttributeGroup> mAttributeGroups;

    @ColumnInfo
    @SerializedName("attributeSet")
    private AttributeSet mAttributeSet;

    @ColumnInfo
    @SerializedName("attributes")
    private ArrayList<Attribute> mAttributes;

    @ColumnInfo
    @SerializedName("brand")
    private Brand mBrand;

    @ColumnInfo
    @SerializedName("categories")
    private ArrayList<Category> mCategories;

    @ColumnInfo
    @SerializedName("color")
    private Color mColor;

    @ColumnInfo
    @SerializedName("createdAt")
    private String mCreatedAt;

    @ColumnInfo
    @SerializedName("displayName")
    private String mDisplayName;

    @ColumnInfo
    @SerializedName("flashSales")
    private ArrayList<Object> mFlashSales;

    @ColumnInfo
    @SerializedName("images")
    private ArrayList<Image> mImages;

    @ColumnInfo
    @SerializedName("magentoId")
    private Double mMagentoId;

    @ColumnInfo
    @SerializedName("name")
    private String mName;

    @ColumnInfo
    @SerializedName("objective")
    private Objective mObjective;

    @ColumnInfo
    @SerializedName("price")
    private Price mPrice;

    @ColumnInfo
    @SerializedName("productLine")
    private ProductLine mProductLine;

    @ColumnInfo
    @SerializedName("productType")
    private ProductType mProductType;

    @ColumnInfo
    @SerializedName("promotionPrices")
    private ArrayList<Object> mPromotionPrices;

    @ColumnInfo
    @SerializedName("promotions")
    private ArrayList<Object> mPromotions;

    @ColumnInfo
    @SerializedName("rating")
    private Rating mRating;

    @ColumnInfo
    @SerializedName("seoInfo")
    private SeoInfo mSeoInfo;

    @PrimaryKey
    @NonNull
    @SerializedName("sku")
    private String mSku;

    @ColumnInfo
    @SerializedName("status")
    private Status mStatus;

    @ColumnInfo
    @SerializedName("stocks")
    private ArrayList<Object> mStocks;

    @ColumnInfo
    @SerializedName("tags")
    private ArrayList<Object> mTags;

    @ColumnInfo
    @SerializedName("taxOut")
    private Double mTaxOut;

    @ColumnInfo
    @SerializedName("totalAvailable")
    private Double mTotalAvailable;

    @ColumnInfo
    @SerializedName("url")
    private String mUrl;

    @ColumnInfo
    @SerializedName("warranty")
    private Warranty mWarranty;

    public ArrayList<ActiveFlashSale> getAllActiveFlashSales() {
        return mAllActiveFlashSales;
    }

    public void setAllActiveFlashSales(ArrayList<ActiveFlashSale> allActiveFlashSales) {
        mAllActiveFlashSales = allActiveFlashSales;
    }

    public ArrayList<AttributeGroup> getAttributeGroups() {
        return mAttributeGroups;
    }

    public void setAttributeGroups(ArrayList<AttributeGroup> attributeGroups) {
        mAttributeGroups = attributeGroups;
    }

    public AttributeSet getAttributeSet() {
        return mAttributeSet;
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        mAttributeSet = attributeSet;
    }

    public ArrayList<Attribute> getAttributes() {
        return mAttributes;
    }

    public void setAttributes(ArrayList<Attribute> attributes) {
        mAttributes = attributes;
    }

    public Brand getBrand() {
        return mBrand;
    }

    public void setBrand(Brand brand) {
        mBrand = brand;
    }

    public ArrayList<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(ArrayList<Category> categories) {
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

    public ArrayList<Object> getFlashSales() {
        return mFlashSales;
    }

    public void setFlashSales(ArrayList<Object> flashSales) {
        mFlashSales = flashSales;
    }

    public ArrayList<Image> getImages() {
        return mImages;
    }

    public void setImages(ArrayList<Image> images) {
        mImages = images;
    }

    public Double getMagentoId() {
        return mMagentoId;
    }

    public void setMagentoId(Double magentoId) {
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

    public ArrayList<Object> getPromotionPrices() {
        return mPromotionPrices;
    }

    public void setPromotionPrices(ArrayList<Object> promotionPrices) {
        mPromotionPrices = promotionPrices;
    }

    public ArrayList<Object> getPromotions() {
        return mPromotions;
    }

    public void setPromotions(ArrayList<Object> promotions) {
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

    public ArrayList<Object> getStocks() {
        return mStocks;
    }

    public void setStocks(ArrayList<Object> stocks) {
        mStocks = stocks;
    }

    public ArrayList<Object> getTags() {
        return mTags;
    }

    public void setTags(ArrayList<Object> tags) {
        mTags = tags;
    }

    public Double getTaxOut() {
        return mTaxOut;
    }

    public void setTaxOut(Double taxOut) {
        mTaxOut = taxOut;
    }

    public Double getTotalAvailable() {
        return mTotalAvailable;
    }

    public void setTotalAvailable(Double totalAvailable) {
        mTotalAvailable = totalAvailable;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Warranty getWarranty() {
        return mWarranty;
    }

    public void setWarranty(Warranty warranty) {
        mWarranty = warranty;
    }


}
