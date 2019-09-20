package com.ninhttd.devtest.presentation.product.adapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.ninhttd.devtest.R
import com.ninhttd.devtest.presentation.product.TabFragment
import com.ninhttd.devtest.data.entity.AttributeGroup
import com.ninhttd.devtest.utils.Constant

import java.io.Serializable

class TabsAdapter(private val context: Context, fm: FragmentManager, private val attributeGroups: List<AttributeGroup>) : FragmentPagerAdapter(fm) {
    private val fragments: Array<TabFragment?> = arrayOfNulls(3)
    private val titleIds = intArrayOf(R.string.tab_title_0, R.string.tab_title_1, R.string.tab_title_2)

    init {
        for (i in 0 until count) {
            val bundle = Bundle()
            bundle.putString(Constant.ViewParam.TAB_TITLE, context.getString(titleIds[i]))
            bundle.putSerializable(Constant.ViewParam.ATTRIBUTE_GROUP, attributeGroups as Serializable)
            val tabFragment = TabFragment()
            tabFragment.arguments = bundle
            fragments[i] = tabFragment
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.getString(titleIds[position])
    }

    override fun getItem(position: Int): Fragment? {
        return fragments[position]
    }

    override fun getCount(): Int {
        return titleIds.size
    }

}
