package com.onenews.presenter;

import com.onenews.bean.ShopOrderListBean;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface ShopOrderListListener {
    void onSuccess(ShopOrderListBean response);

    void onFailure(String msg, Exception e);
}
