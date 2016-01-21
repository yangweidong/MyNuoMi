package com.onenews.fragment;

import android.view.View;
import android.widget.TextView;

import com.onenews.R;
import com.onenews.activity.ShopImage;
import com.onenews.adapter.ShopInfoAdapter;
import com.onenews.bean.ShopInfoBean;
import com.onenews.http.Api;
import com.onenews.presenter.ShopInfoPresenter;
import com.onenews.presenter.impl.ShopInfoPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopInfoFragment extends BaseShopInfoFragment<ShopInfoBean> {
    ShopInfoPresenter mShopInfoPresenter;
    private ShopInfoAdapter mAdapter;

    private List<ShopImage> shopImages = new ArrayList<>();



    @Override
    void initData() {

    }

    @Override
    void initView(View view) {
        super.initView(view);
        mShopInfoPresenter = new ShopInfoPresenterImpl(this);


        mAdapter = new ShopInfoAdapter(shopImages);
        View header = View.inflate(getActivity(), R.layout.shop_info_header_item, null);
        TextView shopname_tv = (TextView) header.findViewById(R.id.shopname_tv);
        TextView shopphone_tv = (TextView) header.findViewById(R.id.shopphone_tv);
        TextView shopaddress_tv = (TextView) header.findViewById(R.id.shopaddress_tv);

        mXRecyclerView.addHeaderView(header);
        mXRecyclerView.setPullRefreshEnabled(false);
        mXRecyclerView.setAdapter(mAdapter);
    }


    @Override
    void getData() {
        Map<String, String> params = new HashMap<>();
        params.put("", "");
        mShopInfoPresenter.getShopInfo(Api.SHOP_INFO, params);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(ShopInfoBean response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }
}
