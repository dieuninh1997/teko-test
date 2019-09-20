package com.ninhttd.devtest.presentation.product.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.ninhttd.devtest.R

class SpCungLoaiAdapter : RecyclerView.Adapter<SpCungLoaiAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpCungLoaiAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_sp_cung_loai, parent, false)
        return SpCungLoaiAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: SpCungLoaiAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 5
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
