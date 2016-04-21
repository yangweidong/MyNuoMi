package com.onenews.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onenews.view.BaseView;

/**
 * Created by yangweidong on 16/1/13.
 */
public abstract class BaseFragment<T> extends Fragment implements BaseView<T> {
    abstract int getLayout();

    abstract void initData();

    abstract void initView(View view);

    abstract void getData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {
        return inflater.inflate(getLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
        getData();
    }
}
