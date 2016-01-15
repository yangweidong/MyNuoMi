package com.onenews.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.onenews.R;
import com.onenews.bean.SharChdeals;

public class ShopInfoActivity extends BaseActivity {

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
        setContentView(R.layout.activity_shop_info);

        final String murl = getIntent().getStringExtra("murl");

        final WebView mywebview = (WebView) findViewById(R.id.mywebview);
        mywebview.loadUrl(murl);

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(SharChdeals response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }
}
