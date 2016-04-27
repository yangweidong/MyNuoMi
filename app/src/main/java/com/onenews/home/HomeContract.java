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
        /**
         * 刷新数据,首次打开界面也是刷新
         * @param event_tag 请求动作类型
         * @param url
         * @param params
         */
        void refreshData(int event_tag, String url, Map<String, String> params);

        /**
         * 加载更多
         */
        void addMoreData();
    }
}
