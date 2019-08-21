package com.ninhttd.devtest.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.TextView

import androidx.appcompat.app.AlertDialog

import com.andexert.library.RippleView
import com.ninhttd.devtest.R

class PopupHolder private constructor() {
    protected var itemAction: DialogActionImpl? = null
    fun showOk(context: Context, title: String, message: String?, dialogAction: DialogActionImpl?): AlertDialog {

        val layoutInflater = LayoutInflater.from(context)
        val dialogView = layoutInflater.inflate(R.layout.popups_ok, null)

        val tvMessage = dialogView.findViewById<TextView>(R.id.tvMessage)
        val btOk = dialogView.findViewById<RippleView>(R.id.btOk)

        val customDialog = AlertDialog.Builder(context).setView(dialogView).create()
        customDialog.setCanceledOnTouchOutside(false)
        customDialog.window!!.setBackgroundDrawable(ColorDrawable(R.drawable.bg_popups))
        customDialog.setOnShowListener { dialog ->
            val alertDialog = dialog as AlertDialog
            val view = alertDialog.window!!.decorView.findViewById<View>(R.id.popupOk)
            val layoutParams = view.layoutParams as FrameLayout.LayoutParams
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT
            layoutParams.gravity = Gravity.CENTER
            view.layoutParams = layoutParams
            alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }


        if (message != null)
            tvMessage.text = message

        this.itemAction = dialogAction

        btOk.setOnClickListener {
            if (itemAction != null) {
                itemAction!!.execute(context)
            }
            customDialog.dismiss()
        }

        customDialog.show()
        return customDialog
    }

    companion object {
        private var instance: PopupHolder? = null

        fun getInstance(): PopupHolder {
            if (instance == null) {
                instance = PopupHolder()
            }
            return instance as PopupHolder
        }
    }
}
