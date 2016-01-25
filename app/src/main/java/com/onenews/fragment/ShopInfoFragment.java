package com.onenews.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.onenews.R;
import com.onenews.activity.ShopImage;
import com.onenews.adapter.ShopInfoAdapter;
import com.onenews.bean.ShopInfoBean;
import com.onenews.http.Api;
import com.onenews.presenter.ShopInfoPresenter;
import com.onenews.presenter.impl.ShopInfoPresenterImpl;
import com.onenews.utils.LL;
import com.onenews.view.ShopInfoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopInfoFragment extends BaseShopInfoFragment<ShopInfoBean> implements ShopInfoView<ShopInfoBean> {
    ShopInfoPresenter mShopInfoPresenter;
    private ShopInfoAdapter mShopImageAdapter;

    private List<ShopImage> mShopImages = new ArrayList<>();

    TextView shopname_tv;
    TextView shopphone_tv;
    TextView shopaddress_tv;

    public interface UpShopHeaderBg {
        public void onUpBg(String imageUrl);
    }

    private UpShopHeaderBg mUpShopHeaderBg;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mUpShopHeaderBg = (UpShopHeaderBg) context;

    }

    @Override
    void initView(View view) {
        super.initView(view);
        mShopInfoPresenter = new ShopInfoPresenterImpl(this);


        mShopImageAdapter = new ShopInfoAdapter(mShopImages);
        View header = View.inflate(getActivity(), R.layout.shop_info_header_item, null);
        shopname_tv = (TextView) header.findViewById(R.id.shopname_tv);
        shopphone_tv = (TextView) header.findViewById(R.id.shopphone_tv);
        shopaddress_tv = (TextView) header.findViewById(R.id.shopaddress_tv);

        mXRecyclerView.addHeaderView(header);
        mXRecyclerView.setPullRefreshEnabled(false);
        mXRecyclerView.setAdapter(mShopImageAdapter);
    }


    @Override
    void getData() {
        Map<String, String> params = new HashMap<>();
        params.put("shop_id", shopId);
        mShopInfoPresenter.getShopInfo(Api.SHOP_INFO, params);

        //mShopInfoPresenter.getShopImage(shopId);
    }

    @Override
    public void showProgress() {

    }


    @Override
    public void addData(ShopInfoBean response) {
        LL.e(response.toString());

        shopname_tv.setText(response.getShop().getShop_name());
        shopphone_tv.setText("联系方式:   " + response.getShop().getPhone());
        shopaddress_tv.setText("地址:   " + response.getShop().getAddress());

        mShopInfoPresenter.getShopImage(response.getShop().getShop_murl());

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }

    @Override
    public void addShopImage(List<ShopImage> shopImages) {
        mShopImages.addAll(shopImages);
        mShopImageAdapter.notifyDataSetChanged();

        if (!mShopImages.isEmpty()) {
            mUpShopHeaderBg.onUpBg(mShopImages.get(0).getImageurl());

        }
    }
}
