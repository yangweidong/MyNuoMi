package com.onenews.presenter;

import com.onenews.bean.SharChdeals;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface OnHomeLoadListener {
    void onSuccess(SharChdeals response);

    void onFailure(String msg, Exception e);
}
