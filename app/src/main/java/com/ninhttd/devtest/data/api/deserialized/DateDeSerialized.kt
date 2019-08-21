package com.ninhttd.devtest.data.api.deserialized

import java.lang.reflect.Type
import java.util.*
import com.google.gson.*
import com.google.gson.JsonPrimitive


class DateDeSerialized : JsonDeserializer<Date> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Date? {
        return if (json == null) null else Date(json.asLong)

    }
}