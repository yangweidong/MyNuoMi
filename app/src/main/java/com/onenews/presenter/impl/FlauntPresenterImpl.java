package com.onenews.presenter.impl;

import com.onenews.bean.FlauntBean;
import com.onenews.bean.SharChdeals;
import com.onenews.model.FlauntModel;
import com.onenews.model.HomeModel;
import com.onenews.model.impl.FlauntModelImpl;
import com.onenews.model.impl.HomeModelImpl;
import com.onenews.presenter.FlauntLoadListener;
import com.onenews.presenter.FlauntPresenter;
import com.onenews.presenter.HomePresenter;
import com.onenews.presenter.OnHomeLoadListener;
import com.onenews.view.BaseView;
import com.onenews.view.HomeView;

import java.util.List;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/14.
 */
public class FlauntPresenterImpl implements FlauntPresenter, FlauntLoadListener {

    private BaseView mBaseView;
    private FlauntModel mFlauntModel;

    public FlauntPresenterImpl(BaseView baseView) {
        this.mBaseView = baseView;
        mFlauntModel = new FlauntModelImpl();
    }

    @Override
    public void loadData(String url, Map<String, String> params) {
        mBaseView.showProgress();
        mFlauntModel.loadData(url, params, this);
    }


    @Override
    public void onSuccess(List<FlauntBean.DataEntity.ResultArrayEntity> response) {
        mBaseView.hideProgress();
        mBaseView.addData(response);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mBaseView.shoError(msg);
    }
}
