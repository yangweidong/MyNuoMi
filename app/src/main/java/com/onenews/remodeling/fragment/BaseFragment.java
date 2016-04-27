package com.onenews.remodeling.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onenews.R;
import com.onenews.remodeling.widgets.MultiStateView;

/**
 * Created by yangweidong on 16/1/13.
 */
public abstract class BaseFragment<T> extends Fragment {
    protected abstract int getLayoutId();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract void getData();

    MultiStateView mMultiStateView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
    Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_root, container, false);
        mMultiStateView = (MultiStateView) rootview.findViewById(R.id.layout);
        mMultiStateView.addView(View.inflate(getActivity(), getLayoutId(), null));
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initView(view);
        getData();
    }

    /**
     * 显示加载布局
     */
    protected void displayLoadingView() {
        mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }

    /**
     * 显示内容布局
     */
    protected void displayContentView() {
        mMultiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
    }

    /**
     * 显示空布局
     */
    protected void displayEmptyView() {
        mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }

    /**
     * 显示错误布局
     */
    protected void displayErrorView() {
        mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
    }


}
