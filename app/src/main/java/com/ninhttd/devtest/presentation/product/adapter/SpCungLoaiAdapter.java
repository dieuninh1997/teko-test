package com.ninhttd.devtest.presentation.product.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;

public class SpCungLoaiAdapter extends RecyclerView.Adapter<SpCungLoaiAdapter.ViewHolder> {
    @NonNull
    @Override
    public SpCungLoaiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_sp_cung_loai, parent, false);
        return new SpCungLoaiAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpCungLoaiAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
