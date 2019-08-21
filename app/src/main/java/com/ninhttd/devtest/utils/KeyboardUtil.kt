package com.ninhttd.devtest.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

import androidx.fragment.app.FragmentActivity

import com.ninhttd.devtest.custom.LogUtils

object KeyboardUtil {
    fun showKeyboard(activity: FragmentActivity) {
        LogUtils.debugLog("KeyboardUtil", "show keyboard----")
        @SuppressLint("ServiceCast") val inputMethodManager = activity.getSystemService(Context.INPUT_SERVICE) as InputMethodManager
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
    }

    fun hideKeyboard(activity: FragmentActivity) {
        LogUtils.debugLog("KeyboardUtil", "hide keyboard----")
        @SuppressLint("ServiceCast") val inputMethodManager = activity.getSystemService(Context.INPUT_SERVICE) as InputMethodManager
        val currentFocus = activity.currentFocus
        if (currentFocus != null) {

            inputMethodManager.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        }
    }


}
