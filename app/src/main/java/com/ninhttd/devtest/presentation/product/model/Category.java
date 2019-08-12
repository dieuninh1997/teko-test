
package com.ninhttd.devtest.presentation.product.model;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Category {

    @SerializedName("code")
    private String mCode;
    @SerializedName("id")
    private Long mId;
    @SerializedName("level")
    private Long mLevel;
    @SerializedName("name")
    private String mName;
    @SerializedName("parentId")
    private Long mParentId;

    public String getCode() {
        return mCode;
    }

    public void setCode(String code) {
        mCode = code;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public Long getLevel() {
        return mLevel;
    }

    public void setLevel(Long level) {
        mLevel = level;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getParentId() {
        return mParentId;
    }

    public void setParentId(Long parentId) {
        mParentId = parentId;
    }

}
