package com.ninhttd.devtest.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel<T : BaseView>(application: Application) : AndroidViewModel(application) {
    var view: T? = null
    val disposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }
    val errorLD = MutableLiveData<Throwable>()

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
