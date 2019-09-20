package com.ninhttd.devtest.base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onLoadDataFailed(e: Throwable)
}
