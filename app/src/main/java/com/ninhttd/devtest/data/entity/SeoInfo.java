
package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SeoInfo {

    @SerializedName("description")
    private String mDescription;
    @SerializedName("metaDescription")
    private String mMetaDescription;
    @SerializedName("metaKeyword")
    private String mMetaKeyword;
    @SerializedName("metaTitle")
    private String mMetaTitle;
    @SerializedName("shortDescription")
    private String mShortDescription;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getMetaDescription() {
        return mMetaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        mMetaDescription = metaDescription;
    }

    public String getMetaKeyword() {
        return mMetaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        mMetaKeyword = metaKeyword;
    }

    public String getMetaTitle() {
        return mMetaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        mMetaTitle = metaTitle;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

}
