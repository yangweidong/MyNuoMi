package com.onenews.activity;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.onenews.R;
import com.onenews.adapter.CityAdapter;
import com.onenews.api.ApiUrl;
import com.onenews.bean.CityBean;
import com.onenews.utils.LL;
import com.onenews.widgets.DividerItemDecoration;
import com.onenews.widgets.NuoMiMaterialSearchView;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CityActivity extends com.onenews.remodeling.activity.BaseActivity {
    RecyclerView city_rl;
    List<CityBean.CitiesEntity> mCitiesEntity = new ArrayList<>();
    CityAdapter mCityAdapter;
    private NuoMiMaterialSearchView searchView;


    @Override
    protected int getLayout() {
        return R.layout.activity_city;
    }

    @Override
    protected void initData() {

    }

    String[] suggestions;


    @Override
    protected void initView() {

        city_rl = (RecyclerView) findViewById(R.id.city_rl);

        city_rl.setLayoutManager(new LinearLayoutManager(this));
        city_rl.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration
                .VERTICAL_LIST));
        mCityAdapter = new CityAdapter(CityActivity.this, mCitiesEntity);
        mCityAdapter.setOnItemClickListener(new CityAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(CityActivity.this, "" + mCitiesEntity.get(postion).getCity_name(),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                CityBean.CitiesEntity citiesEntity = mCitiesEntity.get(postion);
                intent.putExtra("cityID", citiesEntity.getCity_id());
                intent.putExtra("cityName", citiesEntity.getCity_name());
                intent.putExtra("cityPinyin", citiesEntity.getCity_pinyin());
                intent.putExtra("cityShortName", citiesEntity.getShort_name());
                intent.putExtra("cityShortPinyin", citiesEntity.getShort_pinyin());
                setResult(1002, intent);
                finish();
            }
        });
        city_rl.setAdapter(mCityAdapter);


        suggestions = new String[mCitiesEntity.size()];

        searchView = (NuoMiMaterialSearchView) findViewById(R.id.search_view);
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);
        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setmNuoMiOnItemClickListener(new NuoMiMaterialSearchView
                .NuoMiOnItemClickListener() {
            @Override
            public void onItemClick(String string) {
                if (searchView.isSearchOpen()) {
                    for (int i = 0; i < mCitiesEntity.size(); i++) {
                        if (string == null || string == "") {
                            return;
                        }

                        CityBean.CitiesEntity citiesEntity = mCitiesEntity.get(i);
                        if (string.equals(citiesEntity.getCity_name())) {
                            Intent intent = new Intent();
                            intent.putExtra("cityID", citiesEntity.getCity_id());
                            intent.putExtra("cityName", citiesEntity.getCity_name());
                            intent.putExtra("cityPinyin", citiesEntity.getCity_pinyin());
                            intent.putExtra("cityShortName", citiesEntity.getShort_name());
                            intent.putExtra("cityShortPinyin", citiesEntity.getShort_pinyin());
                            setResult(1002, intent);
                            finish();
                        }
                    }
                }
            }
        });

    }

    @Override
    protected void getData() {
        getCitys();

    }


    private void getCitys() {

        OkHttpUtils
                .get()
                .url(ApiUrl.CITYS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .build()
                .execute(new CityCallback());
    }


    public class CityCallback extends Callback<CityBean> {
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
            LL.e(response.toString());
//            mCitiesEntity = response.getCities();
            mCitiesEntity.addAll(response.getCities());
            mCityAdapter.notifyDataSetChanged();

            suggestions = new String[response.getCities().size()];
            for (int i = 0; i < response.getCities().size(); i++) {
                suggestions[i] = response.getCities().get(i).getCity_name();
            }
            searchView.setSuggestions(suggestions);
            displayContentView();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.city_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent
                    .EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
