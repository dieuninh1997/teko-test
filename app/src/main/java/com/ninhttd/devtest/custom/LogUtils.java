package com.ninhttd.devtest.custom;

import android.util.Log;

import com.ninhttd.devtest.BuildConfig;

import org.apache.commons.lang3.StringUtils;

public class LogUtils {
    public static final String PREFIX_TAG = "PRISM_";
    public static boolean isDebugLogEnable = BuildConfig.DEBUG;

    public static void debugLog(final Object target, final String content) {
        if (isDebugLogEnable) {
            Log.d(PREFIX_TAG + target.getClass().getSimpleName(),
                    StringUtils.isEmpty(content) ? "[Log is empty]" : content);
        }
    }

    public static void errorLog(final Object target, final String content) {
        Log.i(PREFIX_TAG + target.getClass().getSimpleName(), StringUtils.isEmpty(content) ? "[Log is empty]" : content);
    }
}
