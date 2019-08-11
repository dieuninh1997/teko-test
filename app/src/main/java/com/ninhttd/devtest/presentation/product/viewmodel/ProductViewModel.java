package com.ninhttd.devtest.presentation.product.viewmodel;


import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.base.BaseViewModel;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.dto.ResponseListDTO;
import com.ninhttd.devtest.data.dto.ViewDTO;
import com.ninhttd.devtest.data.repository.TekoRepository;
import com.ninhttd.devtest.presentation.view.ProductView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ProductViewModel extends BaseViewModel {
    private static final String TAG="ProductViewModel";
    @Inject
    TekoRepository tekoRepository;

    public MutableLiveData<ResponseListDTO<ProductView>> productLD = new MutableLiveData<>();


    public ProductViewModel(@NonNull Application application) {
        super(application);
        ((TekoApplication) application).getAppComponent().inject(this);
        getProductList();
    }

    public void getProductList() {
        disposable.add(tekoRepository.getProductList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<ResponseListDTO<ProductView>>() {
                    @Override
                    public void onSuccess(ResponseListDTO<ProductView> viewDTOResponseListDTO) {
                        Log.e(TAG, "getProductList onSuccess "+ viewDTOResponseListDTO);
                        productLD.postValue(viewDTOResponseListDTO);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "getProductList onError ",e);
                        errorLD.postValue(e);
                    }
                }));
    }
}
