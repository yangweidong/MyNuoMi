package com.onenews.activity;

import android.webkit.WebView;

import com.onenews.R;

public class ShopInfoActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_shop_info;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        final String murl = getIntent().getStringExtra("murl");
        final WebView mywebview = (WebView) findViewById(R.id.mywebview);
        mywebview.loadUrl(murl);
    }

    @Override
    protected void getData() {

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
