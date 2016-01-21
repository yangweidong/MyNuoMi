package com.onenews.presenter.impl;

import com.onenews.activity.ShopImage;
import com.onenews.bean.ShopInfoBean;
import com.onenews.model.ShopInfoModel;
import com.onenews.model.impl.ShopInfoModelImpl;
import com.onenews.presenter.ShopInfoListener;
import com.onenews.presenter.ShopInfoPresenter;
import com.onenews.view.ShopInfoView;

import java.util.List;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/20.
 */
public class ShopInfoPresenterImpl implements ShopInfoPresenter, ShopInfoListener {

    private ShopInfoView mBaseView;
    private ShopInfoModel mShopInfoModel;

    public ShopInfoPresenterImpl(ShopInfoView mBaseView) {
        this.mBaseView = mBaseView;
        mShopInfoModel = new ShopInfoModelImpl();
    }

    @Override
    public void getShopInfo(String url, Map<String, String> parmas) {
        mShopInfoModel.getShopInfo(url, parmas, this);
    }

    @Override
    public void getShopImage(String url) {
        mShopInfoModel.getShopImages(url);
    }

    @Override
    public void onSuccess(ShopInfoBean response) {
        mBaseView.addData(response);
    }

    @Override
    public void onFailure(String msg, Exception e) {

    }

    @Override
    public void onShopImageData(List<ShopImage> shopImages) {
        mBaseView.addShopImage(shopImages);
    }
}
