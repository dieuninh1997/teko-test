package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName

class ActiveFlashSale {
    @SerializedName("code")
    var code: String? = null
    @SerializedName("values")
    var values: List<Any>? = null
}
