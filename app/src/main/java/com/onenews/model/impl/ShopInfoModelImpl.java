package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.ShopInfoBean;
import com.onenews.http.Api;
import com.onenews.model.ShopInfoModel;
import com.onenews.presenter.ShopInfoListener;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/20.
 */
public class ShopInfoModelImpl implements ShopInfoModel {
    ShopInfoListener mShopInfoListener;

    @Override
    public void getShopInfo(String url, Map<String, String> params, ShopInfoListener shopInfoListener) {
        mShopInfoListener = shopInfoListener;
        OkHttpUtils
                .get()
                .url(Api.SEARCHDEALS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new ShopInfoRequestCallback());
    }

    @Override
    public void getShopImage(String url) {

    }


    public class ShopInfoRequestCallback extends Callback<ShopInfoBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public ShopInfoBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            ShopInfoBean user = new Gson().fromJson(string, ShopInfoBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(ShopInfoBean response) {
            mShopInfoListener.onSuccess(response);

        }
    }


}
