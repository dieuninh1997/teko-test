package com.ninhttd.devtest.utils;

import android.content.Context;

public class CommonUtils {
    public static int getStringResource(Context context, String textId) {
        return context.getResources().getIdentifier(textId, "string", context.getPackageName());
    }
}
