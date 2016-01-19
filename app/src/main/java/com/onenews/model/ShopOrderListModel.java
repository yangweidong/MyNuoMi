package com.onenews.model;

import com.onenews.presenter.ShopOrderListListener;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/19.
 */
public interface ShopOrderListModel {

    public void getShopOrderList(String url, Map<String, String> params, ShopOrderListListener shopOrderListListener);

}
