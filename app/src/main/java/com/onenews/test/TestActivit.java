package com.onenews.test;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.onenews.R;
import com.onenews.activity.BaseActivity;
import com.onenews.adapter.ClassIfyAdapter;
import com.onenews.bean.ClassifyBean;
import com.onenews.http.Api;
import com.onenews.utils.LL;
import com.onenews.widgets.LinkageView;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestActivit extends BaseActivity {

    RecyclerView left;
    RecyclerView right;
    LinkageView linkageView;

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
        setContentView(R.layout.activity_test);

        getClassIfy();
    }


    List<ClassifyBean.CategoriesEntity.SubcategoriesEntity> subcategories = new ArrayList<>();

    List<ClassifyBean.CategoriesEntity> mClassifyBeen = new ArrayList<>();
    List<String> mRights = new ArrayList<>();
    ClassIfyAdapter mLeftAdapter;
    RightAdapter mRightAdapter;

    private void getClassIfy() {
        OkHttpUtils.get().url(Api.CLASSIFY).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new ClassifyCallback());

    }

    List<FatherItem> mDataBeens = new ArrayList<>();

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
            LL.e("哈哈哈" + response.toString());
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

            LL.e("呵呵呵呵呵");

//            linkageView.setData(mDataBeens);

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
    public void shoError(String msg) {

    }
}
