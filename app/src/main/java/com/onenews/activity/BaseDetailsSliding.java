package com.onenews.activity;

import android.os.Bundle;

import com.onenews.view.BaseView;
import com.onenews.widgets.sliding.SlidingActivity;

/**
 * Created by yangweidong on 16/1/26.
 */
public abstract class BaseDetailsSliding<T> extends SlidingActivity implements BaseView<T> {

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle("订单详情");
        setContent(getLayout());
//        setImage(R.mipmap.ic_launcher);
        initData();
        initView();
        getData();
    }

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void getData();


}
