package com.ninhttd.devtest.utils

import android.content.Context

object CommonUtils {
    fun getStringResource(context: Context, textId: String): Int {
        return context.resources.getIdentifier(textId, "string", context.packageName)
    }
}
