package com.onenews.presenter;

import com.onenews.bean.OrderDetailsBean;

/**
 * Created by yangweidong on 16/1/25.
 */
public interface OrderDetailsListener<T> {
    void onSuccess(OrderDetailsBean response);

    void onFailure(String msg, Exception e);

}
