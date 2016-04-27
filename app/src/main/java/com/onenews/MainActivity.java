package com.onenews;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.onenews.activity.CityActivity;
import com.onenews.activity.SettingsActivity;
import com.onenews.adapter.MainFragmentAdapter;
import com.onenews.fragment.FlauntFragment;
import com.onenews.fragment.HomeFragment;
import com.onenews.fragment.PersonalCenterFragment;
import com.onenews.fragment.TestFragment;
import com.onenews.home.FlauntPresenter;
import com.onenews.home.HomePresenter;
import com.onenews.remodeling.activity.BaseActivity;
import com.onenews.utils.LL;
import com.onenews.widgets.tab.MainBottomTabLayout;

public class MainActivity extends BaseActivity implements View
        .OnClickListener {
    private MainFragmentAdapter mMainFragmentAdapter;
    private ViewPager mViewPager;
    private MainBottomTabLayout mTabLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        displayContentView();
        setupViews();
    }


    private void setupViews() {
        mMainFragmentAdapter = new MainFragmentAdapter(getSupportFragmentManager());
        //1
        HomeFragment homeFragment = HomeFragment.newInstance();
        HomePresenter homePresenter = new HomePresenter(homeFragment);
        mMainFragmentAdapter.addFrag(homeFragment);
        //2
        FlauntFragment flauntFragment = FlauntFragment.newInstance();
        mMainFragmentAdapter.addFrag(flauntFragment);
        FlauntPresenter flauntPresenter = new FlauntPresenter(flauntFragment);

        mMainFragmentAdapter.addFrag(new TestFragment());
        mMainFragmentAdapter.addFrag(new PersonalCenterFragment());

        mViewPager = (ViewPager) findViewById(R.id.tab_pager);
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mMainFragmentAdapter);
        mTabLayout = (MainBottomTabLayout) findViewById(R.id.main_bottom_tablayout);
        mTabLayout.setViewPager(mViewPager);


        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LL.e(position + "");
                if (position == 3) {
                    getTollbar().getMenu().findItem(R.id.action_settings).setVisible(true);
//                    mToolbar.findViewById(R.id.action_settings).setVisibility(View.VISIBLE);
                } else {
                    getTollbar().getMenu().findItem(R.id.action_settings).setVisible(false);
//                    mToolbar.findViewById(R.id.action_settings).setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_city:
                intent = new Intent(MainActivity.this, CityActivity.class);
                startActivityForResult(intent, 1002);
                break;
            case R.id.action_settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 为了让 Toolbar 的 Menu 有作用
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void getData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 1002) {

            App.mCityID = data.getStringExtra("cityID");
            String cityName = data.getStringExtra("cityName");
            String cityPinyin = data.getStringExtra("cityPinyin");
            String cityShortName = data.getStringExtra("cityShortName");
            String cityShortPinyin = data.getStringExtra("cityShortPinyin");
            LL.e("" + App.mCityID + cityName + cityPinyin + cityShortName + cityShortPinyin);
            getTollbar().getMenu().findItem(R.id.action_city).setTitle(cityName + "");
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
