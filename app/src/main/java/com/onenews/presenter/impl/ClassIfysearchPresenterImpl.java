package com.onenews.presenter.impl;

import com.onenews.bean.DistrictBean;
import com.onenews.bean.HomeShop;
import com.onenews.model.ClassIfysearchModel;
import com.onenews.model.impl.ClassIfysearchModelImpl;
import com.onenews.presenter.ClassIfysearchPresenter;
import com.onenews.presenter.OnClassIfysearchListener;
import com.onenews.test.ChildItem;
import com.onenews.test.ClassIfyBean;
import com.onenews.test.FatherItem;
import com.onenews.utils.LL;
import com.onenews.view.ClassIfySearchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/15.
 */
public class ClassIfysearchPresenterImpl implements ClassIfysearchPresenter, OnClassIfysearchListener {

    private ClassIfySearchView mBaseView;
    private ClassIfysearchModel mClassIfysearchModel;


    public ClassIfysearchPresenterImpl(ClassIfySearchView mBaseView) {
        this.mBaseView = mBaseView;
        mClassIfysearchModel = new ClassIfysearchModelImpl();
    }

    @Override
    public void loadBusiness(String url, Map<String, String> params) {
        mClassIfysearchModel.getData(url, params, this);
    }

    @Override
    public void loadDistricts(String url, Map<String, String> params) {
        // TODO: 16/1/18 如果一个界面中有两个请求,那么请求成功回调的参数
        mClassIfysearchModel.getDistricts(url, params, this);

    }

    List<FatherItem> mRegionDataBeens = new ArrayList<>();


    @Override
    public void onSuccess(HomeShop response) {

        mBaseView.addData(response);

    }

    @Override
    public void onFailure(String msg, Exception e) {

    }

    @Override
    public void getDistrictSuccess(DistrictBean response) {


//        if (response.getErrno() == 1001) {
//            Toast.makeText(ClassIfySearchActivSity.this, "没有数据", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (response.getErrno() == 1002) {
//            Toast.makeText(ClassIfySearchActivSity.this, "参数错误", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (response.getErrno() == 1003) {
//            Toast.makeText(ClassIfySearchActivSity.this, "缺失必须参数", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (response.getErrno() == 1004) {
//            Toast.makeText(ClassIfySearchActivSity.this, "认证未通过", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (response.getErrno() == 1005) {
//            Toast.makeText(ClassIfySearchActivSity.this, "获取数据为空", Toast.LENGTH_SHORT).show();
//            return;
//        }


        LL.e("PresenterImpl列表数据来了" + response.toString());


        for (int i = 0; i < response.getDistricts().size(); i++) {


            ClassIfyBean fatherItem = new ClassIfyBean();

            fatherItem.setCat_id(response.getDistricts().get(i).getDistrict_id());
            fatherItem.setmFatherName(response.getDistricts().get(i).getDistrict_name());
            List<ChildItem> childItems = new ArrayList<ChildItem>();

            for (int y = 0; y < response.getDistricts().get(i).getBiz_areas().size(); y++) {

                ChildItem childItem = new ChildItem();
                childItem.setSubcat_id(response.getDistricts().get(i).getBiz_areas().get(y).getBiz_area_id());
                childItem.setSubcat_name(response.getDistricts().get(i).getBiz_areas().get(y).getBiz_area_name());
                childItem.setmDistrict_ids(response.getDistricts().get(i).getDistrict_id() + "");
                childItems.add(childItem);

            }
            fatherItem.setChildItems(childItems);
            mRegionDataBeens.add(fatherItem);

        }


        mBaseView.addDistricts(mRegionDataBeens);


//        mCityDatas.clear();
//        for (int i = 0; i < cityBeen.getCities().size(); i++) {
//            CityBean cityBean = new CityBean();
//            cityBean.setmFatherName(cityBeen.getCities().get(i).getCity_name());
//            cityBean.setCityId(cityBeen.getCities().get(i).getCity_id());
//            mCityDatas.add(cityBean);
//        }
//        mBaseView.addDistricts(mCityDatas);
    }
}
