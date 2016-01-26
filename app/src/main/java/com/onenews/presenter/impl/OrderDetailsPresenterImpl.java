package com.onenews.presenter.impl;

import com.onenews.bean.OrderDetailsBean;
import com.onenews.model.OrderDetailsModel;
import com.onenews.model.impl.OrderDetailsModelImpl;
import com.onenews.presenter.OrderDetailsListener;
import com.onenews.presenter.OrderDetailsPresenter;
import com.onenews.view.BaseView;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/25.
 */
public class OrderDetailsPresenterImpl implements OrderDetailsPresenter, OrderDetailsListener {
    OrderDetailsModel mOrderDetailsModel;

    BaseView mBaseView;


    public OrderDetailsPresenterImpl(BaseView baseView) {
        this.mBaseView = baseView;
        this.mOrderDetailsModel = new OrderDetailsModelImpl();
    }

    @Override
    public void loadData(String url, Map<String, String> params) {
        mOrderDetailsModel.getData(url, params, this);
    }


    @Override
    public void onSuccess(OrderDetailsBean response) {
        mBaseView.addData(response);
    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
