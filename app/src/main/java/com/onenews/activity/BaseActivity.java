package com.onenews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onenews.view.BaseView;

/**
 * Created by yangweidong on 15/12/31.
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initData();
        initView();
        getData();
    }
}
