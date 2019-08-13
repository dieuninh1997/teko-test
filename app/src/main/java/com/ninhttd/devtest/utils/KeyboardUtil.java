package com.ninhttd.devtest.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.fragment.app.FragmentActivity;

import com.ninhttd.devtest.custom.LogUtils;

public class KeyboardUtil {
    public static void showKeyboard(FragmentActivity activity){
        LogUtils.debugLog("KeyboardUtil", "show keyboard----");
        @SuppressLint("ServiceCast") InputMethodManager inputMethodManager= (InputMethodManager) activity.getSystemService(Context.INPUT_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
    }
    public static void hideKeyboard(FragmentActivity activity){
        LogUtils.debugLog("KeyboardUtil", "hide keyboard----");
        @SuppressLint("ServiceCast") InputMethodManager inputMethodManager= (InputMethodManager) activity.getSystemService(Context.INPUT_SERVICE);
        View currentFocus=activity.getCurrentFocus();
        if(currentFocus!=null){

            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(),0);
        }
    }


}
