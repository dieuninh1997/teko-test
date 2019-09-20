package com.ninhttd.devtest.data.entity

import com.google.gson.annotations.SerializedName

data class ProductLevel1( @SerializedName("products")
                          var productEntities: List<ProductEntity>? = null){

}

