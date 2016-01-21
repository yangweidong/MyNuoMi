package com.onenews.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.onenews.R;
import com.onenews.bean.ShopOrderListBean;
import com.onenews.fragment.EvaluateFragment;
import com.onenews.fragment.ShopInfoFragment;
import com.onenews.fragment.ShopOrderListFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends BaseActivity<ShopOrderListBean> implements View.OnClickListener {
    String mShopId;
    String mTitle;

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

        //init ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        ShopOrderListFragment shopOrderListFragment = new ShopOrderListFragment();
        Bundle shopOrderListFragmentBundle = new Bundle();
        shopOrderListFragmentBundle.putString("shopid", mShopId + "");
        shopOrderListFragment.setArguments(shopOrderListFragmentBundle);


        ShopInfoFragment shopInfoFragment = new ShopInfoFragment();
        shopInfoFragment.setArguments(shopOrderListFragmentBundle);

        adapter.addFrag(shopOrderListFragment, "订单列表");
        adapter.addFrag(shopInfoFragment, "商家信息");
        adapter.addFrag(new EvaluateFragment(), "评价");
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


    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
