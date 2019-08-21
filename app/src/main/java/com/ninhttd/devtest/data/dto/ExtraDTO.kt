package com.ninhttd.devtest.data.dto


import com.google.gson.annotations.SerializedName

class ExtraDTO {

    @SerializedName("page")
    var page: Long? = null
    @SerializedName("pageSize")
    var pageSize: Long? = null
    @SerializedName("totalItems")
    var totalItems: Long? = null

}
