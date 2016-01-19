package com.onenews.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.onenews.view.BaseView;

/**
 * Created by yangweidong on 15/12/31.
 */
public abstract class BaseActivity<T> extends AppCompatActivity implements BaseView<T> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getLayout() == 0) {
            throw new RuntimeException(this.toString()
                    + " not layout Res");
        }


        setContentView(getLayout());
        initData();
        initView();
        getData();
    }

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void getData();


}
