package com.ninhttd.devtest.presentation.product.view

import com.ninhttd.devtest.base.BaseView
import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.entity.ProductEntity
import com.ninhttd.devtest.data.entity.ProductLevel1

interface ProductListView : BaseView {
    fun onLoadDataSucces(viewDTOResponseListDTO: ResponseDTO<ProductLevel1>)

    fun appendData(viewDTOResponseListDTO: ResponseDTO<ProductLevel1>)

    fun showLoadingMore()

    fun hideLoadingMore()

    fun onSearch(productEntities: List<ProductEntity>)
}
