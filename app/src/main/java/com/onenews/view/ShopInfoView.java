package com.onenews.view;

import com.onenews.activity.ShopImage;

import java.util.List;

/**
 * Created by yangweidong on 16/1/21.
 */
public interface ShopInfoView<T> extends BaseView<T> {

    public void addShopImage(List<ShopImage> shopImages);

}
