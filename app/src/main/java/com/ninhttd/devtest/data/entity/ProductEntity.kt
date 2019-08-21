package com.ninhttd.devtest.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.JsonAdapter

import com.google.gson.annotations.SerializedName
import com.google.gson.internal.bind.DateTypeAdapter
import com.ninhttd.devtest.data.api.deserialized.DateDeSerialized
import com.ninhttd.devtest.data.api.serialized.DateSerialized
import java.util.*

@Entity
class ProductEntity {
    @ColumnInfo
    @SerializedName("allActiveFlashSales")
    var allActiveFlashSales: ArrayList<ActiveFlashSale>? = null

    @ColumnInfo
    @SerializedName("attributeGroups")
    var attributeGroups: ArrayList<AttributeGroup>? = null

    @ColumnInfo
    @SerializedName("attributeSet")
    var attributeSet: AttributeSet? = null

    @ColumnInfo
    @SerializedName("attributes")
    var attributes: ArrayList<Attribute>? = null

    @ColumnInfo
    @SerializedName("brand")
    var brand: Brand? = null

    @ColumnInfo
    @SerializedName("categories")
    var categories: ArrayList<Category>? = null

    @ColumnInfo
    @SerializedName("color")
    var color: Color? = null

    @ColumnInfo
    @SerializedName("createdAt")
    var createdAt: String? = null

    @ColumnInfo
    @SerializedName("displayName")
    var displayName: String? = null

    @ColumnInfo
    @SerializedName("flashSales")
    var flashSales: ArrayList<Any>? = null

    @ColumnInfo
    @SerializedName("images")
    var images: ArrayList<Image>? = null

    @ColumnInfo
    @SerializedName("magentoId")
    var magentoId: Double? = null

    @ColumnInfo
    @SerializedName("name")
    var name: String? = null

    @ColumnInfo
    @SerializedName("objective")
    var objective: Objective? = null

    @ColumnInfo
    @SerializedName("price")
    var price: Price? = null

    @ColumnInfo
    @SerializedName("productLine")
    var productLine: ProductLine? = null

    @ColumnInfo
    @SerializedName("productType")
    var productType: ProductType? = null

    @ColumnInfo
    @SerializedName("promotionPrices")
    var promotionPrices: ArrayList<Any>? = null

    @ColumnInfo
    @SerializedName("promotions")
    var promotions: ArrayList<Any>? = null

    @ColumnInfo
    @SerializedName("rating")
    var rating: Rating? = null

    @ColumnInfo
    @SerializedName("seoInfo")
    var seoInfo: SeoInfo? = null

    @PrimaryKey
    @SerializedName("sku")
    var sku: String = ""

    @ColumnInfo
    @SerializedName("status")
    var status: Status? = null

    @ColumnInfo
    @SerializedName("stocks")
    var stocks: ArrayList<Any>? = null

    @ColumnInfo
    @SerializedName("tags")
    var tags: ArrayList<Any>? = null

    @ColumnInfo
    @SerializedName("taxOut")
    var taxOut: Double? = null

    @ColumnInfo
    @SerializedName("totalAvailable")
    var totalAvailable: Double? = null

    @ColumnInfo
    @SerializedName("url")
    var url: String? = null

    @ColumnInfo
    @SerializedName("warranty")
    var warranty: Warranty? = null


//    @ColumnInfo
//    @SerializedName(value = "user",alternate = arrayOf("cusro","blo","bla"))
//    @JsonAdapter(value = DateTypeAdapter::class,nullSafe = true)
//    var date: Date? = null

}
