package com.onenews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.onenews.Constants;
import com.onenews.R;
import com.onenews.activity.ClassIfySearchActivity;
import com.onenews.adapter.HomeRlAdapter;
import com.onenews.adapter.HomeViewPagerAdapter;
import com.onenews.api.ApiUrl;
import com.onenews.base.adapter.BaseRlvAdapter;
import com.onenews.base.fragment.BaseRlvFragment;
import com.onenews.bean.SharChdeals;
import com.onenews.home.HomeContract;
import com.onenews.utils.Dip2Px;
import com.onenews.widgets.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//
public class HomeFragment extends BaseRlvFragment implements View.OnClickListener, HomeContract
        .View {
    XRecyclerView mHomeRl_View;
    HomeRlAdapter mHomeRl_Adapter;
    List<SharChdeals.DataEntity.DealsEntity> mHomeAdapterDatas = new ArrayList<>();
    HomeContract.Presenter mPresenter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initData() {

    }

    private String mSelectedCity_ID = "100010000";//城市ID
    private String mCat_ids = "";//分类的id，支持多个category合并查询， 多个一级分类用英文逗号,连接
    private String mSubcat_ids = "";//二级分类的id，支持多个subcategory合并查询， 多个二级分类用英文逗号,连接， 如1,2,3
    private String mDistrict_ids = "";//行政区id， 支持多个，多个区用英文逗号,连接
    private String mBizarea_ids = "";//商圈id, 支持多个查询， 多个商圈用,连接
    private String mLocation = "";//商圈id, 支持多个查询， 多个商圈用,连接
    private String mkeyword = "";//关键词，搜索商品名
    private String mRadius = "";//基于location,搜索的半径范围，单位是米。 可选（若传入该参数，必须同时传入合法的经纬度坐标，
    // radius字段默认半径3000米）
    private String mSort = "";//按照某种规则对返回的结果排序, 默认值为0。0:综合排序 1：价格低优先， 2：价格高优先， 3：折扣高优先， 4：销量高优先，
    // 5：用户坐标距离近优先， 6：最新发布优先,8:用户评分高优先
    private String mPage = "";//分页数据的页码, 如不传默认是1
    private String mPage_size = "20";//每页返回的团单结果条目数上限，最小值1，最大值50，如不传入默认为10
    private String mIs_reservation_required = "";//是否筛选出免预约,否: 默认不传 0为不筛选 1为筛选出支持免预约的团单

    @Override
    protected void getData() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("city_id", mSelectedCity_ID);
        params.put("cat_ids", mCat_ids);
        params.put("subcat_ids", mSubcat_ids);
        params.put("district_ids", mDistrict_ids);
        params.put("bizarea_ids", mBizarea_ids);
        params.put("location", mLocation);
        params.put("keyword", mkeyword);
        params.put("radius", mRadius);
        params.put("sort", mSort);
        params.put("page", mPage);
        params.put("page_size", mPage_size);
        params.put("is_reservation_required", mIs_reservation_required);

        mPresenter.refreshData(Constants.EVENT_REFRESH_DATA,ApiUrl.SEARCHDEALS, params);
    }


    ArrayList<View> mHomeViewPagerViews = new ArrayList<>();


    GridView mHeaderGridLayout;

    @Override
    protected View getHeader() {
        View header = LayoutInflater.from(getActivity()).inflate(R.layout.activity_main_header,
                mHomeRl_View, false);//new ViewPager(getActivity());//
        RecyclerView.LayoutParams headerParams = new RecyclerView.LayoutParams(RecyclerView
                .LayoutParams.MATCH_PARENT, Dip2Px.dip2px(getActivity(), 200));
        header.setLayoutParams(headerParams);


        ViewPager viewPager = (ViewPager) header.findViewById(R.id.home_viewpager);

        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.viewpager_itme11,
                viewPager, false);


        mHeaderGridLayout = new GridView(getActivity());
        RecyclerView.LayoutParams gridParams = new RecyclerView.LayoutParams(RecyclerView
                .LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
        mHeaderGridLayout.setLayoutParams(gridParams);


        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.viewpager_itme2,
                viewPager, false);
        mHomeViewPagerViews.add(view1);
        mHomeViewPagerViews.add(view2);


        LinearLayout cate_ll = (LinearLayout) view1.findViewById(R.id.cate_ll);
        LinearLayout Film = (LinearLayout) view1.findViewById(R.id.Film);
        cate_ll.setOnClickListener(this);
        Film.setOnClickListener(this);


        viewPager.setAdapter(new HomeViewPagerAdapter(mHomeViewPagerViews));


        return header;
    }

    @Override
    protected BaseRlvAdapter getRlvAdapter() {
        mHomeRl_Adapter = new HomeRlAdapter(mHomeAdapterDatas);
        return mHomeRl_Adapter;
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.cate_ll:
                intent = new Intent(getActivity(), ClassIfySearchActivity.class);
                startActivity(intent);
                break;

            case R.id.Film:
                intent = new Intent(getActivity(), ClassIfySearchActivity.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void setPresenter(HomeContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void showData(SharChdeals response) {
        mHomeAdapterDatas.clear();
        mHomeAdapterDatas.addAll(response.getData().getDeals());
        mHomeRl_Adapter.notifyDataSetChanged();
        displayContentView();

    }

    @Override
    public void onRefresh() {
        Toast.makeText(getActivity(), "下拉刷新", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore() {
        Toast.makeText(getActivity(), "加载更多", Toast.LENGTH_SHORT).show();
    }
}
