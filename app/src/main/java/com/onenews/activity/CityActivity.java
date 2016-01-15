package com.onenews.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.onenews.R;
import com.onenews.adapter.CityAdapter;
import com.onenews.bean.CityBean;
import com.onenews.bean.SharChdeals;
import com.onenews.http.Api;
import com.onenews.utils.L;
import com.onenews.widgets.DividerItemDecoration;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityActivity extends BaseActivity {
    RecyclerView city_rl;
    List<CityBean.CitiesEntity> mCitiesEntity = new ArrayList<>();
    CityAdapter mCityAdapter;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        city_rl = (RecyclerView) findViewById(R.id.city_rl);
        city_rl.setLayoutManager(new LinearLayoutManager(this));
        city_rl.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mCityAdapter = new CityAdapter(CityActivity.this,mCitiesEntity);
        mCityAdapter.setOnItemClickListener(new CityAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(CityActivity.this,""+mCitiesEntity.get(postion).getCity_name(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CityActivity.this,RegionActivity.class);
                CityBean.CitiesEntity citiesEntity = mCitiesEntity.get(postion);
                intent.putExtra("cityID",citiesEntity.getCity_id());
                intent.putExtra("cityName",citiesEntity.getCity_name());
                intent.putExtra("cityPinyin",citiesEntity.getCity_pinyin());
                intent.putExtra("cityShortName",citiesEntity.getShort_name());
                intent.putExtra("cityShortPinyin",citiesEntity.getShort_pinyin());
                startActivity(intent);
            }
        });
        city_rl.setAdapter(mCityAdapter);
        getCitys();
    }


    private void getCitys() {

        OkHttpUtils
                .get()
                .url(Api.CITYS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .build()
                .execute(new UserCallback());
    }


    public class UserCallback extends Callback<CityBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public CityBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            CityBean user = new Gson().fromJson(string, CityBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(CityBean response) {
            L.e(response.toString());
//            mCitiesEntity = response.getCities();
            mCitiesEntity.addAll(response.getCities());
            mCityAdapter.notifyDataSetChanged();
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
