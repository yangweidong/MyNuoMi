package com.onenews;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.onenews.activity.BaseActivity;
import com.onenews.activity.SettingsActivity;
import com.onenews.adapter.TestFragmentAdapter;
import com.onenews.fragment.FlauntFragment;
import com.onenews.fragment.HomeFragment;
import com.onenews.fragment.PersonalCenterFragment;
import com.onenews.fragment.TestFragment;
import com.onenews.home.FlauntPresenter;
import com.onenews.home.HomePresenter;
import com.onenews.presenter.MainPresenter;
import com.onenews.utils.LL;
import com.onenews.view.MainView;
import com.onenews.widgets.tab.MainBottomTabLayout;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private MainPresenter mMainPresenter;


    private TestFragmentAdapter mAdapter;
    private ViewPager mPager;
    private MainBottomTabLayout mTabLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

//        setContentView(R.layout.test);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//        setSupportActionBar(mToolbar);

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
//        mDrawerToggle.syncState();
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//
//        setupDrawerContent(mNavigationView);
//
//        mMainPresenter = new MainPresenterImpl(this);
//
//        showShoppingPage();
        setupViews();
    }




    private void setupViews() {
        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());
        //1
        HomeFragment homeFragment = HomeFragment.newInstance();
        HomePresenter homePresenter = new HomePresenter(homeFragment);
        mAdapter.addFrag(homeFragment);
        //2
        FlauntFragment flauntFragment = FlauntFragment.newInstance();
        mAdapter.addFrag(flauntFragment);
        FlauntPresenter flauntPresenter = new FlauntPresenter(flauntFragment);

        mAdapter.addFrag(new TestFragment());
        mAdapter.addFrag(new PersonalCenterFragment());

        mPager = (ViewPager) findViewById(R.id.tab_pager);
        mPager.setOffscreenPageLimit(4);
        mPager.setAdapter(mAdapter);
        mTabLayout = (MainBottomTabLayout) findViewById(R.id.main_bottom_tablayout);
        mTabLayout.setViewPager(mPager);


        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                LL.e(position + "");
                if (position == 3) {
                    mToolbar.getMenu().findItem(R.id.action_settings).setVisible(true);
//                    mToolbar.findViewById(R.id.action_settings).setVisibility(View.VISIBLE);
                } else {
                    mToolbar.getMenu().findItem(R.id.action_settings).setVisible(false);
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
                Toast.makeText(MainActivity.this, "点击城市", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, com.onenews.activity.TestActivity.class);
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
        // 為了讓 Toolbar 的 Menu 有作用，這邊的程式不可以拿掉
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

            mToolbar.getMenu().findItem(R.id.action_city).setTitle(cityName + "");

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        mMainPresenter.switchNavigation(menuItem.getItemId());
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void showShoppingPage() {
        // getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, HomeFragment.newInstance()).commit();
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}
