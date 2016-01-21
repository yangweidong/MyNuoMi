package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.ShopOrderListBean;
import com.onenews.http.Api;
import com.onenews.model.ShopOrderListModel;
import com.onenews.presenter.ShopOrderListListener;
import com.onenews.utils.L;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/19.
 */
public class ShopOrderListModelImpl implements ShopOrderListModel {

    ShopOrderListListener mShopOrderListListener;

    @Override
    public void getShopOrderList(String url, Map<String, String> params,
                                 ShopOrderListListener shopOrderListListener) {
        mShopOrderListListener = shopOrderListListener;
        OkHttpUtils.get().url(Api.SHOP_ORDER_LIST).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").
                params(params).build().execute(new ShopOrderCallback());

    }

    public class ShopOrderCallback extends Callback<ShopOrderListBean> {
        @Override
        public ShopOrderListBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            ShopOrderListBean shopOrderListBean = new Gson().fromJson(string, ShopOrderListBean.class);
            return shopOrderListBean;
        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(ShopOrderListBean response) {
            L.e("订单列表数据过来了" + response.toString());
            mShopOrderListListener.onSuccess(response);

        }
    }


}
