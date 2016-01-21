package com.onenews.presenter;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/20.
 */
public interface ShopInfoPresenter {
    public void getShopInfo(String url, Map<String, String> parmas);

    public void getShopImage(String url);
}
