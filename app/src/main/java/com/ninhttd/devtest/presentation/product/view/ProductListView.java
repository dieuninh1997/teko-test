package com.ninhttd.devtest.presentation.product.view;

import com.ninhttd.devtest.base.BaseView;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.presentation.product.model.ProductLevel1;

public interface  ProductListView extends BaseView {
     void onLoadDataSucces(ResponseDTO<ProductLevel1> viewDTOResponseListDTO);
     void onLoadDataFailed(Throwable e);

    void appendData(ResponseDTO<ProductLevel1> viewDTOResponseListDTO);

    void showLoadingMore();

    void hideLoadingMore();

}
