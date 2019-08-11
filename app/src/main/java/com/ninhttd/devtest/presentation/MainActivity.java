package com.ninhttd.devtest.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseActivity;
import com.ninhttd.devtest.base.BaseView;
import com.ninhttd.devtest.presentation.product.ProductFragment;
import com.ninhttd.devtest.utils.Navigator;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Navigator.startFragment(this, R.id.screenContainer, new ProductFragment(), false);
    }

    @Override
    protected void afterView(Bundle savedInstanceState) {

    }



    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
