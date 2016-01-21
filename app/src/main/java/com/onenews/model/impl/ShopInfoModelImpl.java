package com.onenews.model.impl;

import android.util.Log;

import com.google.gson.Gson;
import com.onenews.activity.ShopImage;
import com.onenews.bean.ShopInfoBean;
import com.onenews.model.ShopInfoModel;
import com.onenews.presenter.ShopInfoListener;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
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
                .url(url)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new ShopInfoRequestCallback());
    }


    public class ShopInfoRequestCallback extends Callback<ShopInfoBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public ShopInfoBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            ShopInfoBean shopInfoBean = new Gson().fromJson(string, ShopInfoBean.class);
            return shopInfoBean;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(ShopInfoBean response) {
            mShopInfoListener.onSuccess(response);
        }
    }

    @Override
    public void getShopImages(String url) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new ShopDetailCallback());
    }


    public class ShopDetailCallback extends StringCallback {
        @Override
        public void onBefore(Request request) {
            super.onBefore(request);
        }

        @Override
        public void onAfter() {
            super.onAfter();
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void inProgress(float progress) {

        }

        @Override
        public void onResponse(String response) {
            Document doc = Jsoup.parse(response.toString());
            Elements el = doc.getElementsByClass("envt");


            String href = el.attr("href");


            Log.e("Main", href.toString());
            getShopImage(href.toString());
        }

    }

    private void getShopImage(String url) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new ShopImageStringCallback());
    }

    public class ShopImageStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request) {
            super.onBefore(request);
        }

        @Override
        public void onAfter() {
            super.onAfter();
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void inProgress(float progress) {

        }

        @Override
        public void onResponse(String response) {
            ArrayList<ShopImage> shopImages = new ArrayList<>();
            Document doc = Jsoup.parse(response.toString());
            Elements el = doc.getElementsByClass("bulk_order_details").select("img");
            for (int i = 0; i < el.size(); i++) {
                Element element = el.get(i);
                String url = element.attr("src");
                Log.e("Main", "第" + i + "个   " + url.toString());

                shopImages.add(new ShopImage(url.toString()));
            }
            mShopInfoListener.onShopImageData(shopImages);
        }

    }
}
