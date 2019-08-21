package com.ninhttd.devtest.presentation

import android.os.Bundle

import com.ninhttd.devtest.R
import com.ninhttd.devtest.base.BaseActivity
import com.ninhttd.devtest.presentation.product.ProductFragment
import com.ninhttd.devtest.utils.Navigator

class MainActivity : BaseActivity() {


    protected override val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //        setContentView(R.layout.activity_main);
        Navigator.startFragment(this, R.id.screenContainer, ProductFragment(), false)
    }

    override fun afterView(savedInstanceState: Bundle?) {

    }
}
