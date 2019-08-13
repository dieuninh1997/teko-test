package com.ninhttd.devtest.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ninhttd.devtest.custom.DialogUtil;
import com.ninhttd.devtest.custom.LogUtils;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        LogUtils.errorLog(this, "current screen: " + this.getClass().getSimpleName());
        afterView(savedInstanceState);
    }

    protected abstract void afterView(Bundle savedInstanceState);

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DialogUtil.getInstance(this).dismissDialog();
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
