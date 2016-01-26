package com.onenews.model;

import com.onenews.presenter.OnClassIfysearchListener;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/25.
 */
public abstract class BaseModel {
    abstract void getData(String url, Map<String, String> params, OnClassIfysearchListener onClassIfysearchListener);
}
