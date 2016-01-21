package com.onenews.presenter;

import com.onenews.bean.ShopInfoBean;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface ShopInfoListener {
    void onSuccess(ShopInfoBean response);

    void onFailure(String msg, Exception e);

}
