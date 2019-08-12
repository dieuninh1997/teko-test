package com.ninhttd.devtest.presentation.product;

import android.os.Bundle;
import android.view.animation.Animation;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.utils.Constant;

public class TabFragment extends BaseFragment {
    private static final String TAG = "TabFragment";


    @Override
    protected void afterView() {
    }

    @Override
    protected int getLayout() {
        Bundle arguments = getArguments();
        String tabTitle = arguments.getString(Constant.ViewParam.TAB_TITLE);
        if (tabTitle.equals(getContext().getString(R.string.tab_title_0))) {
            return R.layout.fragment_tab_mo_ta;
        } else if (tabTitle.equals(getContext().getString(R.string.tab_title_1))) {
            return R.layout.fragment_tab_thong_so_ky_thuat;
        } else {
            return R.layout.fragment_tab;
        }
    }

    @Override
    protected void destroyView() {

    }


}
