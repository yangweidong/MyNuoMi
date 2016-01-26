package com.onenews.presenter.impl;

import com.onenews.bean.SharChdeals;
import com.onenews.model.HomeModel;
import com.onenews.model.impl.HomeModelImpl;
import com.onenews.presenter.HomePresenter;
import com.onenews.presenter.OnHomeLoadListener;
import com.onenews.view.HomeView;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/14.
 */
public class HomePresenterImpl implements HomePresenter, OnHomeLoadListener {

    private HomeView mHomeView;
    private HomeModel mHomeModel;

    public HomePresenterImpl(HomeView homeView) {
        this.mHomeView = homeView;
        mHomeModel = new HomeModelImpl();
    }

    @Override
    public void loadData(String url, Map<String, String> params) {
        mHomeView.showProgress();
        mHomeModel.loadData(url, params, this);
    }


    @Override
    public void onSuccess(SharChdeals response) {
        mHomeView.hideProgress();
        mHomeView.addData(response);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mHomeView.shoError(msg);
    }
}
