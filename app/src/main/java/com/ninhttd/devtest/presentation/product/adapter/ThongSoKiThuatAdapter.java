package com.ninhttd.devtest.presentation.product.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.presentation.product.model.AttributeGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThongSoKiThuatAdapter extends RecyclerView.Adapter<ThongSoKiThuatAdapter.ViewHolder> {

    List<AttributeGroup> data;
    FragmentActivity fragmentActivity;

    public ThongSoKiThuatAdapter(List<AttributeGroup> data, FragmentActivity fragmentActivity) {
        this.data = data;
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_attribute_group_item, parent, false);
        return new ThongSoKiThuatAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (data.size() > 0) {
            if(position%2==0){
                holder.lnParent.setBackground(fragmentActivity.getResources().getDrawable(R.drawable.bg_rounded_pale_grey_8dp));
            }else{
                holder.lnParent.setBackground(fragmentActivity.getResources().getDrawable(R.drawable.bg_white));
            }
            AttributeGroup item = data.get(position);
            holder.txtTitle.setText(item.getName());
            holder.txtValue.setText(item.getValue());
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lnParent)
        LinearLayout lnParent;
        @BindView(R.id.txt_title)
        TextView txtTitle;
        @BindView(R.id.txt_value)
        TextView txtValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
