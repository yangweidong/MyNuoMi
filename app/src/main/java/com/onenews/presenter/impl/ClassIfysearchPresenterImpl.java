package com.onenews.presenter.impl;

import com.onenews.bean.HomeShop;
import com.onenews.model.ClassIfysearchModel;
import com.onenews.model.impl.ClassIfysearchModelImpl;
import com.onenews.presenter.ClassIfysearchPresenter;
import com.onenews.presenter.OnClassIfysearchListener;
import com.onenews.view.BaseView;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/15.
 */
public class ClassIfysearchPresenterImpl implements ClassIfysearchPresenter, OnClassIfysearchListener {

    private BaseView mBaseView;
    private ClassIfysearchModel mClassIfysearchModel;


    public ClassIfysearchPresenterImpl(BaseView mBaseView) {
        this.mBaseView = mBaseView;
        mClassIfysearchModel = new ClassIfysearchModelImpl();
    }

    @Override
    public void loadBusiness(String url, Map<String, String> params) {
        mClassIfysearchModel.getData(url, params, this);
    }

    @Override
    public void loadDistricts(String url, Map<String, String> params) {
        // TODO: 16/1/18 如果一个界面中有两个请求,那么请求成功回调的参数
    }

    @Override
    public void onSuccess(HomeShop response) {

        mBaseView.addData(response);

    }

    @Override
    public void onFailure(String msg, Exception e) {

    }
}
