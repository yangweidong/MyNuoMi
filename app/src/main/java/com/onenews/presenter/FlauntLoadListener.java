package com.onenews.presenter;

import com.onenews.bean.FlauntBean;
import com.onenews.bean.SharChdeals;

import java.util.List;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface FlauntLoadListener {
    void onSuccess(List<FlauntBean.DataEntity.ResultArrayEntity> response);

    void onFailure(String msg, Exception e);
}
