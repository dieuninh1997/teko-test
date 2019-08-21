package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName

class Warranty {

    @SerializedName("description")
    var description: String? = null
    @SerializedName("months")
    var months: Long? = null

}
