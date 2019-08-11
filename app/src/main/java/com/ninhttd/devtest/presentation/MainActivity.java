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
        setStatusBarGradiant(this);
        Navigator.startFragment(this, R.id.screenContainer, new ProductFragment(), false);
    }

    /**
     * Making notification bar transparent
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            Drawable background = activity.getResources().getDrawable(R.drawable.bg_gradient_tomato);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setNavigationBarColor(activity.getResources().getColor(android.R.color.transparent));
            window.setBackgroundDrawable(background);
        }
    }

    @Override
    protected void afterView(Bundle savedInstanceState) {

    }



    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }
}
