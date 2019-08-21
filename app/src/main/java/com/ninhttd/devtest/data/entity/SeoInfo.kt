package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName

class SeoInfo {

    @SerializedName("description")
    var description: String? = null
    @SerializedName("metaDescription")
    var metaDescription: String? = null
    @SerializedName("metaKeyword")
    var metaKeyword: String? = null
    @SerializedName("metaTitle")
    var metaTitle: String? = null
    @SerializedName("shortDescription")
    var shortDescription: String? = null

}
