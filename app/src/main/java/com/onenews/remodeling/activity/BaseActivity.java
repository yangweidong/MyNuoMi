package com.onenews.remodeling.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.onenews.R;
import com.onenews.remodeling.widgets.MultiStateView;


/**
 * Created by yangweidong on 15/12/31.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private MultiStateView rootLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS |
                    localLayoutParams.flags);
        }

        if (getLayout() == 0) {
            throw new RuntimeException(this.toString()
                    + " not layout Res");
        }

        super.setContentView(R.layout.activity_base_remodeling);
        initToolbar();


        rootLayout = (MultiStateView) findViewById(R.id.layout);
        if (rootLayout == null) {
            return;
        } else {
            //TODO rootview 未改
            rootLayout.addView(View.inflate(this, getLayout(), null));
        }
        rootLayout.setViewState(MultiStateView.VIEW_STATE_LOADING);
        initView();
        initData();
        getData();
    }

    Toolbar mToolbar;
    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

    public void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    public Toolbar getTollbar() {
        return mToolbar;
    }

    /**
     * 显示内容布局
     */
    protected void displayContentView() {
        rootLayout.setViewState(MultiStateView.VIEW_STATE_CONTENT);
    }

    /**
     * 显示错误布局
     */
    protected void displayErrorView() {
        rootLayout.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }

    /**
     * 显示空布局
     */
    protected void displayEmptyView() {
        rootLayout.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }

    /**
     * 显示加载布局
     */
    protected void displayLoadingView() {
        rootLayout.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }


    protected abstract int getLayout();

    protected abstract void initView();

    /**
     *
     */
    protected void initData() {
    }


    protected abstract void getData();


}
