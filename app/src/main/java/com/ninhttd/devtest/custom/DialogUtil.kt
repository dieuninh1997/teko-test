package com.ninhttd.devtest.custom

import android.content.Context

import androidx.appcompat.app.AlertDialog

class DialogUtil private constructor(private var context: Context?) {
    private var alertDialog: AlertDialog? = null

    fun setContext(context: Context) {
        this.context = context
    }

    fun dismissDialog() {
        if (alertDialog != null) {
            alertDialog!!.dismiss()
        }
    }

    fun showDialogLoading() {
        if (alertDialog != null) {
            if (alertDialog!!.isShowing) {
                alertDialog!!.dismiss()
                return
            }
            alertDialog!!.show()
            return
        }
        alertDialog = this.context?.let { AlertDialogHolder.show(it) }
    }

    companion object {
        private var instance: DialogUtil? = null

        fun getInstance(context: Context): DialogUtil {
            if (instance == null || instance!!.context !== context) {
                if (instance != null) {
                    instance!!.dismissDialog()
                }
                instance = DialogUtil(context)
            }
            return instance as DialogUtil
        }
    }

}
