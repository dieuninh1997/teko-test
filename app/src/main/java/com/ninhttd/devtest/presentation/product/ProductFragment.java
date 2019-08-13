package com.ninhttd.devtest.presentation.product;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.entity.Product;
import com.ninhttd.devtest.data.entity.ProductLevel1;
import com.ninhttd.devtest.presentation.product.adapter.ProductAdapter;
import com.ninhttd.devtest.presentation.product.view.ProductListView;
import com.ninhttd.devtest.presentation.product.viewmodel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public class ProductFragment extends BaseFragment implements View.OnClickListener, ProductListView {
    private static final String TAG = "ProductFragment";
    @BindView(R.id.rv_product)
    RecyclerView rvProduct;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @BindView(R.id.img_back)
    ImageButton imgBack;

    @BindView(R.id.searchView)
    SearchView searchView;
    @BindView(R.id.txt_no_results)
    TextView txtNoResults;

    private List<Product> data = new ArrayList<>();

    ProductViewModel productViewModel;
    ProductAdapter adapter;

    @Override
    protected void afterView() {
        setStatusBarGradiant(getActivity());

        showDialogLoading();
        productViewModel = ViewModelProviders.of(this.getActivity()).get(ProductViewModel.class);
        productViewModel.setView(this);
        adapter = new ProductAdapter(data, getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rvProduct.setLayoutManager(linearLayoutManager);
        rvProduct.setAdapter(adapter);

        initScrollListener();
        productViewModel.getProductList();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                productViewModel.search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                productViewModel.search(newText);
                return false;
            }
        });

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
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1) {
                    loadMore();
                }
            }
        });
    }

    private void loadMore() {
        productViewModel.loadMoreData();
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((TekoApplication) context.getApplicationContext()).getAppComponent().inject(this);
    }

    @Override
    public void onLoadDataSucces(ResponseDTO<ProductLevel1> responseDTO) {
        if (responseDTO != null) {
            List<Product> items = responseDTO.getResult().getProducts();
            Log.e(TAG, "List<Product> " + items);
            adapter.setData(items);
        } else {
            Log.e(TAG, "responseListDTO is NULL");
        }

    }

    @Override
    public void onLoadDataFailed(Throwable e) {

    }

    @Override
    public void appendData(ResponseDTO<ProductLevel1> viewDTOResponseListDTO) {
        adapter.appendData(viewDTOResponseListDTO.getResult().getProducts());
    }

    @Override
    public void showLoadingMore() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingMore() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSearch(List<Product> products) {
        adapter.setData(products);
        adapter.notifyDataSetChanged();
        if(products.size()>0){
            txtNoResults.setVisibility(View.GONE);
            rvProduct.setVisibility(View.VISIBLE);
        }else{
            txtNoResults.setVisibility(View.VISIBLE);
            rvProduct.setVisibility(View.GONE);
        }
    }
}
