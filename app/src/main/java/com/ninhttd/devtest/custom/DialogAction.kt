package com.ninhttd.devtest.custom

import android.content.Context

interface DialogAction {
    var context: Context
    fun execute(context: Context)
}
