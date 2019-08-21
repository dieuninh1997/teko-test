package com.ninhttd.devtest.presentation.product.view

import com.ninhttd.devtest.base.BaseView
import com.ninhttd.devtest.data.dto.ResponseDTO
import com.ninhttd.devtest.data.entity.ProductLevel2

interface ProductView : BaseView {
    fun onLoadDataDetailSuccess(productResponseDTO: ResponseDTO<ProductLevel2>)


}
