package com.ninhttd.devtest.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ninhttd.devtest.custom.LogUtils;
import com.ninhttd.devtest.utils.KeyboardUtil;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements BaseView {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        afterView();
    }

    protected abstract void afterView();

    protected abstract int getLayout();

    protected abstract void destroyView();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LogUtils.errorLog(this, "current scree: " + this.getClass().getSimpleName());
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("----------", "onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void showKeyboard(boolean isShow) {
        if (isShow) {
            KeyboardUtil.showKeyboard(getActivity());
        } else {
            KeyboardUtil.hideKeyboard(getActivity());
        }
    }
}
