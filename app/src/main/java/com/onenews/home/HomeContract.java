package com.onenews.home;

import com.onenews.BasePresenter;
import com.onenews.BaseView;
import com.onenews.bean.SharChdeals;

import java.util.Map;

/**
 * Created by yangweidong on 16/4/21.
 */
public interface HomeContract {

    interface View extends BaseView<Presenter> {
        void showData(SharChdeals response);

    }

    interface Presenter extends BasePresenter {
        void loadHomeData(String url, Map<String, String> params);

    }
}
