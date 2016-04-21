package com.onenews.home;

import com.onenews.BasePresenter;
import com.onenews.BaseView;
import com.onenews.bean.FlauntBean;

import java.util.List;
import java.util.Map;

/**
 * Created by yangweidong on 16/4/21.
 */
public interface FlauntContract {

    interface View extends BaseView<Presenter> {
        void showData(List<FlauntBean.DataEntity.ResultArrayEntity> response);
    }

    interface Presenter extends BasePresenter {
        void loadFlauntData(String url, Map<String, String> params);
    }
}
