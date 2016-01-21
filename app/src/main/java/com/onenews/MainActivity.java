package com.onenews;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.onenews.activity.BaseActivity;
import com.onenews.fragment.HomeFragment;
import com.onenews.presenter.MainPresenter;
import com.onenews.presenter.impl.MainPresenterImpl;
import com.onenews.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private MainPresenter mMainPresenter;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(mToolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        setupDrawerContent(mNavigationView);

        mMainPresenter = new MainPresenterImpl(this);

        showShoppingPage();
    }

    @Override
    protected void getData() {

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


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        if (resultCode == 333) {
//
//            String cityID = data.getStringExtra("cityID");
//            String cityName = data.getStringExtra("cityName");
//            String cityPinyin = data.getStringExtra("cityPinyin");
//            String cityShortName = data.getStringExtra("cityShortName");
//            String cityShortPinyin = data.getStringExtra("cityShortPinyin");
//
//            L.e("" + cityID + cityName);
//
//        }
//
//        super.onActivityResult(requestCode, resultCode, data);
//    }


    @Override
    public void showShoppingPage() {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, HomeFragment.newInstance()).commit();
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
