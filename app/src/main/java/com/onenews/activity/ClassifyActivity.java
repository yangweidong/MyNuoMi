package com.onenews.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.onenews.adapter.ClassIfyAdapter;
import com.onenews.bean.ClassifyBean;
import com.onenews.http.Api;
import com.onenews.utils.LL;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClassifyActivity extends ListActivity {
    List<ClassifyBean.CategoriesEntity> mClassifyBeen = new ArrayList<>();
    ClassIfyAdapter mClassIfyAdapter;

    @Override
    void setRecyclerViewStyle(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new GridLayoutManager(ClassifyActivity.this,2));
    }

    @Override
    RecyclerView.Adapter getAdapter() {
        mClassIfyAdapter = new ClassIfyAdapter(this, mClassifyBeen);

        return mClassIfyAdapter;
    }

    @Override
    void init() {
        getClassIfy();

        mClassIfyAdapter.setOnItemClickListener(new ClassIfyAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(ClassifyActivity.this,"postion",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getClassIfy() {
        OkHttpUtils.get().url(Api.CLASSIFY).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new ClassifyCallback());

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
            LL.e(response.toString());
//            mCitiesEntity = response.getCities();
            mClassifyBeen.addAll(response.getCategories());
            mClassIfyAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(Object response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }

}
