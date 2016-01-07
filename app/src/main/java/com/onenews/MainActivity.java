package com.onenews;

import android.content.Intent;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.google.gson.Gson;
import com.onenews.activity.BaseActivity;
import com.onenews.activity.CityActivity;
import com.onenews.adapter.SharChdealsAdapter;
import com.onenews.bean.CityBean;
import com.onenews.bean.ClassifyBean;
import com.onenews.bean.SharChdeals;
import com.onenews.http.Api;
import com.onenews.test.ChildItem;
import com.onenews.test.ClassIfyBean;
import com.onenews.test.FatherItem;
import com.onenews.utils.L;
import com.onenews.widgets.LinkageView;
import com.onenews.widgets.LinkageView2;
import com.onenews.widgets.MyPopupWindow;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    RecyclerView mMainRecyclerView;

    SharChdealsAdapter mSharChdealsAdapter;

    Button getClassify;
    Button getDistricts;

    List<SharChdeals.DataEntity.DealsEntity> mSharChdealBeens = new ArrayList<>();
    List<ClassIfyBean> mDataBeens = new ArrayList<>();
    List<ClassifyBean.CategoriesEntity> mClassifyBeen = new ArrayList<>();
    MyPopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button getCitys = (Button) findViewById(R.id.getCitys);
        mMainRecyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);
        getCitys.setOnClickListener(this);

        getClassify = (Button) findViewById(R.id.getClassify);
        getDistricts = (Button) findViewById(R.id.getDistricts);


        getDistricts.setOnClickListener(this);
//                Intent intent = new Intent(MainActivity.this, ClassifyActivity.class);
//                startActivityForResult(intent, 333);
        getClassify.setOnClickListener(this);

        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSharChdealsAdapter = new SharChdealsAdapter(this, mSharChdealBeens);
        mMainRecyclerView.setAdapter(mSharChdealsAdapter);

        popupWindow = new MyPopupWindow(this, ViewGroup.LayoutParams.MATCH_PARENT, (App.getScreenHeight() / 2));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getCitys:
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                startActivityForResult(intent, 333);
                break;
            case R.id.getClassify:
                popupWindow.getContent().setmOnRightItemClickCallback(new LinkageView.OnRightItemClickCallback() {
                    @Override
                    public void onItemClick(ChildItem subcategoriesEntity, int postion) {
                        L.e("哈哈哈" + subcategoriesEntity.toString() + " " + postion);
                        if (popupWindow.isShowing()) {
                            popupWindow.dismiss();
                        }
                        OkHttpUtils.get().url(Api.SEARCHDEALS).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").addParams("city_id", "100010000").addParams("subcat_ids", subcategoriesEntity.getSubcat_id() + "").build().execute(new SharChdealsCallback());
                    }
                });
                getClassIfy();
                break;
            case R.id.getDistricts:
                getCitys();

                content2.setmOnRightItemClickCallback(new LinkageView2.OnRightItemClickCallback() {
                    @Override
                    public void onItemClick(ChildItem subcategoriesEntity, int postion) {

                    }
                });
                break;


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 333) {

            String cityID = data.getStringExtra("cityID");
            String cityName = data.getStringExtra("cityName");
            String cityPinyin = data.getStringExtra("cityPinyin");
            String cityShortName = data.getStringExtra("cityShortName");
            String cityShortPinyin = data.getStringExtra("cityShortPinyin");

            L.e("" + cityID + cityName);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void getClassIfy() {
        OkHttpUtils.get().url(Api.CLASSIFY).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new ClassifyCallback());
        showDialog();
    }

    public class SharChdealsCallback extends Callback<SharChdeals> {
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
            L.e("获得" + response.toString());
//            mCitiesEntity = response.getCities();
            // mClassifyBeen.addAll(response.getCategories());
            // mLeftAdapter.notifyDataSetChanged();
            mSharChdealBeens.addAll(response.getData().getDeals());

            mSharChdealsAdapter.notifyDataSetChanged();

        }
    }


    public class ClassifyCallback extends Callback<ClassifyBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public ClassifyBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            ClassifyBean user = new Gson().fromJson(string, ClassifyBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(ClassifyBean response) {
            L.e("哈哈哈" + response.toString());
            mDataBeens.clear();
//            mCitiesEntity = response.getCities();
            // mClassifyBeen.addAll(response.getCategories());
            // mLeftAdapter.notifyDataSetChanged();


            for (int i = 0; i < response.getCategories().size(); i++) {


                ClassIfyBean fatherItem = new ClassIfyBean();

                fatherItem.setCat_id(response.getCategories().get(i).getCat_id());
                fatherItem.setmFatherName(response.getCategories().get(i).getCat_name());
                List<ChildItem> subcategoriesEntitys = new ArrayList<ChildItem>();

                for (int y = 0; y < response.getCategories().get(i).getSubcategories().size(); y++) {

                    ChildItem subcategoriesEntity = new ChildItem();
                    subcategoriesEntity.setSubcat_id(response.getCategories().get(i).getSubcategories().get(y).getSubcat_id());
                    subcategoriesEntity.setSubcat_name(response.getCategories().get(i).getSubcategories().get(y).getSubcat_name());

                    subcategoriesEntitys.add(subcategoriesEntity);

                }
                fatherItem.setChildItems(subcategoriesEntitys);
                mDataBeens.add(fatherItem);

            }

            L.e("呵呵呵呵呵");


            popupWindow.setData(mDataBeens);

        }
    }


    private void showDialog() {


        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View contentview = inflater.inflate(R.layout.activity_test, null);


        popupWindow.showAsDropDown(getClassify, 0, 0);

    }

    LinkageView2 content2;
    private void getCitys() {

        OkHttpUtils
                .get()
                .url(Api.CITYS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .build()
                .execute(new CityCallback() );

        content2 = new LinkageView2(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        content2.setLayoutParams(layoutParams);
//        content = (LinkageView<List<FatherItem>>) contentview.findViewById(R.id.content);
        content2.setFocusable(true); // 这个很重要
        content2.setFocusableInTouchMode(true);


        PopupWindow popupWindow = new PopupWindow(content2, ViewGroup.LayoutParams.MATCH_PARENT, (App.getScreenHeight() / 2));

        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new PaintDrawable());
        popupWindow.setOutsideTouchable(true);

        popupWindow.showAsDropDown(getClassify, 0, 0);
    }

    List<CityBean> mCityDatas = new ArrayList<>();


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
            L.e(response.toString());
            mCityDatas.clear();


            for (int i = 0; i < response.getCities().size(); i++) {
                CityBean cityBean = new CityBean();
                cityBean.setmFatherName(response.getCities().get(i).getCity_name());
                mCityDatas.add(cityBean);
            }

            content2.setFatherData(mCityDatas);


//            mCitiesEntity = response.getCities();
            //mCitiesEntity.addAll(response.getCities());
            //mCityAdapter.notifyDataSetChanged();
        }
    }

}
