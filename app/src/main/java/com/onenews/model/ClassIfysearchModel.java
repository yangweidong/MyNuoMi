package com.onenews.model;

import com.onenews.presenter.OnClassIfysearchListener;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/15.
 */
public interface ClassIfysearchModel {

    void getData(String url, Map<String, String> params, OnClassIfysearchListener onClassIfysearchListener);

    void getDistricts(String url, Map<String, String> params, OnClassIfysearchListener onClassIfysearchListener);

}
