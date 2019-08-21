package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName


class Image {

    @SerializedName("priority")
    var priority: Long? = null
    @SerializedName("url")
    var url: String? = null

}
