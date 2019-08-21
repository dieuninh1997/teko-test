package com.ninhttd.devtest.presentation.product.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData

import com.ninhttd.devtest.TekoApplication
import com.ninhttd.devtest.base.BaseViewModel
import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.repository.ProductRepository
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.data.entity.ProductLevel2
import com.ninhttd.devtest.presentation.product.view.ProductView

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ProductDetailViewModel @Inject constructor(application: Application) : BaseViewModel<ProductView>(application) {

    @Inject
    lateinit var productRepository: ProductRepository

    var productDetailLD = MutableLiveData<ResponseDTO<ProductEntity>>()


    var loading = false


    init {
        (application as TekoApplication).appComponent!!.inject(this)
    }

    fun getProductDetail(sku: String) {
        if (loading) {
            return
        }
        disposable.add(productRepository!!.getProductDetail(sku)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    loading = true
                    view?.showLoading()
                }
                .doFinally {
                    loading = false
                    view?.hideLoading()
                }
                .subscribe({
                    view?.onLoadDataDetailSuccess(it)
                }, {
                    view?.onLoadDataFailed(it)
                }))

    }

    companion object {

        private val TAG = "ProductDetailViewModel"
    }
}
