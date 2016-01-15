package com.onenews.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.onenews.adapter.RegionAdapter;
import com.onenews.bean.RegionBean;
import com.onenews.bean.SharChdeals;
import com.onenews.http.Api;
import com.onenews.utils.L;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegionActivity extends ListActivity {
    RegionAdapter mRegionAdapter;
    List<RegionBean.DistrictsEntity> mDistrictsEntities = new ArrayList<>();


    @Override
    void setRecyclerViewStyle(RecyclerView recyclerView) {

    }

    @Override
    RecyclerView.Adapter getAdapter() {
        mRegionAdapter = new RegionAdapter(RegionActivity.this,mDistrictsEntities);

        return mRegionAdapter;
    }

    @Override
    void init() {

        Intent intent = getIntent();
        String cityID = intent.getStringExtra("cityID");
        String cityName = intent.getStringExtra("cityName");
        String cityPinyin = intent.getStringExtra("cityPinyin");
        String cityShortName = intent.getStringExtra("cityShortName");
        String cityShortPinyin = intent.getStringExtra("cityShortPinyin");



        getRegionData(cityID);
    }


    public void getRegionData(String city_id) {

        OkHttpUtils.get().url(Api.DISTRICTS).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").addParams("city_id",city_id).build().execute(new RegionCallback());


    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getData() {

    }


    public class RegionCallback extends Callback<RegionBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public RegionBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            RegionBean user = new Gson().fromJson(string, RegionBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(RegionBean response) {
            L.e(response.toString());
//            mCitiesEntity = response.getCities();
            mDistrictsEntities.addAll(response.getDistricts());
            mRegionAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(SharChdeals response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }

}
