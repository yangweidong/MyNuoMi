package com.onenews.view;

import com.onenews.bean.SharChdeals;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface HomeView {
    void showProgress();

    void addData(SharChdeals response);

    void hideProgress();

    void shoError();
}