package com.ninhttd.devtest.base

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.ninhttd.devtest.custom.DialogUtil
import com.ninhttd.devtest.custom.LogUtils
import com.ninhttd.devtest.utils.KeyboardUtil

import butterknife.ButterKnife
import com.ninhttd.devtest.data.remote.exception.HandlerException

abstract class BaseFragment : Fragment(), BaseView {

    protected abstract val layout: Int
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        afterView()
    }

    protected abstract fun afterView()

    protected abstract fun destroyView()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        LogUtils.errorLog(this, "current scree: " + this.javaClass.simpleName)
        return inflater.inflate(layout, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        destroyView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("----------", "onDestroyView")
    }

    override fun onDetach() {
        super.onDetach()
    }

    fun showKeyboard(isShow: Boolean) {
        if (isShow) {
            KeyboardUtil.showKeyboard(activity!!)
        } else {
            KeyboardUtil.hideKeyboard(activity!!)
        }
    }

    override fun showLoading() {
        DialogUtil.getInstance(context!!).showDialogLoading()
    }

    override fun hideLoading() {
        DialogUtil.getInstance(context!!).dismissDialog()
    }

    override fun onLoadDataFailed(e: Throwable) {
        HandlerException.showException(context!!, e.message!!)
    }
}
