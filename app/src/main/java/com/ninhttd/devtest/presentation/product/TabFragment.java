package com.ninhttd.devtest.presentation.product;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.base.BaseFragment;
import com.ninhttd.devtest.presentation.product.adapter.ThongSoKiThuatAdapter;
import com.ninhttd.devtest.data.entity.AttributeGroup;
import com.ninhttd.devtest.utils.Constant;

import java.util.List;

public class TabFragment extends BaseFragment {
    private static final String TAG = "TabFragment";
    List<AttributeGroup> attributeGroups;


    @Override
    protected void afterView() {
        Bundle arguments = getArguments();
        String tabTitle = arguments.getString(Constant.ViewParam.TAB_TITLE);
        attributeGroups = (List<AttributeGroup>) arguments.getSerializable(Constant.ViewParam.ATTRIBUTE_GROUP);

        if (tabTitle.equals(getContext().getString(R.string.tab_title_0))) {
            initTabMoTa();
        } else if (tabTitle.equals(getContext().getString(R.string.tab_title_1))) {
            initTabThongSoKT();
        } else {
            initTabSoSanhGia();
        }
    }

    private void initTabSoSanhGia() {

    }

    private void initTabThongSoKT() {
        RecyclerView rvThongSoKt = getActivity().findViewById(R.id.rv_thong_so_kt);
        LinearLayout btnShowMore = getActivity().findViewById(R.id.btn_show_more);
        if (attributeGroups.size() > 3) {
            btnShowMore.setVisibility(View.VISIBLE);
        } else {
            btnShowMore.setVisibility(View.GONE);
        }
        ThongSoKiThuatAdapter thongSoKiThuatAdapter = new ThongSoKiThuatAdapter(attributeGroups, getActivity());
        rvThongSoKt.setLayoutManager(new LinearLayoutManager(this.getContext(), RecyclerView.VERTICAL, false));
        rvThongSoKt.setAdapter(thongSoKiThuatAdapter);
        rvThongSoKt.setNestedScrollingEnabled(false);
    }

    private void initTabMoTa() {
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
