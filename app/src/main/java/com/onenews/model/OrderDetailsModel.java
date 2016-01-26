package com.onenews.model;

import com.onenews.presenter.OrderDetailsListener;

import java.util.Map;

/**
 * Created by yangweidong on 16/1/25.
 */
public interface OrderDetailsModel {
    void getData(String url, Map<String, String> params, OrderDetailsListener baseListener);
}
