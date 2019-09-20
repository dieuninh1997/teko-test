package com.ninhttd.devtest.custom

import android.util.Log

import com.ninhttd.devtest.BuildConfig

import org.apache.commons.lang3.StringUtils

object LogUtils {
    val PREFIX_TAG = "PRISM_"
    var isDebugLogEnable = BuildConfig.DEBUG

    fun debugLog(target: Any, content: String) {
        if (isDebugLogEnable) {
            Log.d(PREFIX_TAG + target.javaClass.simpleName,
                    if (StringUtils.isEmpty(content)) "[Log is empty]" else content)
        }
    }

    fun errorLog(target: Any, content: String) {
        Log.i(PREFIX_TAG + target.javaClass.simpleName, if (StringUtils.isEmpty(content)) "[Log is empty]" else content)
    }
}
