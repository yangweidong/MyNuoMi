package com.onenews.presenter.impl;

import com.onenews.R;
import com.onenews.presenter.MainPresenter;
import com.onenews.view.MainView;

/**
 * Created by yangweidong on 16/1/14.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mMainView;

    public MainPresenterImpl(MainView mMainView) {
        this.mMainView = mMainView;
    }


    @Override
    public void switchNavigation(int id) {
        switch (id) {
            case R.id.navigation_item_news:
                mMainView.showShoppingPage();
                break;
            case R.id.navigation_item_images:
                break;
            case R.id.navigation_item_weather:
                break;
            case R.id.navigation_item_about:
                break;
            default:
                break;
        }
    }
}
