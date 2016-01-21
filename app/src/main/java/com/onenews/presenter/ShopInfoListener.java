package com.onenews.presenter;

import com.onenews.activity.ShopImage;
import com.onenews.bean.ShopInfoBean;

import java.util.List;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface ShopInfoListener {
    void onSuccess(ShopInfoBean response);

    void onFailure(String msg, Exception e);

    void onShopImageData(List<ShopImage> shopImages);

}
