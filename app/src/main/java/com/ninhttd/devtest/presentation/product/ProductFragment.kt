package com.ninhttd.devtest.presentation.product

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.jakewharton.rxbinding3.widget.queryTextChanges
import com.ninhttd.devtest.R
import com.ninhttd.devtest.TekoApplication
import com.ninhttd.devtest.base.BaseFragment
import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.data.entity.ProductLevel1
import com.ninhttd.devtest.presentation.product.adapter.ProductAdapter
import com.ninhttd.devtest.presentation.product.view.ProductListView
import com.ninhttd.devtest.presentation.product.viewmodel.ProductViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.*
import java.util.concurrent.TimeUnit

class ProductFragment : BaseFragment(), View.OnClickListener, ProductListView {


    @BindView(R.id.rv_product)
    @JvmField
    var rvProduct: RecyclerView? = null

    @BindView(R.id.progressBar)
    @JvmField
    var progressBar: ProgressBar? = null

    @BindView(R.id.img_back)
    @JvmField
    var imgBack: ImageButton? = null

    @BindView(R.id.searchView)
    @JvmField
    var searchView: SearchView? = null

    @BindView(R.id.txt_no_results)
    @JvmField
    var txtNoResults: TextView? = null

    private val data = ArrayList<ProductEntity>()

    private var productViewModel: ProductViewModel? = null
    val adapter: ProductAdapter by lazy {
        ProductAdapter(data, activity!!)
    }

    protected override val layout: Int
        get() = R.layout.fragment_product_listing

    override fun afterView() {
        setStatusBarGradiant(activity)
        productViewModel = ViewModelProviders.of(this.activity!!).get(ProductViewModel::class.java)
        productViewModel?.view = this
        val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvProduct!!.layoutManager = linearLayoutManager
        rvProduct!!.adapter = adapter

        initScrollListener()
        productViewModel!!.getProductList()

        searchView!!.queryTextChanges().debounce(300, TimeUnit.MICROSECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { charSequence ->
                    if (!TextUtils.isEmpty(charSequence)) {
                        productViewModel!!.search(charSequence as String)
                        productViewModel!!.searchMode = true
                    } else {
                        // TODO reset data without search
                        productViewModel!!.searchMode = false
                        productViewModel!!.getProductList()
                    }
                }

    }

    private fun initScrollListener() {
        rvProduct!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val linearLayoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == adapter!!.itemCount - 1) {
                    loadMore()
                }
            }
        })
    }

    private fun loadMore() {
        productViewModel!!.loadMoreData()
    }

    override fun destroyView() {}

    override fun onClick(v: View) {
        when (v.id) {
            R.id.img_back -> activity!!.supportFragmentManager.popBackStack()
            else -> {
            }
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (context!!.applicationContext as TekoApplication).appComponent!!.inject(this)
    }

    override fun onLoadDataSucces(responseDTO: ResponseDTO<ProductLevel1>) {
        val items = responseDTO.result!!.productEntities
        adapter.setData(items!!)

    }


    override fun appendData(viewDTOResponseListDTO: ResponseDTO<ProductLevel1>) {
        adapter.appendData(viewDTOResponseListDTO.result!!.productEntities!!)
    }

    override fun showLoadingMore() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideLoadingMore() {
        progressBar!!.visibility = View.GONE
    }

    override fun onSearch(productEntities: List<ProductEntity>) {
        adapter.setData(productEntities)
        adapter.notifyDataSetChanged()
        if (productEntities.isNotEmpty()) {
            txtNoResults!!.visibility = View.GONE
            rvProduct!!.visibility = View.VISIBLE
        } else {
            txtNoResults!!.visibility = View.VISIBLE
            rvProduct!!.visibility = View.GONE
        }

    }

    companion object {
        private val TAG = "ProductFragment"


        /**
         * Making notification bar transparent
         */
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        fun setStatusBarGradiant(activity: Activity?) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val w = activity!!.window
                w.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
                w.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            }
        }
    }
}
