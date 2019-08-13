package com.ninhttd.devtest.data.local;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ninhttd.devtest.data.entity.ActiveFlashSale;
import com.ninhttd.devtest.data.entity.Attribute;
import com.ninhttd.devtest.data.entity.AttributeGroup;
import com.ninhttd.devtest.data.entity.AttributeSet;
import com.ninhttd.devtest.data.entity.Brand;
import com.ninhttd.devtest.data.entity.Category;
import com.ninhttd.devtest.data.entity.Color;
import com.ninhttd.devtest.data.entity.Image;
import com.ninhttd.devtest.data.entity.Objective;
import com.ninhttd.devtest.data.entity.Price;
import com.ninhttd.devtest.data.entity.ProductLine;
import com.ninhttd.devtest.data.entity.ProductType;
import com.ninhttd.devtest.data.entity.Rating;
import com.ninhttd.devtest.data.entity.SeoInfo;
import com.ninhttd.devtest.data.entity.Status;
import com.ninhttd.devtest.data.entity.Warranty;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {
    private static Gson gson = new Gson();

    @TypeConverter
    public static ArrayList<Object> stringToListObject(String data) {
        if (data == null) {
            return (ArrayList<Object>) Collections.emptyList();
        }

        Type listType = new TypeToken<ArrayList<Object>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listObjectToString(ArrayList<Object> lst) {
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ProductLine stringToProductLine(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ProductLine>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String productLineToString(ProductLine lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ProductType stringToProductType(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ProductType>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String productTypeToString(ProductType lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Rating stringToRating(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Rating>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ratingToString(Rating lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ArrayList<AttributeGroup> stringToListAttributeGroup(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ArrayList<AttributeGroup>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listAttributeGroupToString(ArrayList<AttributeGroup> lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static AttributeSet stringToAttributeSet(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<AttributeSet>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String attributeSetToString(AttributeSet lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Warranty stringToWarranty(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Warranty>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String warrantyToString(Warranty lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Status stringToStatus(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Status>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String statusToString(Status lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static SeoInfo stringToSeoInfo(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<SeoInfo>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String seoInfoToString(SeoInfo lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ArrayList<Attribute> stringToListAttribute(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ArrayList<Attribute>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listAttributeToString(ArrayList<Attribute> lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Brand stringToBrand(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Brand>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String brandToString(Brand lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ArrayList<Category> stringToListCategory(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ArrayList<Category>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listCategoryToString(ArrayList<Category> lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Color stringToColor(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Color>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String colorToString(Color lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Objective stringToObjective(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Objective>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String objectiveToString(Objective lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ArrayList<Image> stringToListImage(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ArrayList<Image>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listImageToString(ArrayList<Image> lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static Price stringToPrice(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Price>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String priceToString(Price lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }

    @TypeConverter
    public static ArrayList<ActiveFlashSale> stringToListActiveFlashSale(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<ArrayList<ActiveFlashSale>>() {
        }.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String listActiveFlashSaleToString(ArrayList<ActiveFlashSale> lst) {
        Gson gson = new Gson();
        return gson.toJson(lst);
    }
}