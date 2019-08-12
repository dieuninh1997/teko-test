package com.ninhttd.devtest.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<T extends BaseView> extends AndroidViewModel {
    public T view;
    public CompositeDisposable disposable;
    public final MutableLiveData<Throwable> errorLD = new MutableLiveData<>();


    public BaseViewModel(@NonNull Application application) {
        super(application);
        disposable = new CompositeDisposable();
    }

    public void setView(T view) {
        this.view = view;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }
}
