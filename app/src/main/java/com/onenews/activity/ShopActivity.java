package com.onenews.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.adapter.ShopInfoViewPager;
import com.onenews.bean.ShopOrderListBean;
import com.onenews.fragment.EvaluateFragment;
import com.onenews.fragment.ShopInfoFragment;
import com.onenews.fragment.ShopOrderListFragment;

public class ShopActivity extends BaseActivity<ShopOrderListBean> implements View.OnClickListener, ShopInfoFragment.UpShopHeaderBg {
    String mShopId;
    String mTitle;
    SimpleDraweeView header_image;
    @Override
    protected int getLayout() {
        return R.layout.activity_shop;
    }

    @Override
    protected void initData() {
        mShopId = getIntent().getStringExtra("shopid");
        mTitle = getIntent().getStringExtra("title");
    }

    @Override
    protected void initView() {

        header_image = (SimpleDraweeView) findViewById(R.id.header_image);

        //init ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ShopInfoViewPager adapter = new ShopInfoViewPager(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);

        Bundle bundle = new Bundle();
        bundle.putString("shopid", mShopId + "");


        ShopOrderListFragment shopOrderListFragment = new ShopOrderListFragment();
        shopOrderListFragment.setArguments(bundle);


        ShopInfoFragment shopInfoFragment = new ShopInfoFragment();
        shopInfoFragment.setArguments(bundle);


        EvaluateFragment evaluateFragment = new EvaluateFragment();
        evaluateFragment.setArguments(bundle);

        adapter.addFrag(shopOrderListFragment, "订单列表");
        adapter.addFrag(shopInfoFragment, "商家信息");
        adapter.addFrag(evaluateFragment, "评价");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        //iinit CollapsingToolbarLayout
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(
                R.id.collapse_toolbar);
        collapsingToolbar.setTitleEnabled(false);


        //init Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle(mTitle + "");
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShopActivity.this.finish();
            }
        });
    }

    @Override
    public boolean isAddToolbar() {
        return false;
    }

    @Override
    protected void getData() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(ShopOrderListBean response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }

    @Override
    public void onClick(View v) {
    }


    @Override
    public void onUpBg(String imageUrl) {
        Uri uri = Uri.parse(imageUrl);
        header_image.setImageURI(uri);
    }
}
