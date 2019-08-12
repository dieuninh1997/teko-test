package com.ninhttd.devtest.presentation.product;

import com.ninhttd.devtest.base.BaseView;
import com.ninhttd.devtest.data.dto.ResponseDTO;
import com.ninhttd.devtest.presentation.view.ProductViewLevel1;

public interface  ProductListView extends BaseView {
     void onLoadDataSucces(ResponseDTO<ProductViewLevel1> viewDTOResponseListDTO);
     void onLoadDataFailed(Throwable e);

    void appendData(ResponseDTO<ProductViewLevel1> viewDTOResponseListDTO);

    void showLoadingMore();

    void hideLoadingMore();

}
