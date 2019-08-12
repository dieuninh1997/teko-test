
package com.ninhttd.devtest.data.dto;


import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ExtraDTO {

    @SerializedName("page")
    private Long mPage;
    @SerializedName("pageSize")
    private Long mPageSize;
    @SerializedName("totalItems")
    private Long mTotalItems;

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public Long getPageSize() {
        return mPageSize;
    }

    public void setPageSize(Long pageSize) {
        mPageSize = pageSize;
    }

    public Long getTotalItems() {
        return mTotalItems;
    }

    public void setTotalItems(Long totalItems) {
        mTotalItems = totalItems;
    }

}
