package com.onenews.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.onenews.R;
import com.onenews.widgets.recyclerview.XRecyclerView;

/**
 * Created by yangweidong on 16/1/20.
 */
public abstract class BaseShopInfoFragment<T> extends BaseFragment<T> {
    String shopId;
    XRecyclerView mXRecyclerView;

    @Override
    int getLayout() {
        return R.layout.fragment_base_shop_info;
    }

    @Override
    void initData() {
        if (null != getArguments()) {
            shopId = getArguments().getString("shopid");
        }
//        Toast.makeText(getActivity(), "shopId " + shopId, Toast.LENGTH_SHORT).show();
    }

    @Override
    void initView(View view) {
        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.xrl);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setPullRefreshEnabled(false);

    }


}
