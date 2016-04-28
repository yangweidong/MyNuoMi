package com.onenews.home;

import android.support.annotation.NonNull;

import com.google.gson.reflect.TypeToken;
import com.onenews.GsonRequestCallback;
import com.onenews.api.ApiResponse;
import com.onenews.api.ApiUrl;
import com.onenews.api.SharChdeals;
import com.onenews.base.BasePresenter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;

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
    public void refreshData(final int event_tag, String url, Map<String, String> params) {
        OkHttpUtils
                .get()
                .url(ApiUrl.SEARCHDEALS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new GsonRequestCallback<ApiResponse<SharChdeals>>(new TypeToken<ApiResponse<SharChdeals>>() {
                }.getType()) {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(ApiResponse<SharChdeals> response) {
                        mHomeView.showData(response.getData().getDeals(),event_tag);
                    }
                });
    }

    @Override
    public void addMoreData() {

    }

//    public class HomeRequestCallback extends Callback<SharChdeals> {
//        //非UI线程，支持任何耗时操作
//        @Override
//        public SharChdeals parseNetworkResponse(Response response) throws IOException {
//            String string = response.body().string();
//            SharChdeals user = new Gson().fromJson(string, SharChdeals.class);
//            return user;
//        }
//
//        @Override
//        public void onError(Request request, Exception e) {
//
//        }
//
//
//        @Override
//        public void onResponse(SharChdeals response) {
//
//
//            mHomeView.showData(response);
//        }
//
//
//    }
}
