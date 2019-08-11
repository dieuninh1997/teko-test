package com.ninhttd.devtest.presentation.product.adapter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ninhttd.devtest.R;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.presentation.product.ProductDetailFragment;
import com.ninhttd.devtest.presentation.view.ProductView;
import com.ninhttd.devtest.utils.Navigator;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private static final String TAG = "ProductAdapter";
    private static final String PRODUCT_SKU = "PRODUCT_SKU";
    List<ProductView> data;
    FragmentActivity fragmentActivity;


    public ProductAdapter(List<ProductView> data, FragmentActivity fragmentActivity) {
        this.data = data;
        this.fragmentActivity = fragmentActivity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (data.size() > 0) {
            ProductView item = data.get(position);
            if (item.getImages().size() > 0) {
                Glide.with(fragmentActivity.getApplicationContext()).load(item.getImages().get(0).getUrl()).into(holder.imgDisplay);
            } else {
                holder.imgDisplay.setImageDrawable(fragmentActivity.getResources().getDrawable(R.mipmap.small));
            }
            holder.txtDisplayName.setText(item.getDisplayName());
            holder.txtSalePrice.setText(item.getPrice().getSupplierSalePrice());
            holder.txtSellPrice.setText(item.getPrice().getSellPrice());

            holder.lnParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToProductDetail(item.getSku());
                }
            });
        }
    }

    private void navigateToProductDetail(String sku) {
        Bundle bundle = new Bundle();
        bundle.putString(PRODUCT_SKU, sku);
        ProductDetailFragment fragment = new ProductDetailFragment();
        fragment.setArguments(bundle);
        Navigator.startFragmentWithAnimation(fragmentActivity, R.id.screenContainer, fragment, null, true, 1);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.lnParent)
        LinearLayout lnParent;
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

    public List<ProductView> getData() {
        return data;
    }

    public void setData(List<ProductView> data) {
        this.data = data;
        notifyDataSetChanged();
    }
}
