package com.ninhttd.devtest.data.api.typeadapter

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.util.*

class DateTypeAdapter: TypeAdapter<Date>() {
    override fun write(out: JsonWriter?, value: Date?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun read(`in`: JsonReader?): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}