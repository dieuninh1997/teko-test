
package com.ninhttd.devtest.data.entity;

import com.google.gson.annotations.SerializedName;


@SuppressWarnings("unused")
public class Image {

    @SerializedName("priority")
    private Long mPriority;
    @SerializedName("url")
    private String mUrl;

    public Long getPriority() {
        return mPriority;
    }

    public void setPriority(Long priority) {
        mPriority = priority;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
