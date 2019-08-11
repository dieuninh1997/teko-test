package com.ninhttd.devtest.presentation.product;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;

import butterknife.BindView;

public class ProductDetailFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "ProductDetailFragment";
    @BindView(R.id.img_back)
    ImageButton imgBack;

    @Override
    protected void afterView() {

        imgBack.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_item_product_detail;
    }

    @Override
    protected void destroyView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            default:
                break;
        }
    }
}
