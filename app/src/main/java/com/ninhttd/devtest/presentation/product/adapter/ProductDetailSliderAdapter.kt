package com.ninhttd.devtest.presentation.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.ninhttd.devtest.R
import com.ninhttd.devtest.data.entity.Image

import butterknife.BindView
import butterknife.ButterKnife

class ProductDetailSliderAdapter(private var data: List<Image>?, var fragmentActivity: FragmentActivity) : RecyclerView.Adapter<ProductDetailSliderAdapter.ViewHolder>() {

    fun getData(): List<Image>? {
        return data
    }

    fun setData(data: List<Image>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailSliderAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_slider_item, parent, false)
        return ProductDetailSliderAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductDetailSliderAdapter.ViewHolder, position: Int) {
        if (data!!.isNotEmpty()) {
            val item = data!![position]
            if (item.url != null) {
                Glide.with(fragmentActivity.applicationContext).load(item.url).placeholder(R.drawable.img_place_holder).into(holder.imgSlider!!)
            }
        }
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.img_slider)
        @JvmField
        var imgSlider: ImageView? = null


        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
