package com.ninhttd.devtest.dj

import android.app.Application

import com.ninhttd.devtest.TekoApplication
import com.ninhttd.devtest.presentation.product.ProductFragment
import com.ninhttd.devtest.presentation.product.viewmodel.ProductDetailViewModel
import com.ninhttd.devtest.presentation.product.viewmodel.ProductViewModel

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(productViewModel: ProductViewModel)
    fun inject(productDetailViewModel: ProductDetailViewModel)
    fun inject(tekoApplication: TekoApplication)

    fun inject(productFragment: ProductFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }
}
