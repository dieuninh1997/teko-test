
package com.ninhttd.devtest.presentation.product.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Rating {

    @SerializedName("averagePoint")
    private Object mAveragePoint;
    @SerializedName("voteCount")
    private Object mVoteCount;

    public Object getAveragePoint() {
        return mAveragePoint;
    }

    public void setAveragePoint(Object averagePoint) {
        mAveragePoint = averagePoint;
    }

    public Object getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(Object voteCount) {
        mVoteCount = voteCount;
    }

}
