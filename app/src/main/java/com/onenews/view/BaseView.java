package com.onenews.view;

import com.onenews.bean.SharChdeals;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface BaseView {
    abstract void showProgress();

    abstract void addData(SharChdeals response);

    abstract void hideProgress();

    abstract void shoError();
}
