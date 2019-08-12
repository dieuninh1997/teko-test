package com.ninhttd.devtest.data.dj;

import android.app.Application;

import com.ninhttd.devtest.TekoApplication;
import com.ninhttd.devtest.presentation.product.ProductFragment;
import com.ninhttd.devtest.presentation.product.viewmodel.ProductViewModel;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(ProductViewModel productViewModel);
    void inject(TekoApplication tekoApplication);

    void inject(ProductFragment productFragment);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        Builder appModule(AppModule appModule);

        AppComponent build();
    }
}
