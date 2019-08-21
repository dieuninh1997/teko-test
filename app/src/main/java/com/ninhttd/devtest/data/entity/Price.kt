package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName


class Price {

    @SerializedName("sellPrice")
    var sellPrice: Any? = null
    @SerializedName("supplierSalePrice")
    var supplierSalePrice: Any? = null

}
