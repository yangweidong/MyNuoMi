package com.onenews.view;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface BaseView<T> {
    abstract void showProgress();

    abstract void addData(T response);

    abstract void hideProgress();

    abstract void shoError(String msg);
}
