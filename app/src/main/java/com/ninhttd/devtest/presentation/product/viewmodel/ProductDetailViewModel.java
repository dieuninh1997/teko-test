package com.ninhttd.devtest.presentation.product.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.base.BaseViewModel;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.repository.ProductRepository;
import com.ninhttd.devtest.data.entity.Product;
import com.ninhttd.devtest.data.entity.ProductLevel2;
import com.ninhttd.devtest.presentation.product.view.ProductView;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProductDetailViewModel extends BaseViewModel<ProductView> {

    private static final String TAG = "ProductDetailViewModel";

    @Inject
    ProductRepository productRepository;

    public MutableLiveData<ResponseDTO<Product>> productDetailLD = new MutableLiveData<>();


    @Inject
    public ProductDetailViewModel(@NonNull Application application) {
        super(application);
        ((TekoApplication) application).getAppComponent().inject(this);
    }


    boolean loading = false;

    public void getProductDetail(String sku) {
        if (loading) {
            return;
        }
        disposable.add(productRepository.getProductDetail(sku)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable1 -> {
                    loading = true;
                    if (view != null) {
                        view.showLoading();
                    }
                })
                .doFinally(() -> {
                    loading = false;
                    if (view != null) {
                        view.hideLoading();
                    }
                })
                .subscribeWith(new DisposableSingleObserver<ResponseDTO<ProductLevel2>>() {

                    @Override
                    public void onSuccess(ResponseDTO<ProductLevel2> productResponseDTO) {
                        if (view != null) {
                            view.onLoadDataDetailSuccess(productResponseDTO);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.onLoadDataDetailFailed(e);
                        }
                    }
                })

        );
    }
}
