package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName

class AttributeGroup {

    @SerializedName("id")
    var id: Any? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("parentId")
    var parentId: Long? = null
    @SerializedName("priority")
    var priority: Long? = null
    @SerializedName("value")
    var value: String? = null

}
