package com.ninhttd.devtest.presentation.product;

import android.os.Bundle;
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
import com.ninhttd.devtest.data.entity.ProductEntity;
import com.ninhttd.devtest.data.remote.exception.HandlerException;
import com.ninhttd.devtest.presentation.product.adapter.ProductDetailSliderAdapter;
import com.ninhttd.devtest.presentation.product.adapter.SpCungLoaiAdapter;
import com.ninhttd.devtest.presentation.product.adapter.TabsAdapter;
import com.ninhttd.devtest.data.entity.AttributeGroup;
import com.ninhttd.devtest.data.entity.Image;
import com.ninhttd.devtest.data.entity.ProductLevel2;
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
    @BindView(R.id.rv_slider_separator)
    View rvSliderSeparator;

    @BindView(R.id.rv_sp_cung_loai)
    RecyclerView rvSpcl;

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
    SpCungLoaiAdapter spCungLoaiAdapter;

    ProductDetailViewModel productDetailViewModel;
    ProductDetailSliderAdapter sliderAdapter;
    List<Image> sliderImages = new ArrayList<>();
    ProductEntity productEntityDetail;
    List<AttributeGroup> attributeGroups;

    @Override
    protected void afterView() {
        imgBack.setOnClickListener(this);

        productDetailViewModel = ViewModelProviders.of(getActivity()).get(ProductDetailViewModel.class);
        productDetailViewModel.setView(this);
        Bundle arguments = getArguments();
        String sku = arguments.getString(Constant.ViewParam.PRODUCT_SKU);
        productDetailViewModel.getProductDetail(sku);

        sliderAdapter = new ProductDetailSliderAdapter(sliderImages, getActivity());
        rvSlider.setLayoutManager(new CustomLinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rvSlider.setAdapter(sliderAdapter);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rvSlider);
        rvSlider.addItemDecoration(new CirclePagerIndicatorDecoration());

        spCungLoaiAdapter = new SpCungLoaiAdapter();
        rvSpcl.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rvSpcl.setAdapter(spCungLoaiAdapter);


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

    private void initTabs() {
        tabsAdapter = new TabsAdapter(getContext(), getChildFragmentManager(), attributeGroups);
        viewPager.setAdapter(tabsAdapter);
        tabLayout.setupWithViewPager(viewPager, false);
        tabLayout.getTabAt(1).select();
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
            productEntityDetail = productResponseDTO.getResult().getProductEntity();
            if (productEntityDetail.getImages().size() > 0) {
                sliderAdapter.setData(productEntityDetail.getImages());
                rvSliderSeparator.setVisibility(View.VISIBLE);
                rvSlider.setVisibility(View.VISIBLE);
            }else{
                rvSliderSeparator.setVisibility(View.GONE);
                rvSlider.setVisibility(View.GONE);
            }

            attributeGroups = productEntityDetail.getAttributeGroups();

            initTabs();
            initView();
        } else {
            Log.e(TAG, "onLoadDataDetailSuccess: productResponseDTO is NULL");
        }
    }

    private void initView() {
        txtTitleHeader.setText(productEntityDetail.getDisplayName());
        String priceHeader = productEntityDetail.getPrice().getSupplierSalePrice() != null ? productEntityDetail.getPrice().getSupplierSalePrice().toString() : "";
        String sellPrice = productEntityDetail.getPrice().getSellPrice() != null ? productEntityDetail.getPrice().getSellPrice().toString() : "";
        boolean isGiamGia = priceHeader.equals(sellPrice);

        if (priceHeader.isEmpty()) {
            txtPriceHeader.setVisibility(View.GONE);
        } else {
            txtPriceHeader.setVisibility(View.VISIBLE);
            txtPriceHeader.setText(priceHeader);

        }
        txtDisplayName.setText(productEntityDetail.getDisplayName());

        txtMaSp.setText(productEntityDetail.getSku());
        if (productEntityDetail.getStatus().getSale().isEmpty()) {
            txtStatus.setVisibility(View.GONE);
        } else {
            txtStatus.setVisibility(View.VISIBLE);
            txtStatus.setText(productEntityDetail.getStatus().getSale());
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
        HandlerException.showException(getContext(), e.getMessage());
    }
}
