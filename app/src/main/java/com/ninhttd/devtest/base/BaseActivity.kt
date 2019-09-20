package com.ninhttd.devtest.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.ninhttd.devtest.custom.DialogUtil
import com.ninhttd.devtest.custom.LogUtils

import butterknife.ButterKnife

abstract class BaseActivity : AppCompatActivity() {

    protected abstract val layout: Int
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(layout)
        ButterKnife.bind(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        LogUtils.errorLog(this, "current screen: " + this.javaClass.simpleName)
        afterView(savedInstanceState)
    }

    protected abstract fun afterView(savedInstanceState: Bundle?)

    override fun onDestroy() {
        super.onDestroy()
        DialogUtil.getInstance(this).dismissDialog()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}
