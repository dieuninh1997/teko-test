package com.ninhttd.devtest.data.dto

import com.google.gson.annotations.SerializedName

import java.io.Serializable

class ResponseDTO<DTO> : Serializable {
    var errors: String? = null

    var result: DTO? = null

    @SerializedName("extra")
    var extra: ExtraDTO? = null

    @SerializedName("code")
    var code: String? = null
}
