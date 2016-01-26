package com.onenews.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.onenews.R;
import com.onenews.activity.ClassIfySearchActivity;
import com.onenews.activity.ShopInfoActivity;
import com.onenews.adapter.HomeRlAdapter;
import com.onenews.adapter.HomeViewPagerAdapter;
import com.onenews.bean.SharChdeals;
import com.onenews.http.Api;
import com.onenews.presenter.HomePresenter;
import com.onenews.presenter.impl.HomePresenterImpl;
import com.onenews.utils.Dip2Px;
import com.onenews.utils.LL;
import com.onenews.view.HomeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeFragment extends BaseFragment implements View.OnClickListener, HomeView {
    XRecyclerView mHomeRl_View;
    HomeRlAdapter mHomeRl_Adapter;
    List<SharChdeals.DataEntity.DealsEntity> mHomeAdapterDatas = new ArrayList<>();
    private HomePresenter mHomePresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private String mSelectedCity_ID = "100010000";//城市ID
    private String mCat_ids = "";//分类的id，支持多个category合并查询， 多个一级分类用英文逗号,连接
    private String mSubcat_ids = "";//二级分类的id，支持多个subcategory合并查询， 多个二级分类用英文逗号,连接， 如1,2,3
    private String mDistrict_ids = "";//行政区id， 支持多个，多个区用英文逗号,连接
    private String mBizarea_ids = "";//商圈id, 支持多个查询， 多个商圈用,连接
    private String mLocation = "";//商圈id, 支持多个查询， 多个商圈用,连接
    private String mkeyword = "";//关键词，搜索商品名
    private String mRadius = "";//基于location,搜索的半径范围，单位是米。 可选（若传入该参数，必须同时传入合法的经纬度坐标， radius字段默认半径3000米）
    private String mSort = "";//按照某种规则对返回的结果排序, 默认值为0。0:综合排序 1：价格低优先， 2：价格高优先， 3：折扣高优先， 4：销量高优先， 5：用户坐标距离近优先， 6：最新发布优先,8:用户评分高优先
    private String mPage = "";//分页数据的页码, 如不传默认是1
    private String mPage_size = "20";//每页返回的团单结果条目数上限，最小值1，最大值50，如不传入默认为10
    private String mIs_reservation_required = "";//是否筛选出免预约,否: 默认不传 0为不筛选 1为筛选出支持免预约的团单

    @Override
    void getData() {
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
        mHomePresenter.loadData(Api.SEARCHDEALS, params);
    }


    ArrayList<View> mHomeViewPagerViews = new ArrayList<>();


    GridView mHeaderGridLayout;


    @Override
    void initView(View view) {

        mHomePresenter = new HomePresenterImpl(this);

        mHomeRl_View = (XRecyclerView) view.findViewById(R.id.home_rl);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mHomeRl_View.setLayoutManager(layoutManager);
        mHomeRl_View.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mHomeRl_View.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        mHomeRl_View.setArrowImageView(R.drawable.iconfont_downgrey);


        ViewPager header = new ViewPager(getActivity());//(ViewPager) LayoutInflater.from(getActivity()).inflate(R.layout.activity_main_header, mHomeRl_View, false);
        RecyclerView.LayoutParams headerParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, Dip2Px.dip2px(getActivity(), 200));
        header.setLayoutParams(headerParams);


        View view1 = LayoutInflater.from(getActivity()).inflate(R.layout.viewpager_itme11, header, false);


        mHeaderGridLayout = new GridView(getActivity());
        RecyclerView.LayoutParams gridParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
        mHeaderGridLayout.setLayoutParams(gridParams);
//        mHeaderGridLayout.setAdapter(new );


        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.viewpager_itme2, header, false);
        mHomeViewPagerViews.add(view1);
        mHomeViewPagerViews.add(view2);


        LinearLayout cate_ll = (LinearLayout) view1.findViewById(R.id.cate_ll);
        LinearLayout Film = (LinearLayout) view1.findViewById(R.id.Film);
        cate_ll.setOnClickListener(this);
        Film.setOnClickListener(this);


//        header.findViewById(R.id.Cate).setOnClickListener(this);
//        header.findViewById(R.id.Film).setOnClickListener(this);

        header.setAdapter(new HomeViewPagerAdapter(mHomeViewPagerViews));


        mHomeRl_View.addHeaderView(header);
        mHomeRl_Adapter = new HomeRlAdapter(mHomeAdapterDatas);

        mHomeRl_View.setAdapter(mHomeRl_Adapter);


        mHomeRl_Adapter.setOnItemClickListener(new HomeRlAdapter.HomeRlItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent = new Intent(getActivity(), ShopInfoActivity.class);
                String murl = mHomeAdapterDatas.get(postion).getDeal_murl();
                intent.putExtra("murl", murl);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    void initData() {

    }

    @Override
    public void showProgress() {
        LL.e("显示加载框......");
    }

    @Override
    public void addData(Object response) {

    }

    @Override
    public void addData(SharChdeals response) {
        LL.e("数据回来了......");

        mHomeAdapterDatas.clear();
        mHomeAdapterDatas.addAll(response.getData().getDeals());

        mHomeRl_Adapter.notifyDataSetChanged();

    }

    @Override
    public void hideProgress() {
        LL.e("隐藏加载框......");

    }


    @Override
    public void shoError(String msg) {
        LL.e("显示错误框......");

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

}
