package com.onenews.model.impl;

import com.google.gson.Gson;
import com.onenews.bean.FlauntBean;
import com.onenews.bean.SharChdeals;
import com.onenews.http.Api;
import com.onenews.model.FlauntModel;
import com.onenews.model.HomeModel;
import com.onenews.presenter.FlauntLoadListener;
import com.onenews.presenter.OnHomeLoadListener;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/14.
 */
public class FlauntModelImpl implements FlauntModel {
    FlauntLoadListener mFlauntLoadListener;

    @Override
    public void loadData(String url, Map<String, String> params, FlauntLoadListener flauntLoadListener) {
        mFlauntLoadListener = flauntLoadListener;
        OkHttpUtils
                .get()
                .url(url)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new FlauntRequestCallback());
    }


    public class FlauntRequestCallback extends Callback<FlauntBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public FlauntBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            FlauntBean user = new Gson().fromJson(string, FlauntBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(FlauntBean response) {

            if (response.getStatus().getCode().equals(1)) {
                //Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
                return;
            }

            if (response.getStatus().getCode().equals(2)) {
                //Toast.makeText(getActivity(), "参数错误", Toast.LENGTH_SHORT).show();
                return;
            }

            if (response.getStatus().getCode().equals(3)) {
                //Toast.makeText(getActivity(), "缺失必须参数", Toast.LENGTH_SHORT).show();
                return;
            }
            if (response.getStatus().getCode().equals(4) ) {
                //Toast.makeText(getActivity(), "认证未通过", Toast.LENGTH_SHORT).show();
                return;
            }
            if (response.getStatus().getCode().equals(5) ) {
                //Toast.makeText(getActivity(), "获取数据为空", Toast.LENGTH_SHORT).show();
                return;
            }

            mFlauntLoadListener.onSuccess(response.getData().getResultArray());
        }
    }
}
