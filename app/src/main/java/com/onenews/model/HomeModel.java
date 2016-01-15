package com.onenews.model;

import com.onenews.presenter.OnHomeLoadListener;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface HomeModel {
    void loadData(String url, Map<String, String> params, OnHomeLoadListener onHomeLoadListener);
}
