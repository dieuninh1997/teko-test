package com.ninhttd.devtest.presentation.product.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.presentation.view.ProductView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    List<ProductView> data;
    FragmentActivity fragmentActivity;


    public ProductAdapter(List<ProductView> data, FragmentActivity fragmentActivity) {
        this.data = data;
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductView item=data.get(position);
//        holder.imgDisplay.setImageDrawable(item.);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_display)
        ImageView imgDisplay;
        @BindView(R.id.txt_sale_price)
        TextView txtSalePrice;
        @BindView(R.id.txt_sell_price)
        TextView txtSellPrice;
        @BindView(R.id.txt_display_name)
        TextView txtDisplayName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
