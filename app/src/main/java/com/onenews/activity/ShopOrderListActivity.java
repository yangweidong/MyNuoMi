package com.onenews.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.onenews.R;
import com.onenews.bean.ShopOrderListBean;
import com.onenews.fragment.EvaluateFragment;
import com.onenews.fragment.ShopInfoFragment;
import com.onenews.fragment.ShopOrderListFragment;

import java.util.ArrayList;
import java.util.List;

public class ShopOrderListActivity extends BaseActivity<ShopOrderListBean> {
    String mShopId;
    String mTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_shop_order_list;
    }

    @Override
    protected void initData() {
        mShopId = getIntent().getStringExtra("shopID");
        mTitle = getIntent().getStringExtra("title");
    }

    @Override
    protected void initView() {


        //init ViewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ShopOrderListFragment(), "订单列表");
        adapter.addFrag(new ShopInfoFragment(), "商家信息");
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
        getSupportActionBar().setTitle(mTitle + "");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
