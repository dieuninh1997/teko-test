package com.ninhttd.devtest.presentation.product.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.presentation.product.TabFragment;
import com.ninhttd.devtest.presentation.product.model.AttributeGroup;
import com.ninhttd.devtest.utils.Constant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TabsAdapter extends FragmentPagerAdapter {

    private Context context;
    private TabFragment[] fragments;
    private int[] titleIds = new int[]{
            R.string.tab_title_0,
            R.string.tab_title_1,
            R.string.tab_title_2,
    };

    private List<AttributeGroup> attributeGroups;

//    public void setAttributeGroups(List<AttributeGroup> attributeGroups) {
//        this.attributeGroups = attributeGroups;
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Constant.ViewParam.ATTRIBUTE_GROUP, (Serializable) attributeGroups);
//    }

    public TabsAdapter(Context context, FragmentManager fm, List<AttributeGroup> attributeGroups) {
        super(fm);
        this.context = context;
        this.attributeGroups = attributeGroups;
        fragments = new TabFragment[getCount()];
        for (int i = 0; i < getCount(); i++) {
            Bundle bundle = new Bundle();
            bundle.putString(Constant.ViewParam.TAB_TITLE, context.getString(titleIds[i]));
            bundle.putSerializable(Constant.ViewParam.ATTRIBUTE_GROUP, (Serializable) attributeGroups);
            TabFragment tabFragment = new TabFragment();
            tabFragment.setArguments(bundle);
            fragments[i] = tabFragment;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(titleIds[position]);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return titleIds.length;
    }

}
