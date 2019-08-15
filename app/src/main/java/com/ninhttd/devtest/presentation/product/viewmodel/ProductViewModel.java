package com.ninhttd.devtest.presentation.product.viewmodel;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.base.BaseViewModel;
import com.ninhttd.devtest.data.dto.CodeDTO;
import com.ninhttd.devtest.data.dto.ExtraDTO;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.entity.ProductEntity;
import com.ninhttd.devtest.data.repository.ProductRepository;
import com.ninhttd.devtest.presentation.product.view.ProductListView;
import com.ninhttd.devtest.data.entity.ProductLevel1;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProductViewModel extends BaseViewModel<ProductListView> {
    private static final String TAG = "ProductViewModel";
    @Inject
    ProductRepository productRepository;
    int page = 0;
    ExtraDTO extraDTO;
    CodeDTO codeDTO;

    @Inject
    public ProductViewModel(@NonNull Application application) {
        super(application);
        ((TekoApplication) application).getAppComponent().inject(this);
    }

    boolean loading = false;
    public boolean searchMode = false;

    public void getProductList() {
        if (loading) {
            return;
        }
        page = 1;
        disposable.add(productRepository.getProductList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
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
                .subscribeWith(new DisposableSingleObserver<ResponseDTO<ProductLevel1>>() {
                    @Override
                    public void onSuccess(ResponseDTO<ProductLevel1> viewDTOResponseListDTO) {
                        Log.e(TAG, "getProductList onSuccess " + viewDTOResponseListDTO);
                        if (view != null) {
                            view.onLoadDataSucces(viewDTOResponseListDTO);
                        }
                        extraDTO = viewDTOResponseListDTO.getExtra();
                        codeDTO = viewDTOResponseListDTO.getCode();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.onLoadDataFailed(e);
                        }
                    }
                }));
    }

    public void loadMoreData() {
        if (loading || searchMode) {
            return;
        }
        if (page >= extraDTO.getPageSize()) {
            return;
        }
        disposable.add(productRepository.loadMore(page + 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    loading = true;
                    view.showLoadingMore();
                })
                .doFinally(() -> {
                    loading = false;
                    view.hideLoadingMore();
                })
                .subscribeWith(new DisposableSingleObserver<ResponseDTO<ProductLevel1>>() {
                    @Override
                    public void onSuccess(ResponseDTO<ProductLevel1> viewDTOResponseListDTO) {
                        Log.e(TAG, "loadMoreData onSuccess " + viewDTOResponseListDTO);
                        page++;

                        if (view != null) {
                            view.appendData(viewDTOResponseListDTO);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.onLoadDataFailed(e);
                        }
                    }
                }));
    }

    public void search(String key) {
        disposable.add(
                productRepository.search(key).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<List<ProductEntity>>() {
                    @Override
                    public void onSuccess(List<ProductEntity> productEntities) {
                        view.onSearch(productEntities);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (view != null) {
                            view.onLoadDataFailed(e);
                        }
                    }
                })
        );
    }
}
