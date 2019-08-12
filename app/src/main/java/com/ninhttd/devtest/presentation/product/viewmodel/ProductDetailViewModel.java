package com.ninhttd.devtest.presentation.product.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.base.BaseViewModel;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.repository.TekoRepository;
import com.ninhttd.devtest.presentation.view.ProductView;

import javax.inject.Inject;

public class ProductDetailViewModel extends BaseViewModel {

    private static final String TAG = "ProductDetailViewModel";

    @Inject
    TekoRepository tekoRepository;

    public MutableLiveData<ResponseDTO<ProductView>> productDetailLD = new MutableLiveData<>();


    @Inject
    public ProductDetailViewModel(@NonNull Application application) {
        super(application);
    }
}
