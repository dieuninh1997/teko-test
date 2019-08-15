package com.ninhttd.devtest.data.remote.exception;

import android.content.Context;

import com.ninhttd.devtest.custom.PopupHolder;
import com.ninhttd.devtest.utils.CommonUtils;

import org.apache.commons.lang3.StringUtils;

public class HandlerException {
    public static void showException(Context context, String messageKey) {
        String message;
        try {
            message = context.getString(CommonUtils.getStringResource(context, messageKey));
        } catch (Exception e) {
            message = messageKey;
        }
        PopupHolder.getInstance().showOk(context, "",
                StringUtils.isNotEmpty(message) ? message : messageKey, null
        );
    }
}
