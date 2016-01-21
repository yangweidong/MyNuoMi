package com.onenews.fragment;

import android.view.View;

import com.onenews.adapter.ShopOrderListFragmentAdapter;
import com.onenews.bean.ShopOrderListBean;
import com.onenews.http.Api;
import com.onenews.presenter.ShopOrderListPresenter;
import com.onenews.presenter.impl.ShopOrderListPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopOrderListFragment extends BaseShopInfoFragment<ShopOrderListBean> {
    private ShopOrderListFragmentAdapter mAdapter;
    List<ShopOrderListBean.DealsEntity> mShopOrderListBeans = new ArrayList();
    ShopOrderListPresenter mShopOrderListPresenter;


    @Override
    void initView(View view) {
        super.initView(view);
        mShopOrderListPresenter = new ShopOrderListPresenterImpl(this);

//        mRecyclerView = (RecyclerView) view.findViewById(
//                R.id.fragment_list_rv);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerView.setLayoutManager(linearLayoutManager);
//        mRecyclerView.setHasFixedSize(true);
        mAdapter = new ShopOrderListFragmentAdapter(mShopOrderListBeans);
        mXRecyclerView.setAdapter(mAdapter);
    }

    @Override
    void getData() {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("shop_id", shopId);
        mShopOrderListPresenter.getShopOrderData(Api.SHOP_ORDER_LIST, parmas);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void addData(ShopOrderListBean response) {
        for (int i = 0; i < response.getDeals().size(); i++) {

            mShopOrderListBeans.add(response.getDeals().get(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }
}
