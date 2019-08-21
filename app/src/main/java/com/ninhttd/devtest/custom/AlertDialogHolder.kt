package com.ninhttd.devtest.custom

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView

import androidx.appcompat.app.AlertDialog

import com.bumptech.glide.Glide
import com.ninhttd.devtest.R

object AlertDialogHolder {
    private var instance: AlertDialogHolder? = null

    fun getInstance(): AlertDialogHolder {
        if (instance == null) {
            instance = AlertDialogHolder
        }
        return instance as AlertDialogHolder
    }

    fun show(context: Context): AlertDialog {
        val factory = LayoutInflater.from(context)
        val dialogView = factory.inflate(R.layout.dialog_loading, null)
        val imageLoading = dialogView.findViewById<ImageView>(R.id.imageLoading)

        val customDialog = AlertDialog.Builder(context).setCancelable(false).create()
        customDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.setView(dialogView)

        Glide.with(context).load(R.drawable.img_loading).into(imageLoading)
        customDialog.show()
        return customDialog
    }
}
