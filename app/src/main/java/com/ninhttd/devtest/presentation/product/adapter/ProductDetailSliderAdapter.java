package com.ninhttd.devtest.presentation.product.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ninhttd.devtest.R;
import com.ninhttd.devtest.presentation.product.model.Image;
import com.ninhttd.devtest.presentation.product.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailSliderAdapter extends RecyclerView.Adapter<ProductDetailSliderAdapter.ViewHolder> {

    List<Image> data;
    FragmentActivity fragmentActivity;

    public List<Image> getData() {
        return data;
    }

    public void setData(List<Image> data) {
        this.data = data;
    }

    public ProductDetailSliderAdapter(List<Image> data, FragmentActivity fragmentActivity) {
        this.data = data;
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public ProductDetailSliderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_slider_item, parent, false);
        return new ProductDetailSliderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductDetailSliderAdapter.ViewHolder holder, int position) {
        if (data.size() > 0) {
            Image item = data.get(position);
            if (item.getUrl() != null) {
                Glide.with(fragmentActivity.getApplicationContext()).load(item.getUrl()).into(holder.imgSlider);
            }
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_slider)
        ImageView imgSlider;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
