package com.ninhttd.devtest.presentation.product.viewmodel


import android.app.Application
import android.util.Log
import com.ninhttd.devtest.TekoApplication
import com.ninhttd.devtest.base.BaseViewModel
import com.ninhttd.devtest.data.dto.CodeDTO
import com.ninhttd.devtest.data.dto.ExtraDTO
import com.ninhttd.devtest.data.repository.ProductRepository
import com.ninhttd.devtest.presentation.product.view.ProductListView
import com.ninhttd.devtest.utils.addToCompose
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProductViewModel @Inject
constructor(application: Application) : BaseViewModel<ProductListView>(application) {
    @Inject
    lateinit var productRepository: ProductRepository
    var page = 0
    var extraDTO: ExtraDTO? = null
    var codeDTO: String? = null

    var loading = false
    var searchMode = false

    init {
        (application as TekoApplication).appComponent!!.inject(this)
    }

    fun getProductList() {
        if (loading) {
            return
        }
        page = 1
        productRepository.productList
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
                    view?.onLoadDataSucces(it)
                    extraDTO = it.extra
                    codeDTO = it.code
                }, {
                    view?.onLoadDataFailed(it)
                }).addToCompose(disposable)
    }

    fun loadMoreData() {
        if (loading || searchMode) {
            return
        }
        if (page >= extraDTO!!.pageSize!!) {
            return
        }
        productRepository!!.loadMore(page + 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable ->
                    loading = true
                    view?.showLoadingMore()
                }
                .doFinally {
                    loading = false
                    view?.hideLoadingMore()
                }
                .subscribe({
                    Log.e(TAG, "loadMoreData onSuccess $it")
                    page++
                    view?.appendData(it)
                }, {
                    view?.onLoadDataFailed(it)
                }).addToCompose(disposable)
    }

    fun search(key: String) {

        productRepository!!.search(key).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.onSearch(it)
                }, {
                    view?.onLoadDataFailed(it)

                })
                .addToCompose(disposable)
//                        .subscribeWith<>(object : DisposableSingleObserver<List<ProductEntity>>() {
//                            override fun onSuccess(productEntities: List<ProductEntity>) {
//                                view?.onSearch(productEntities)
//                            }
//
//                            override fun onError(e: Throwable) {
//                                if (view != null) {
//                                    view?.onLoadDataFailed(e)
//                                }
//                            }
//                        })
    }

    companion object {
        private val TAG = "ProductViewModel"
    }
}
