package com.onenews.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.onenews.App;
import com.onenews.R;
import com.onenews.adapter.ClassIfyRecyclerViewAdaptr;
import com.onenews.adapter.ListDropDownAdapter;
import com.onenews.api.ApiUrl;
import com.onenews.bean.HomeShop;
import com.onenews.bean.SharChdeals;
import com.onenews.bean.SortBean;
import com.onenews.presenter.ClassIfysearchPresenter;
import com.onenews.presenter.impl.ClassIfysearchPresenterImpl;
import com.onenews.test.ChildItem;
import com.onenews.test.FatherItem;
import com.onenews.utils.LL;
import com.onenews.view.ClassIfySearchView;
import com.onenews.widgets.LinkageView;
import com.onenews.widgets.dropdownmenu.DropDownMenu;
import com.onenews.widgets.recyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 详情界面
 */
public class ClassIfySearchActivity extends BaseClassIfySearchActivity<HomeShop> implements ClassIfySearchView<HomeShop> {


    private String headers[] = {"区域", "智能排序"};
    private List<View> popupViews = new ArrayList<>();

    private ListDropDownAdapter sexAdapter;

    ClassIfyRecyclerViewAdaptr mClassIfyContentAdapter;

    List<SharChdeals.DataEntity.DealsEntity> mSharChdealBeens = new ArrayList<>();


    List<HomeShop.DataEntity.ShopsEntity> mDataBeens = new ArrayList<>();


    DropDownMenu mDropDownMenu;


    private ArrayList<SortBean> mSortArr;


    private ClassIfysearchPresenter mClassIfysearchPresenter;


    @Override
    protected int getLayout() {
        return R.layout.activity_classify_search;
    }

    @Override
    protected void initData() {
        mSortArr = new ArrayList<>();
        mSortArr.add(new SortBean("0", "综合排序"));
        mSortArr.add(new SortBean("1", "价格低优先"));
        mSortArr.add(new SortBean("2", "价格高优先"));
        mSortArr.add(new SortBean("3", "折扣高优先"));
        mSortArr.add(new SortBean("4", "销量高优先"));
        mSortArr.add(new SortBean("6", "最新发布优先"));
        mSortArr.add(new SortBean("8", "用户评分高优先"));
        mSortArr.add(new SortBean("5", "用户坐标距离近优先"));
        mSortArr.get(0);
    }

    @Override
    protected void initView() {
        setTitle("美食");

        mClassIfysearchPresenter = new ClassIfysearchPresenterImpl(this);


        mDropDownMenu = (DropDownMenu) findViewById(R.id.dropDownMenu);

        mRegionSelector = new LinkageView<List<FatherItem>>(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 700);
        mRegionSelector.setLayoutParams(layoutParams);
        mRegionSelector.setFocusable(true);
        mRegionSelector.setFocusableInTouchMode(true);
        mRegionSelector.setOnRightItemClickCallback(new LinkageView.OnRightItemClickCallback() {
            @Override
            public void onItemClick(ChildItem childItem, int postion) {
                mDropDownMenu.closeMenu();
//                Toast.makeText(ClassIfySearchActivity.this, "点击了", Toast.LENGTH_SHORT).show();
//                district_ids = childItem.getmDistrict_ids();
            }
        });


        final ListView sexView = new ListView(this);
        sexView.setDividerHeight(0);
        sexAdapter = new ListDropDownAdapter(this, mSortArr);
        sexView.setAdapter(sexAdapter);

        //init constellation

        //init popupViews
        popupViews.add(mRegionSelector);
        popupViews.add(sexView);

        sexView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sexAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(mSortArr.get(position).getName());
                mDropDownMenu.closeMenu();
                district_ids = mSortArr.get(position).getKey();

            }
        });


        //init context view
        XRecyclerView contentView = new XRecyclerView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        contentView.setLayoutManager(new LinearLayoutManager(this));
        mClassIfyContentAdapter = new ClassIfyRecyclerViewAdaptr(mDataBeens);
        contentView.setAdapter(mClassIfyContentAdapter);

        mClassIfyContentAdapter.setOnItemClickListener(new ClassIfyRecyclerViewAdaptr.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
//                Toast.makeText(ClassIfySearchActivity.this, "哈哈哈", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ClassIfySearchActivity.this, ShopActivity.class);
//                String murl = mSharChdealBeens.get(postion - 1).getDeal_murl();
//
                intent.putExtra("shopid", mDataBeens.get(postion - 1).getShop_id() + "");
                intent.putExtra("title", mDataBeens.get(postion - 1).getShop_name());
                startActivity(intent);
            }
        });


        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, contentView);
    }


    @Override
    protected void getData() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("city_id", App.mCityID);
        params.put("cat_ids", cat_ids);
        params.put("subcat_ids", subcat_ids);
        params.put("district_ids", district_ids);
        params.put("bizarea_ids", bizarea_ids);
        params.put("location", location);
        params.put("keyword", keyword);
        params.put("radius", radius);
        params.put("page", page);
        params.put("page_size", page_size);
        params.put("deals_per_shop", deals_per_shop);
        mClassIfysearchPresenter.loadBusiness(ApiUrl.SEARCHSHOPS, params);


        Map<String, String> districtsParams = new HashMap<String, String>();
        districtsParams.put("city_id", App.mCityID);

        mClassIfysearchPresenter.loadDistricts(ApiUrl.DISTRICTS, districtsParams);

    }

    //    String city_id = "100010000";
    String cat_ids = "326";
    String subcat_ids = "";
    String district_ids = "";
    String bizarea_ids = "";
    String location = "";
    String keyword = "";//美食
    String radius = "";
    String page = "";
    String page_size = "";
    String deals_per_shop = "";

//    String cat_ids = "326";
//    String subcat_ids = "962,994";
//    String district_ids = "394,395";
//    String bizarea_ids = "1322,1328";
//    String location = "116.418993,39.915597";
//    String keyword = "";//美食
//    String radius = "30000";
//    String page = "1";
//    String page_size = "20";
//    String deals_per_shop = "20";
    @Override
    public void addDistricts(List<FatherItem> fatherItems) {
        mRegionSelector.setData(fatherItems);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 333) {

            String cityID = data.getStringExtra("cityID");
            String cityName = data.getStringExtra("cityName");
            String cityPinyin = data.getStringExtra("cityPinyin");
            String cityShortName = data.getStringExtra("cityShortName");
            String cityShortPinyin = data.getStringExtra("cityShortPinyin");

            LL.e("" + cityID + cityName);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    LinkageView mRegionSelector;


    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void addData(HomeShop response) {
        mDataBeens.clear();

        mDataBeens.addAll(response.getData().getShops());
        mClassIfyContentAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError(String msg) {
        Toast.makeText(ClassIfySearchActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
    }


}
