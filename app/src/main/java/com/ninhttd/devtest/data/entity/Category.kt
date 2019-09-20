package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName


class Category {

    @SerializedName("code")
    var code: String? = null
    @SerializedName("id")
    var id: Long? = null
    @SerializedName("level")
    var level: Long? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("parentId")
    var parentId: Long? = null

}
