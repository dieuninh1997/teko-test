package com.ninhttd.devtest.data.remote.exception;

import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.base.BaseView;
import com.ninhttd.devtest.custom.PopupHolder;
import com.ninhttd.devtest.data.dto.ErrorDTO;
import com.ninhttd.devtest.utils.CommonUtils;
import com.ninhttd.devtest.utils.MessageKey;

import org.apache.commons.lang3.StringUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class HandlerException {
    public static void handlerNetworkException(Context context, Throwable throwable, BaseView baseView) {
        String messageKey = "";
        if (throwable instanceof NetworkException
                || throwable instanceof UnknownHostException
                || throwable instanceof ConnectException) {
            messageKey = MessageKey.NO_INTERNET_EXCEPTION.getValue();
        } else if (throwable instanceof SocketTimeoutException) {
            messageKey = MessageKey.TIME_OUT_EXCEPTION.getValue();
        } else if (throwable instanceof JsonSyntaxException) {
            messageKey = MessageKey.SERVER_NOT_AVAILABLE.getValue();
        }
        else if (throwable instanceof HttpException) {
            try {
                ResponseBody requestBody=  ((HttpException) throwable).response().errorBody();
                ErrorDTO data= TekoApplication.gson.fromJson(requestBody.string(), ErrorDTO.class);
                baseView.onErrorAPI(data);
                return;
            }catch (Exception ex){
                messageKey = ex.getMessage();
            }
        } else {
            messageKey = throwable.getMessage();
        }
        showException(context, messageKey);
    }

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
