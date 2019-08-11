package com.ninhttd.devtest.presentation.product;

import android.util.Log;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.presentation.product.adapter.ProductAdapter;
import com.ninhttd.devtest.presentation.product.viewmodel.ProductViewModel;
import com.ninhttd.devtest.presentation.view.ProductView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProductFragment extends BaseFragment {
    private static final String TAG="ProductFragment";
    @BindView(R.id.rv_product)
    RecyclerView rvProduct;

    private List<ProductView> data = new ArrayList<>();
    ProductViewModel productViewModel;
    ProductAdapter adapter;

    @Override
    protected void afterView() {
        productViewModel = ViewModelProviders.of(this.getActivity()).get(ProductViewModel.class);
        adapter=new ProductAdapter(data, getActivity());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),   LinearLayoutManager.VERTICAL, false);
        rvProduct.setLayoutManager(linearLayoutManager);
        rvProduct.setAdapter(adapter);

        productViewModel.productLD.observe(this, responseListDTO->{

            if (responseListDTO != null) {
                Log.e(TAG,"responseListDTO:"+responseListDTO.getResults());
//                List<ProductView> items=responseListDTO.getResults();
            }else {
                Log.e(TAG,"responseListDTO is NULL");
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_product_listing;
    }

    @Override
    protected void destroyView() {

    }
}
