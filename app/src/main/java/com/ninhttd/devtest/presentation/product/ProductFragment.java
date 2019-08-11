package com.ninhttd.devtest.presentation.product;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.data.remote.exception.HandlerException;
import com.ninhttd.devtest.presentation.product.adapter.ProductAdapter;
import com.ninhttd.devtest.presentation.product.viewmodel.ProductViewModel;
import com.ninhttd.devtest.presentation.view.ProductView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProductFragment extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "ProductFragment";
    @BindView(R.id.rv_product)
    RecyclerView rvProduct;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.img_back)
    ImageButton imgBack;

    private List<ProductView> data = new ArrayList<>();
    ProductViewModel productViewModel;
    ProductAdapter adapter;
    boolean isLoading = false;

    @Override
    protected void afterView() {
        setStatusBarGradiant(getActivity());

        showDialogLoading();
        productViewModel = ViewModelProviders.of(this.getActivity()).get(ProductViewModel.class);
        adapter = new ProductAdapter(data, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvProduct.setLayoutManager(linearLayoutManager);
        rvProduct.setAdapter(adapter);

//        initScrollListener();

        productViewModel.productLD.observe(this, responseDTO -> {

            if (responseDTO != null) {
                List<ProductView> items = responseDTO.getResult().getProducts();
                Log.e(TAG, "List<ProductView> " + items);
                adapter.setData(items);
            } else {
                Log.e(TAG, "responseListDTO is NULL");
            }

            hideDialogLoading();
        });

        productViewModel.errorLD.observe(this, throwable -> {
            hideDialogLoading();
            if (throwable != null) {
                HandlerException.handlerNetworkException(getContext(), throwable, this);
            }
        });


//        imgBack.setOnClickListener(this);
    }

    /**
     * Making notification bar transparent
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarGradiant(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window w = activity.getWindow();
            w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    private void initScrollListener() {
        rvProduct.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == data.size() - 1) {
                        isLoading = true;
                        loadMore();
                        progressBar.setVisibility(View.VISIBLE);
                    }
                }

            }
        });
    }

    private void loadMore() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            adapter.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);
            Log.e("number", "----item---" + data.size());
            isLoading = false;
        }, 2000);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_product_listing;
    }

    @Override
    protected void destroyView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                getActivity().getSupportFragmentManager().popBackStack();
                break;
            default:
                break;
        }
    }
}
