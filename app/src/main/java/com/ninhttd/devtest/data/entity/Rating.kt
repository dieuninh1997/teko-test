package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName

class Rating {

    @SerializedName("averagePoint")
    var averagePoint: Any? = null
    @SerializedName("voteCount")
    var voteCount: Any? = null

}
