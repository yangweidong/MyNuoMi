package com.onenews.presenter.impl;

import com.onenews.bean.ShopOrderListBean;
import com.onenews.model.ShopOrderListModel;
import com.onenews.model.impl.ShopOrderListModelImpl;
import com.onenews.presenter.ShopOrderListListener;
import com.onenews.presenter.ShopOrderListPresenter;
import com.onenews.view.BaseView;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/19.
 */
public class ShopOrderListPresenterImpl implements ShopOrderListPresenter, ShopOrderListListener {

    BaseView mBaseView;
    ShopOrderListModel mShopOrderListModel;

    public ShopOrderListPresenterImpl(BaseView mBaseView) {
        this.mBaseView = mBaseView;
        mShopOrderListModel = new ShopOrderListModelImpl();
    }


    @Override
    public void onSuccess(ShopOrderListBean response) {
        mBaseView.addData(response);
    }

    @Override
    public void onFailure(String msg, Exception e) {

    }

    @Override
    public void getShopOrderData(String url, Map<String, String> parmas) {
        mShopOrderListModel.getShopOrderList(url, parmas, this);
    }
}
