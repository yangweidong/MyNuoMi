package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.SharChdeals;
import com.onenews.http.Api;
import com.onenews.model.HomeModel;
import com.onenews.presenter.OnHomeLoadListener;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/14.
 */
public class HomeModelImpl implements HomeModel {
    OnHomeLoadListener mOnHomeLoadListener;

    @Override
    public void loadData(String url, Map<String, String> params, OnHomeLoadListener onHomeLoadListener) {
        mOnHomeLoadListener = onHomeLoadListener;
        OkHttpUtils
                .get()
                .url(Api.SEARCHDEALS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new HomeRequestCallback());
    }


    public class HomeRequestCallback extends Callback<SharChdeals> {
        //非UI线程，支持任何耗时操作
        @Override
        public SharChdeals parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            SharChdeals user = new Gson().fromJson(string, SharChdeals.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(SharChdeals response) {

            if (response.getErrno() == 1001) {
                //Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
                return;
            }

            if (response.getErrno() == 1002) {
                //Toast.makeText(getActivity(), "参数错误", Toast.LENGTH_SHORT).show();
                return;
            }

            if (response.getErrno() == 1003) {
                //Toast.makeText(getActivity(), "缺失必须参数", Toast.LENGTH_SHORT).show();
                return;
            }
            if (response.getErrno() == 1004) {
                //Toast.makeText(getActivity(), "认证未通过", Toast.LENGTH_SHORT).show();
                return;
            }
            if (response.getErrno() == 1005) {
                //Toast.makeText(getActivity(), "获取数据为空", Toast.LENGTH_SHORT).show();
                return;
            }
            mOnHomeLoadListener.onSuccess(response);
        }
    }
}