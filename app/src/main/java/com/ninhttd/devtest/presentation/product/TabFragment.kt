package com.ninhttd.devtest.presentation.product

import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ninhttd.devtest.R
import com.ninhttd.devtest.base.BaseFragment
import com.ninhttd.devtest.data.entity.AttributeGroup
import com.ninhttd.devtest.presentation.product.adapter.ThongSoKiThuatAdapter
import com.ninhttd.devtest.utils.Constant

class TabFragment : BaseFragment() {
    companion object {
        private val TAG = "TabFragment"
    }

    private var attributeGroups: List<AttributeGroup>? = null

    override val layout: Int
        get() {
            val arguments = arguments
            val tabTitle = arguments!!.getString(Constant.ViewParam.TAB_TITLE)

            return when (tabTitle) {
                getString(R.string.tab_title_0) -> R.layout.fragment_tab_mo_ta
                getString(R.string.tab_title_1) -> R.layout.fragment_tab_thong_so_ky_thuat
                else -> R.layout.fragment_tab
            }
        }


    override fun afterView() {
        val arguments = arguments
        val tabTitle = arguments!!.getString(Constant.ViewParam.TAB_TITLE)
        attributeGroups = arguments.getSerializable(Constant.ViewParam.ATTRIBUTE_GROUP) as List<AttributeGroup>

        when (tabTitle) {
            context!!.getString(R.string.tab_title_0) -> initTabMoTa()
            context!!.getString(R.string.tab_title_1) -> initTabThongSoKT()
            else -> initTabSoSanhGia()
        }
    }

    private fun initTabSoSanhGia() {

    }

    private fun initTabThongSoKT() {
        activity?.apply {
            val rvThongSoKt = findViewById<RecyclerView>(R.id.rv_thong_so_kt)
            val btnShowMore = findViewById<LinearLayout>(R.id.btn_show_more)
            if (attributeGroups!!.size > 3) {
                btnShowMore.visibility = View.VISIBLE
            } else {
                btnShowMore.visibility = View.GONE
            }
            val thongSoKiThuatAdapter = ThongSoKiThuatAdapter(attributeGroups, activity!!)
            rvThongSoKt.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            rvThongSoKt.adapter = thongSoKiThuatAdapter
            rvThongSoKt.isNestedScrollingEnabled = false
        }

    }

    private fun initTabMoTa() {}

    override fun destroyView() {

    }


}
