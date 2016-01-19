package com.onenews.presenter;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/15.
 */
public interface ClassIfysearchPresenter {

    //商家列表
    void loadBusiness(String url, Map<String, String> params);

    //区域
    void loadDistricts(String url, Map<String, String> params);
}
