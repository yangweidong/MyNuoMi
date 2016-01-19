package com.onenews.presenter;

import com.onenews.bean.DistrictBean;
import com.onenews.bean.HomeShop;

/**
 * Created by yangweidong on 16/1/15.
 */
public interface OnClassIfysearchListener {
    void onSuccess(HomeShop response);

//    void on

    void onFailure(String msg, Exception e);


    void getDistrictSuccess(DistrictBean cityBeen);
}
