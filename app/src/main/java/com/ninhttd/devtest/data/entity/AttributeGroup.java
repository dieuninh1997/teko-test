
package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;

public class AttributeGroup {

    @SerializedName("id")
    private Object mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("parentId")
    private Long mParentId;
    @SerializedName("priority")
    private Long mPriority;
    @SerializedName("value")
    private String mValue;

    public Object getId() {
        return mId;
    }

    public void setId(Object id) {
        mId = id;
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

    public Long getPriority() {
        return mPriority;
    }

    public void setPriority(Long priority) {
        mPriority = priority;
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }

}
