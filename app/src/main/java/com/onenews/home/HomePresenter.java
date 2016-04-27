package com.onenews.home;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.onenews.GsonRequestCallback;
import com.onenews.api.ApiUrl;
import com.onenews.base.BasePresenter;
import com.onenews.bean.SharChdeals;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yangweidong on 16/4/21.
 */
public class HomePresenter extends BasePresenter implements HomeContract.Presenter {

    HomeContract.View mHomeView;


    public HomePresenter(@NonNull HomeContract.View view) {
        mHomeView = view;
        mHomeView.setPresenter(this);
    }


    @Override
    public void refreshData(int event_tag, String url, Map<String, String> params) {
        OkHttpUtils
                .get()
                .url(ApiUrl.SEARCHDEALS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new GsonRequestCallback<SharChdeals>(SharChdeals.class) {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(SharChdeals response) {
                        mHomeView.showData(response);
                    }
                });
    }

    @Override
    public void addMoreData() {

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


            mHomeView.showData(response);
        }


    }
}
