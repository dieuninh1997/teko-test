package com.ninhttd.devtest.presentation.product.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.ninhttd.devtest.R
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.presentation.product.ProductDetailFragment
import com.ninhttd.devtest.utils.Constant
import com.ninhttd.devtest.utils.Navigator

import butterknife.BindView
import butterknife.ButterKnife

class ProductAdapter(internal var data: MutableList<ProductEntity>, var fragmentActivity: FragmentActivity) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (data.size > 0) {
            val item = data[position]
            if (item != null) {
                val salePrice = if (item.price!!.supplierSalePrice != null) item.price!!.supplierSalePrice!!.toString() else ""
                val sellPrice = if (item.price!!.sellPrice != null) item.price!!.sellPrice!!.toString() else ""
                if (item.images!!.size > 0) {
                    Glide.with(fragmentActivity.applicationContext).load(item.images!![0].url).into(holder.imgDisplay!!)
                } else {
                    holder.imgDisplay!!.setImageDrawable(fragmentActivity.resources.getDrawable(R.mipmap.small))
                }
                holder.txtDisplayName!!.text = item.displayName
                holder.txtSalePrice!!.text = salePrice
                holder.txtSellPrice!!.text = sellPrice

                holder.lnParent!!.setOnClickListener { v -> navigateToProductDetail(item.sku) }
            }
        }
    }

    private fun navigateToProductDetail(sku: String) {
        val bundle = Bundle()
        bundle.putString(Constant.ViewParam.PRODUCT_SKU, sku)
        val fragment = ProductDetailFragment()
        fragment.arguments = bundle
        Navigator.startFragmentWithAnimation(fragmentActivity, R.id.screenContainer, fragment, null, true, 1)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun appendData(productEntities: List<ProductEntity>) {
        val beforeSize = data.size
        data.addAll(productEntities)
        notifyItemRangeInserted(beforeSize - 1, productEntities.size)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.lnParent)
        @JvmField
        var lnParent: LinearLayout? = null
        @BindView(R.id.img_display)
        @JvmField
        var imgDisplay: ImageView? = null
        @BindView(R.id.txt_sale_price)
        @JvmField
        var txtSalePrice: TextView? = null
        @BindView(R.id.txt_sell_price)
        @JvmField
        var txtSellPrice: TextView? = null
        @BindView(R.id.txt_display_name)
        @JvmField
        var txtDisplayName: TextView? = null

        init {
            ButterKnife.bind(this, itemView)
        }
    }

    fun getData(): List<ProductEntity> {
        return data
    }

    fun setData(data: List<ProductEntity>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun updateSearch() {

    }

    companion object {
        private val TAG = "ProductAdapter"
    }
}
