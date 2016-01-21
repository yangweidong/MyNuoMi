package com.onenews.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.onenews.R;
import com.onenews.view.BaseView;

/**
 * Created by yangweidong on 15/12/31.
 */
public abstract class BaseActivity<T> extends AppCompatActivity implements BaseView<T> {
    private LinearLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 经测试在代码里直接声明透明状态栏更有效
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        if (getLayout() == 0) {
            throw new RuntimeException(this.toString()
                    + " not layout Res");
        }

        if (isAddToolbar()) {
            super.setContentView(R.layout.activity_base);
            rootLayout = (LinearLayout) findViewById(R.id.root_layout);
            if (rootLayout == null) return;
            rootLayout.addView(View.inflate(this, getLayout(), null), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            initToolbar();
        } else {
            setContentView(getLayout());
        }
        initData();
        initView();
        getData();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }


    /**
     * 是否显示Toolbar,如果需要定义自己的Toolbar,复写该方法,返回false
     *
     * @return
     */
    public boolean isAddToolbar() {
        return true;
    }


    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void getData();


}
