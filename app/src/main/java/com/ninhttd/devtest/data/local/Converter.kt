package com.ninhttd.devtest.data.local

import androidx.room.TypeConverter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ninhttd.devtest.data.entity.ActiveFlashSale
import com.ninhttd.devtest.data.entity.Attribute
import com.ninhttd.devtest.data.entity.AttributeGroup
import com.ninhttd.devtest.data.entity.AttributeSet
import com.ninhttd.devtest.data.entity.Brand
import com.ninhttd.devtest.data.entity.Category
import com.ninhttd.devtest.data.entity.Color
import com.ninhttd.devtest.data.entity.Image
import com.ninhttd.devtest.data.entity.Objective
import com.ninhttd.devtest.data.entity.Price
import com.ninhttd.devtest.data.entity.ProductLine
import com.ninhttd.devtest.data.entity.ProductType
import com.ninhttd.devtest.data.entity.Rating
import com.ninhttd.devtest.data.entity.SeoInfo
import com.ninhttd.devtest.data.entity.Status
import com.ninhttd.devtest.data.entity.Warranty

import java.lang.reflect.Type
import java.util.ArrayList
import java.util.Collections

class Converter {
    private val gson = Gson()

    @TypeConverter
    fun stringToListObject(data: String?): ArrayList<Any> {
        if (data == null) {
            return emptyList<Any>() as ArrayList<Any>
        }

        val listType = object : TypeToken<ArrayList<Any>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun listObjectToString(lst: ArrayList<Any>?): String {
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToProductLine(data: String?): ProductLine? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ProductLine>() {

        }.type

        return gson.fromJson<ProductLine>(data, listType)
    }

    @TypeConverter
    fun productLineToString(lst: ProductLine?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToProductType(data: String?): ProductType? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ProductType>() {

        }.type

        return gson.fromJson<ProductType>(data, listType)
    }

    @TypeConverter
    fun productTypeToString(lst: ProductType?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToRating(data: String?): Rating? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Rating>() {

        }.type

        return gson.fromJson<Rating>(data, listType)
    }

    @TypeConverter
    fun ratingToString(lst: Rating?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToListAttributeGroup(data: String?): ArrayList<AttributeGroup>? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ArrayList<AttributeGroup>>() {

        }.type

        return gson.fromJson<ArrayList<AttributeGroup>>(data, listType)
    }

    @TypeConverter
    fun listAttributeGroupToString(lst: ArrayList<AttributeGroup>?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToAttributeSet(data: String?): AttributeSet? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<AttributeSet>() {

        }.type

        return gson.fromJson<AttributeSet>(data, listType)
    }

    @TypeConverter
    fun attributeSetToString(lst: AttributeSet?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToWarranty(data: String?): Warranty? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Warranty>() {

        }.type

        return gson.fromJson<Warranty>(data, listType)
    }

    @TypeConverter
    fun warrantyToString(lst: Warranty?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToStatus(data: String?): Status? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Status>() {

        }.type

        return gson.fromJson<Status>(data, listType)
    }

    @TypeConverter
    fun statusToString(lst: Status?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToSeoInfo(data: String?): SeoInfo? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<SeoInfo>() {

        }.type

        return gson.fromJson<SeoInfo>(data, listType)
    }

    @TypeConverter
    fun seoInfoToString(lst: SeoInfo?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToListAttribute(data: String?): ArrayList<Attribute>? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ArrayList<Attribute>>() {

        }.type

        return gson.fromJson<ArrayList<Attribute>>(data, listType)
    }

    @TypeConverter
    fun listAttributeToString(lst: ArrayList<Attribute>?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToBrand(data: String?): Brand? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Brand>() {

        }.type

        return gson.fromJson<Brand>(data, listType)
    }

    @TypeConverter
    fun brandToString(lst: Brand?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToListCategory(data: String?): ArrayList<Category>? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ArrayList<Category>>() {

        }.type

        return gson.fromJson<ArrayList<Category>>(data, listType)
    }

    @TypeConverter
    fun listCategoryToString(lst: ArrayList<Category>): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToColor(data: String?): Color? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Color>() {

        }.type

        return gson.fromJson<Color>(data, listType)
    }

    @TypeConverter
    fun colorToString(lst: Color): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToObjective(data: String?): Objective? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Objective>() {

        }.type

        return gson.fromJson<Objective>(data, listType)
    }

    @TypeConverter
    fun objectiveToString(lst: Objective): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToListImage(data: String?): ArrayList<Image>? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ArrayList<Image>>() {

        }.type

        return gson.fromJson<ArrayList<Image>>(data, listType)
    }

    @TypeConverter
    fun listImageToString(lst: ArrayList<Image>): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToPrice(data: String?): Price? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<Price>() {

        }.type

        return gson.fromJson<Price>(data, listType)
    }

    @TypeConverter
    fun priceToString(lst: Price): String {
        val gson = Gson()
        return gson.toJson(lst)
    }

    @TypeConverter
    fun stringToListActiveFlashSale(data: String?): ArrayList<ActiveFlashSale>? {
        if (data == null) {
            return null
        }

        val listType = object : TypeToken<ArrayList<ActiveFlashSale>>() {

        }.type

        return gson.fromJson<ArrayList<ActiveFlashSale>>(data, listType)
    }

    @TypeConverter
    fun listActiveFlashSaleToString(lst: ArrayList<ActiveFlashSale>?): String {
        val gson = Gson()
        return gson.toJson(lst)
    }
}