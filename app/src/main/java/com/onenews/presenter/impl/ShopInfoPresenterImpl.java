package com.onenews.presenter.impl;

import com.onenews.bean.ShopInfoBean;
import com.onenews.model.ShopInfoModel;
import com.onenews.model.impl.ShopInfoModelImpl;
import com.onenews.presenter.ShopInfoListener;
import com.onenews.presenter.ShopInfoPresenter;
import com.onenews.view.BaseView;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/20.
 */
public class ShopInfoPresenterImpl implements ShopInfoPresenter, ShopInfoListener {

    private BaseView mBaseView;
    private ShopInfoModel mShopInfoModel;

    public ShopInfoPresenterImpl(BaseView mBaseView) {
        this.mBaseView = mBaseView;
        mShopInfoModel = new ShopInfoModelImpl();
    }

    @Override
    public void getShopInfo(String url, Map<String, String> parmas) {
        mShopInfoModel.getShopInfo(url, parmas, this);
    }

    @Override
    public void onSuccess(ShopInfoBean response) {

    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
