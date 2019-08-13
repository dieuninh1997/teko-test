package com.ninhttd.devtest.presentation.product.view;

import com.ninhttd.devtest.base.BaseView;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.data.entity.ProductLevel2;

public interface ProductView extends BaseView {
    void onLoadDataDetailSuccess(ResponseDTO<ProductLevel2> productResponseDTO);

    void onLoadDataDetailFailed(Throwable e);
}
