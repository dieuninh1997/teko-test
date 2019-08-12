package com.ninhttd.devtest.presentation.product;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.presentation.product.adapter.ProductDetailSliderAdapter;
import com.ninhttd.devtest.presentation.product.adapter.TabsAdapter;
import com.ninhttd.devtest.presentation.product.model.Product;
import com.ninhttd.devtest.presentation.product.model.ProductLevel2;
import com.ninhttd.devtest.presentation.product.view.ProductView;
import com.ninhttd.devtest.presentation.product.viewmodel.ProductDetailViewModel;
import com.ninhttd.devtest.utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProductDetailFragment extends BaseFragment implements View.OnClickListener, ProductView {
    private static final String TAG = "ProductDetailFragment";
    @BindView(R.id.img_back)
    ImageButton imgBack;

    @BindView(R.id.rv_slider)
    RecyclerView rvSlider;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    TabsAdapter tabsAdapter;

    ProductDetailViewModel productDetailViewModel;
    ProductDetailSliderAdapter sliderAdapter;
    List<Product.Image> sliderImages = new ArrayList<>();

    @Override
    protected void afterView() {
        imgBack.setOnClickListener(this);

        tabsAdapter = new TabsAdapter(getContext(), getFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager, true);
        tabLayout.getTabAt(1).select();


        productDetailViewModel = ViewModelProviders.of(getActivity()).get(ProductDetailViewModel.class);
        productDetailViewModel.setView(this);
        sliderAdapter=new ProductDetailSliderAdapter(sliderImages, getActivity());
        rvSlider.setLayoutManager(new CustomLinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rvSlider.setAdapter(sliderAdapter);

        Bundle arguments = getArguments();
        String sku = arguments.getString(Constant.ViewParam.PRODUCT_SKU);

        productDetailViewModel.getProductDetail(sku);

        PagerSnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rvSlider);
        rvSlider.addItemDecoration(new CirclePagerIndicatorDecoration());
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

    @Override
    public void onLoadDataDetailSuccess(ResponseDTO<ProductLevel2> productResponseDTO) {
        if (productResponseDTO != null) {
            Product item = productResponseDTO.getResult().getProduct();
            sliderAdapter.setData(item.getImages());
            sliderAdapter.notifyDataSetChanged();
        }else{
            Log.e(TAG, "onLoadDataDetailSuccess: productResponseDTO is NULL");
        }
    }

    @Override
    public void onLoadDataDetailFailed(Throwable e) {

    }
}
