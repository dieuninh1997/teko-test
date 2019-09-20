package com.ninhttd.devtest.data.remote.exception

import android.content.Context

import com.ninhttd.devtest.custom.PopupHolder
import com.ninhttd.devtest.utils.CommonUtils

import org.apache.commons.lang3.StringUtils

object HandlerException {
    fun showException(context: Context, messageKey: String) {
        var message: String
        try {
            message = context.getString(CommonUtils.getStringResource(context, messageKey))
        } catch (e: Exception) {
            message = messageKey
        }

        PopupHolder.getInstance().showOk(context, "vd",
                if (StringUtils.isNotEmpty(message)) message else messageKey, null
        )
    }
}
