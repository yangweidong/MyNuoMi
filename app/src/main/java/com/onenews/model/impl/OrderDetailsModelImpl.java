package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.OrderDetailsBean;
import com.onenews.model.OrderDetailsModel;
import com.onenews.presenter.OrderDetailsListener;
import com.onenews.utils.LL;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/25.
 */
public class OrderDetailsModelImpl implements OrderDetailsModel {
    OrderDetailsListener baseListener;

    @Override
    public void getData(String url, Map<String, String> params, OrderDetailsListener baseListener) {
        this.baseListener = baseListener;

        LL.e("请求参数是" + params.toString());
        OkHttpUtils.get().url(url).params(params)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .build()
                .execute(new OrderDetailsCallback());
    }

    public class OrderDetailsCallback extends Callback<OrderDetailsBean> {
        @Override
        public OrderDetailsBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            OrderDetailsBean homeShop = new Gson().fromJson(string, OrderDetailsBean.class);
            return homeShop;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(OrderDetailsBean response) {
            baseListener.onSuccess(response);
            LL.e("数据回来了" + response.toString());
        }
    }
}
