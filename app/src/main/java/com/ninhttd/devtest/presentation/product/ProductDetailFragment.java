package com.ninhttd.devtest.presentation.product;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.presentation.product.adapter.ProductDetailSliderAdapter;
import com.ninhttd.devtest.presentation.product.adapter.TabsAdapter;

import butterknife.BindView;
import butterknife.internal.Utils;

public class ProductDetailFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "ProductDetailFragment";
    @BindView(R.id.img_back)
    ImageButton imgBack;

    @BindView(R.id.rv_slider)
    RecyclerView rvSlider;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    ProductDetailSliderAdapter sliderAdapter;
    TabsAdapter tabsAdapter;

    @Override
    protected void afterView() {
        imgBack.setOnClickListener(this);

        tabsAdapter = new TabsAdapter(getContext(), getFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
        tabLayout.getTabAt(1).select();

//        rvSlider.setLayoutManager(new CustomLinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
//        PagerSnapHelper snapHelper=new PagerSnapHelper();
//        snapHelper.attachToRecyclerView(rvSlider);
//        rvSlider.addItemDecoration(new CirclePagerIndicatorDecoration());
//        final int speedScroll = 3000;
//        final Handler handler = new Handler();
//        final Runnable runnable = new Runnable() {
//            int count = 0;
//            boolean flag = true;
//
//            @Override
//            public void run() {
//                if (sliderAdapter.getItemCount() > 1 && count < sliderAdapter.getItemCount()) {
//                    if (count == sliderAdapter.getItemCount() - 1) {
//                        flag = false;
//                    } else if (count == 0) {
//                        flag = true;
//                    }
//                    if (flag) count++;
//                    else count--;//
//                    // Call smooth scroll
//                    if (rvSlider != null)
//                        rvSlider.smoothScrollToPosition(count);
//                    handler.postDelayed(this, speedScroll);
//
//                }
//            }
//        };
//        handler.postDelayed(runnable, speedScroll);

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
