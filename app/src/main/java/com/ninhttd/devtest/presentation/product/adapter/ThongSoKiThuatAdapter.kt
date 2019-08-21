package com.ninhttd.devtest.presentation.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

import com.ninhttd.devtest.R
import com.ninhttd.devtest.data.entity.AttributeGroup

import butterknife.BindView
import butterknife.ButterKnife

class ThongSoKiThuatAdapter(var data: List<AttributeGroup>?, var fragmentActivity: FragmentActivity) : RecyclerView.Adapter<ThongSoKiThuatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_attribute_group_item, parent, false)
        return ThongSoKiThuatAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (data!!.isNotEmpty()) {
            if (position % 2 == 0) {
                holder.lnParent!!.background = fragmentActivity.resources.getDrawable(R.drawable.bg_rounded_pale_grey_8dp)
            } else {
                holder.lnParent!!.background = fragmentActivity.resources.getDrawable(R.drawable.bg_white)
            }
            val item = data!![position]
            holder.txtTitle!!.text = item.name
            holder.txtValue!!.text = item.value
        }
    }

    override fun getItemCount(): Int {
        return if (data != null) data!!.size else 0
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.lnParent)
        @JvmField
        var lnParent: LinearLayout? = null
        @BindView(R.id.txt_title)
        @JvmField
        var txtTitle: TextView? = null
        @BindView(R.id.txt_value)
        @JvmField
        var txtValue: TextView? = null

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
