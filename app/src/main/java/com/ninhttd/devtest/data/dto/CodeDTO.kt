package com.ninhttd.devtest.data.dto

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class CodeDTO : Serializable {

    @SerializedName("code")
    var code: String? = null
}
