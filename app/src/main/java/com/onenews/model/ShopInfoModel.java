package com.onenews.model;

import com.onenews.presenter.ShopInfoListener;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/20.
 */
public interface ShopInfoModel {
    public void getShopInfo(String url, Map<String, String> params, ShopInfoListener shopInfoListener);


    public void getShopImages(String url);
}
