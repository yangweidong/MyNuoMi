package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.HomeShop;
import com.onenews.model.ClassIfysearchModel;
import com.onenews.presenter.OnClassIfysearchListener;
import com.onenews.utils.L;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/15.
 */
public class ClassIfysearchModelImpl implements ClassIfysearchModel {


    OnClassIfysearchListener mOnClassIfysearchListener;

    @Override
    public void getData(String url, Map<String, String> params, OnClassIfysearchListener onClassIfysearchListener) {
        this.mOnClassIfysearchListener = onClassIfysearchListener;


        OkHttpUtils.get().url(url).params(params).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new SearchShopCallback());
    }

    @Override
    public void getDistricts(String url, Map<String, String> params, OnClassIfysearchListener onClassIfysearchListener) {

    }


    public class SearchShopCallback extends Callback<HomeShop> {
        @Override
        public HomeShop parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            HomeShop user = new Gson().fromJson(string, HomeShop.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(HomeShop response) {
            mOnClassIfysearchListener.onSuccess(response);
            L.e("数据回来了" + response.toString());
        }
    }

}
