package com.onenews.fragment;

import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.view.View;

import com.onenews.R;
import com.onenews.activity.OrderDetailsActivity;
import com.onenews.adapter.ShopOrderListFragmentAdapter;
import com.onenews.bean.ShopOrderListBean;
import com.onenews.http.Api;
import com.onenews.presenter.ShopOrderListPresenter;
import com.onenews.presenter.impl.ShopOrderListPresenterImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopOrderListFragment extends BaseShopInfoFragment<ShopOrderListBean> implements ShopOrderListFragmentAdapter.ShopOrderRlItemClickListener {
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

        mAdapter.setOnItemClickListener(this);
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
    public void shoError(String msg) {
    }
    @Override
    public void onItemClick(View view, int postion) {
        //Toast.makeText(getActivity(), "" + postion, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), OrderDetailsActivity.class);
        String order = mShopOrderListBeans.get(postion - 1).getDeal_id() + "";
        intent.putExtra("orderid", order);
        startActivity(intent);
    }


}
