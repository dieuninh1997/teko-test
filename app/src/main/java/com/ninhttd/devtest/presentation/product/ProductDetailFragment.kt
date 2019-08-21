package com.ninhttd.devtest.presentation.product

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.TextView

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

import com.google.android.material.tabs.TabLayout
import com.ninhttd.devtest.R
import com.ninhttd.devtest.base.BaseFragment
import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.data.remote.exception.HandlerException
import com.ninhttd.devtest.presentation.product.adapter.ProductDetailSliderAdapter
import com.ninhttd.devtest.presentation.product.adapter.SpCungLoaiAdapter
import com.ninhttd.devtest.presentation.product.adapter.TabsAdapter
import com.ninhttd.devtest.data.entity.AttributeGroup
import com.ninhttd.devtest.data.entity.Image
import com.ninhttd.devtest.data.entity.ProductLevel2
import com.ninhttd.devtest.presentation.product.view.ProductView
import com.ninhttd.devtest.presentation.product.viewmodel.ProductDetailViewModel
import com.ninhttd.devtest.utils.Constant

import java.util.ArrayList

import butterknife.BindView

class ProductDetailFragment : BaseFragment(), View.OnClickListener, ProductView {
    @BindView(R.id.img_back)
    @JvmField
    var imgBack: ImageButton? = null

    @BindView(R.id.rv_slider)
    @JvmField
    var rvSlider: RecyclerView? = null

    @BindView(R.id.rv_slider_separator)
    @JvmField
    var rvSliderSeparator: View? = null

    @BindView(R.id.rv_sp_cung_loai)
    @JvmField
    var rvSpcl: RecyclerView? = null

    @BindView(R.id.tab_layout)
    @JvmField
    var tabLayout: TabLayout? = null

    @BindView(R.id.view_pager)
    @JvmField
    var viewPager: ViewPager? = null

    //view
    @BindView(R.id.txt_title)
    @JvmField
    var txtTitleHeader: TextView? = null

    @BindView(R.id.txt_price)
    @JvmField
    var txtPriceHeader: TextView? = null

    @BindView(R.id.txt_display_name)
    @JvmField
    var txtDisplayName: TextView? = null

    @BindView(R.id.txt_ma_sp)
    @JvmField
    var txtMaSp: TextView? = null

    @BindView(R.id.txt_status)
    @JvmField
    var txtStatus: TextView? = null

    @BindView(R.id.txt_sale_price)
    @JvmField
    var txtSalePrice: TextView? = null

    @BindView(R.id.txt_sell_price)
    @JvmField
    var txtSellPrice: TextView? = null

    @BindView(R.id.txt_giam_gia)
    @JvmField
    var txtGiamGia: TextView? = null


    lateinit var tabsAdapter: TabsAdapter
    lateinit var spCungLoaiAdapter: SpCungLoaiAdapter

    lateinit var productDetailViewModel: ProductDetailViewModel
    lateinit var sliderAdapter: ProductDetailSliderAdapter
    val sliderImages: List<Image> = ArrayList()
    lateinit var productEntityDetail: ProductEntity
    var attributeGroups: List<AttributeGroup>? = null

    protected override val layout: Int
        get() = R.layout.fragment_item_product_detail

    override fun afterView() {
        imgBack!!.setOnClickListener(this)

        productDetailViewModel = ViewModelProviders.of(activity!!).get(ProductDetailViewModel::class.java)
        productDetailViewModel.view = this
        val arguments = arguments
        val sku = arguments!!.getString(Constant.ViewParam.PRODUCT_SKU)
        productDetailViewModel.getProductDetail(sku)

        sliderAdapter = ProductDetailSliderAdapter(sliderImages, activity!!)
        rvSlider!!.layoutManager = CustomLinearLayoutManager(activity!!, RecyclerView.HORIZONTAL, false)
        rvSlider!!.adapter = sliderAdapter

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rvSlider)
        rvSlider!!.addItemDecoration(CirclePagerIndicatorDecoration())

        spCungLoaiAdapter = SpCungLoaiAdapter()
        rvSpcl!!.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        rvSpcl!!.adapter = spCungLoaiAdapter


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

    private fun initTabs() {
        tabsAdapter = TabsAdapter(context!!, childFragmentManager, attributeGroups!!)
        viewPager!!.adapter = tabsAdapter
        tabLayout!!.setupWithViewPager(viewPager, false)
        tabLayout!!.getTabAt(1)!!.select()
    }

    override fun destroyView() {}

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_back -> activity!!.supportFragmentManager.popBackStack()
            else -> {
            }
        }
    }

    override fun onLoadDataDetailSuccess(productResponseDTO: ResponseDTO<ProductLevel2>) {
        productEntityDetail = productResponseDTO.result!!.productEntity
        if (productEntityDetail.images!!.size > 0) {
            sliderAdapter.setData(productEntityDetail.images!!)
            rvSliderSeparator!!.visibility = View.VISIBLE
            rvSlider!!.visibility = View.VISIBLE
        } else {
            rvSliderSeparator!!.visibility = View.GONE
            rvSlider!!.visibility = View.GONE
        }

        attributeGroups = productEntityDetail.attributeGroups

        initTabs()
        initView()
    }

    private fun initView() {
        txtTitleHeader!!.text = productEntityDetail.displayName
        val priceHeader = if (productEntityDetail.price!!.supplierSalePrice != null) productEntityDetail.price!!.supplierSalePrice!!.toString() else ""
        val sellPrice = if (productEntityDetail.price!!.sellPrice != null) productEntityDetail.price!!.sellPrice!!.toString() else ""
        val isGiamGia = priceHeader == sellPrice

        if (priceHeader.isEmpty()) {
            txtPriceHeader!!.visibility = View.GONE
        } else {
            txtPriceHeader!!.visibility = View.VISIBLE
            txtPriceHeader!!.text = priceHeader

        }
        txtDisplayName!!.text = productEntityDetail.displayName

        txtMaSp!!.text = productEntityDetail.sku
        if (productEntityDetail.status!!.sale!!.isEmpty()) {
            txtStatus!!.visibility = View.GONE
        } else {
            txtStatus!!.visibility = View.VISIBLE
            txtStatus!!.text = productEntityDetail.status!!.sale
        }
        txtSalePrice!!.text = priceHeader
        txtSellPrice!!.text = sellPrice

        if (!isGiamGia) {
            if (priceHeader != null && sellPrice != null && java.lang.Double.parseDouble(sellPrice) != 0.0) {
                val giamGia = (1 - java.lang.Double.parseDouble(sellPrice) / java.lang.Double.parseDouble(priceHeader)) * 100
                txtGiamGia!!.visibility = View.VISIBLE
                txtGiamGia!!.text = "-" + giamGia.toInt() + "%"
            }
        } else {
            txtGiamGia!!.visibility = View.GONE
            txtSalePrice!!.visibility = View.GONE
        }


    }

    companion object {
        private val TAG = "ProductDetailFragment"
    }

}
