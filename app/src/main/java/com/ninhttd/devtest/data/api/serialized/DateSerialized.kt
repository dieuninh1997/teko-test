package com.ninhttd.devtest.data.api.serialized

import java.lang.reflect.Type
import java.util.*
import com.google.gson.*
import com.google.gson.JsonPrimitive


class DateSerialized : JsonSerializer<Date> {
    override fun serialize(src: Date?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        return if (src == null) null else JsonPrimitive(src.time)
    }
}