package com.ninhttd.devtest.presentation.product;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

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
import com.ninhttd.devtest.presentation.product.model.Image;
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

    //view
    @BindView(R.id.txt_title)
    TextView txtTitleHeader;
    @BindView(R.id.txt_price)
    TextView txtPriceHeader;
    @BindView(R.id.txt_display_name)
    TextView txtDisplayName;
    @BindView(R.id.txt_ma_sp)
    TextView txtMaSp;
    @BindView(R.id.txt_status)
    TextView txtStatus;
    @BindView(R.id.txt_sale_price)
    TextView txtSalePrice;
    @BindView(R.id.txt_sell_price)
    TextView txtSellPrice;
    @BindView(R.id.txt_giam_gia)
    TextView txtGiamGia;


    TabsAdapter tabsAdapter;

    ProductDetailViewModel productDetailViewModel;
    ProductDetailSliderAdapter sliderAdapter;
    List<Image> sliderImages = new ArrayList<>();
    Product productDetail;

    @Override
    protected void afterView() {
        imgBack.setOnClickListener(this);
        tabsAdapter = new TabsAdapter(getContext(), getChildFragmentManager());
        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager, false);
        tabLayout.getTabAt(1).select();


        productDetailViewModel = ViewModelProviders.of(getActivity()).get(ProductDetailViewModel.class);
        productDetailViewModel.setView(this);
        sliderAdapter = new ProductDetailSliderAdapter(sliderImages, getActivity());
        rvSlider.setLayoutManager(new CustomLinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rvSlider.setAdapter(sliderAdapter);

        Bundle arguments = getArguments();
        String sku = arguments.getString(Constant.ViewParam.PRODUCT_SKU);

        productDetailViewModel.getProductDetail(sku);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rvSlider);
        rvSlider.addItemDecoration(new CirclePagerIndicatorDecoration());

        //auto swipe slider
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
            productDetail = productResponseDTO.getResult().getProduct();
            sliderAdapter.setData(productDetail.getImages());
            sliderAdapter.notifyDataSetChanged();

            initView();
        } else {
            Log.e(TAG, "onLoadDataDetailSuccess: productResponseDTO is NULL");
        }
    }

    private void initView() {
        txtTitleHeader.setText(productDetail.getDisplayName());
        String priceHeader = productDetail.getPrice().getSupplierSalePrice() != null ? productDetail.getPrice().getSupplierSalePrice().toString() : "";
        String sellPrice = productDetail.getPrice().getSellPrice() != null ? productDetail.getPrice().getSellPrice().toString() : "";
        boolean isGiamGia = priceHeader.equals(sellPrice);

        if (priceHeader.isEmpty()) {
            txtPriceHeader.setVisibility(View.GONE);
        } else {
            txtPriceHeader.setVisibility(View.VISIBLE);
            txtPriceHeader.setText(priceHeader);

        }
        txtDisplayName.setText(productDetail.getDisplayName());

        txtMaSp.setText(productDetail.getSku());
        if (productDetail.getStatus().getSale().isEmpty()) {
            txtStatus.setVisibility(View.GONE);
        } else {
            txtStatus.setVisibility(View.VISIBLE);
            txtStatus.setText(productDetail.getStatus().getSale());
        }
        txtSalePrice.setText(priceHeader);
        txtSellPrice.setText(sellPrice);

        if (!isGiamGia) {
            if (priceHeader != null && sellPrice != null && Double.parseDouble(sellPrice) != 0) {
                double giamGia = (1 - Double.parseDouble(sellPrice) / Double.parseDouble(priceHeader)) * 100;
                txtGiamGia.setVisibility(View.VISIBLE);
                txtGiamGia.setText("-" + (int) giamGia + "%");
            }
        } else {
            txtGiamGia.setVisibility(View.GONE);
            txtSalePrice.setVisibility(View.GONE);
        }


    }

    @Override
    public void onLoadDataDetailFailed(Throwable e) {

    }
}
