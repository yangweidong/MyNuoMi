package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.DistrictBean;
import com.onenews.bean.HomeShop;
import com.onenews.api.ApiUrl;
import com.onenews.model.ClassIfysearchModel;
import com.onenews.presenter.OnClassIfysearchListener;
import com.onenews.utils.LL;
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
        LL.e("请求参数是:" + params.toString());

        OkHttpUtils.get().url(url).params(params).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new SearchShopCallback());
    }


    public class SearchShopCallback extends Callback<HomeShop> {
        @Override
        public HomeShop parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            HomeShop homeShop = new Gson().fromJson(string, HomeShop.class);
            return homeShop;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(HomeShop response) {
            if (null != mOnClassIfysearchListener) {
                mOnClassIfysearchListener.onSuccess(response);
                LL.e("数据回来了" + response.toString());
            }
        }
    }


    @Override
    public void getDistricts(String url, Map<String, String> params, OnClassIfysearchListener onClassIfysearchListener) {
        OkHttpUtils.get().url(ApiUrl.DISTRICTS).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").params(params).build().execute(new RegionCallback());
    }


    public class RegionCallback extends Callback<DistrictBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public DistrictBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            DistrictBean user = new Gson().fromJson(string, DistrictBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(DistrictBean response) {
            LL.e("列表数据来了" + response.toString());
            mOnClassIfysearchListener.getDistrictSuccess(response);


        }
    }


}
