package com.onenews.activity;

import android.content.Intent;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.onenews.App;
import com.onenews.R;
import com.onenews.adapter.ListDropDownAdapter;
import com.onenews.adapter.MainRecyclerViewAdaptr;
import com.onenews.bean.CityBean;
import com.onenews.bean.ClassifyBean;
import com.onenews.bean.DistrictBean;
import com.onenews.bean.HomeShop;
import com.onenews.bean.SharChdeals;
import com.onenews.bean.SortBean;
import com.onenews.http.Api;
import com.onenews.test.ChildItem;
import com.onenews.test.ClassIfyBean;
import com.onenews.test.FatherItem;
import com.onenews.utils.L;
import com.onenews.widgets.LinkageView;
import com.onenews.widgets.LinkageView_Separate;
import com.onenews.widgets.MyPopupWindow;
import com.onenews.widgets.dropdownmenu.DropDownMenu;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 详情界面
 */
public class ClassIfySearchActivSity extends BaseActivity implements View.OnClickListener {


    private String headers[] = {"区域", "智能排序"};
    private List<View> popupViews = new ArrayList<>();

    private ListDropDownAdapter sexAdapter;

    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "18岁以下", "18-22岁", "23-26岁", "27-35岁", "35岁以上"};


    //默认值为0。0:综合排序 1：价格低优先， 2：价格高优先， 3：折扣高优先， 4：销量高优先， 5：用户坐标距离近优先， 6：最新发布优先,8:用户评分高优先
    private String sexs[] = {"综合排序", "价格低优先", "价格高优先", "折扣高优先", "销量高优先", "最新发布优先", "用户评分高优先", "用户坐标距离近优先"};
    private String constellations[] = {"不限", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座"};

    private int constellationPosition = 0;


    MainRecyclerViewAdaptr mClassIfyContentAdapter;

    Button getClassify;
    Button getDistricts;

    List<SharChdeals.DataEntity.DealsEntity> mSharChdealBeens = new ArrayList<>();
    List<HomeShop.DataEntity.ShopsEntity> mDataBeens = new ArrayList<>();


    List<ClassifyBean.CategoriesEntity> mClassifyBeen = new ArrayList<>();
    MyPopupWindow popupWindow;


//    private String mSelectedCity_ID = "100010000";//城市ID
//    private String mCat_ids = "";//分类的id，支持多个category合并查询， 多个一级分类用英文逗号,连接
//    private String mSubcat_ids = "";//二级分类的id，支持多个subcategory合并查询， 多个二级分类用英文逗号,连接， 如1,2,3
//    private String mDistrict_ids = "";//行政区id， 支持多个，多个区用英文逗号,连接
//    private String mBizarea_ids = "";//商圈id, 支持多个查询， 多个商圈用,连接
//    private String mLocation = "";//商圈id, 支持多个查询， 多个商圈用,连接
//    private String mkeyword = "";//关键词，搜索商品名
//    private String mRadius = "";//基于location,搜索的半径范围，单位是米。 可选（若传入该参数，必须同时传入合法的经纬度坐标， radius字段默认半径3000米）
//    private String mSort = "";//按照某种规则对返回的结果排序, 默认值为0。0:综合排序 1：价格低优先， 2：价格高优先， 3：折扣高优先， 4：销量高优先， 5：用户坐标距离近优先， 6：最新发布优先,8:用户评分高优先
//    private String mPage = "";//分页数据的页码, 如不传默认是1
//    private String mPage_size = "20";//每页返回的团单结果条目数上限，最小值1，最大值50，如不传入默认为10
//    private String mIs_reservation_required = "";//是否筛选出免预约,否: 默认不传 0为不筛选 1为筛选出支持免预约的团单

    Button cityname_bt;
    DropDownMenu mDropDownMenu;


    private ArrayList<SortBean> mSortArr;


    @Override
    protected int getLayout() {
        return R.layout.activity_details;
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
        mDropDownMenu = (DropDownMenu) findViewById(R.id.dropDownMenu);


        mRegionSelector = new LinkageView<List<FatherItem>>(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        mRegionSelector.setLayoutParams(layoutParams);
        mRegionSelector.setFocusable(true);
        mRegionSelector.setFocusableInTouchMode(true);
        mRegionSelector.setOnRightItemClickCallback(new LinkageView.OnRightItemClickCallback() {
            @Override
            public void onItemClick(ChildItem childItem, int postion) {
                mDropDownMenu.closeMenu();
                Toast.makeText(ClassIfySearchActivSity.this, "点击了", Toast.LENGTH_SHORT).show();
                district_ids = childItem.getmDistrict_ids();
                getSearchdeal();
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
                getSearchdeal();

            }
        });


        //init context view
        XRecyclerView contentView = new XRecyclerView(this);
        contentView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        contentView.setLayoutManager(new LinearLayoutManager(this));
        mClassIfyContentAdapter = new MainRecyclerViewAdaptr(mDataBeens);
        contentView.setAdapter(mClassIfyContentAdapter);

        mClassIfyContentAdapter.setOnItemClickListener(new MainRecyclerViewAdaptr.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Toast.makeText(ClassIfySearchActivSity.this, "哈哈哈", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ClassIfySearchActivSity.this, ShopInfoActivity.class);
                String murl = mSharChdealBeens.get(postion - 1).getDeal_murl();

                intent.putExtra("murl", murl);
                startActivity(intent);
            }
        });


        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, contentView);
    }


    @Override
    protected void getData() {
        getSearchdeal();
        getDistricts();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        mMainRecyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);

//        getClassify = (Button) findViewById(R.id.getClassify);
//        getDistricts = (Button) findViewById(R.id.getDistricts);


//        getDistricts.setOnClickListener(this);
//                Intent intent = new Intent(DetailsActivity.this, ClassifyActivity.class);
//                startActivityForResult(intent, 333);
//        getClassify.setOnClickListener(this);

//        mMainRecyclerView.setLayoutManager(new LinearLayoutManager(this));


//
//        mSharChdealsAdapter.setOnItemClickListener(new SharChdealsAdapter.MyItemClickListener() {
//            @Override
//            public void onItemClick(View view, int postion) {
//                Intent intent = new Intent(DetailsActivity.this, ShopInfoActivity.class);
//                String murl = mSharChdealBeens.get(postion).getDeal_murl();
//
//                intent.putExtra("murl",murl);
//                startActivity(intent);
//            }
//        });
//
//
//
//        popupWindow = new MyPopupWindow(this, ViewGroup.LayoutParams.MATCH_PARENT, (App.getScreenHeight() / 2));


    }


    private void getDistricts() {
        OkHttpUtils.get().url(Api.DISTRICTS).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").addParams("city_id", "100010000").build().execute(new RegionCallback());

    }


    String city_id = "100010000";
    String cat_ids = "";
    String subcat_ids = "";
    String district_ids = "";
    String bizarea_ids = "";
    String location = "";
    String keyword = "";
    String radius = "";
    String page = "";
    String page_size = "";
    String deals_per_shop = "";

    private void getSearchdeal() {

        Map<String, String> params = new HashMap<String, String>();
        params.put("city_id", city_id);
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


        OkHttpUtils.get().url(Api.SEARCHSHOPS).params(params).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new SearchShopCallback());
    }


    public class SearchShopCallback extends Callback<HomeShop> {
        //非UI线程，支持任何耗时操作
        @Override
        public HomeShop parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            HomeShop user = new Gson().fromJson(string, HomeShop.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }


        @Override
        public void onResponse(HomeShop response) {
            mDataBeens.clear();
//            mCitiesEntity = response.getCities();
            // mClassifyBeen.addAll(response.getCategories());
            // mLeftAdapter.notifyDataSetChanged();
            L.e("数据回来了" + response.toString());


//            for (int i = 0; i < response.getCategories().size(); i++) {
//
//
//                ClassIfyBean fatherItem = new ClassIfyBean();
//
//                fatherItem.setCat_id(response.getCategories().get(i).getCat_id());
//                fatherItem.setmFatherName(response.getCategories().get(i).getCat_name());
//                List<ChildItem> subcategoriesEntitys = new ArrayList<ChildItem>();
//
//                for (int y = 0; y < response.getCategories().get(i).getSubcategories().size(); y++) {
//
//                    ChildItem subcategoriesEntity = new ChildItem();
//                    subcategoriesEntity.setSubcat_id(response.getCategories().get(i).getSubcategories().get(y).getSubcat_id());
//                    subcategoriesEntity.setSubcat_name(response.getCategories().get(i).getSubcategories().get(y).getSubcat_name());
//
//                    subcategoriesEntitys.add(subcategoriesEntity);
//
//                }
//                fatherItem.setChildItems(subcategoriesEntitys);
//                mDataBeens.add(fatherItem);
//
//            }
//            popupWindow.setData(mDataBeens);

            mDataBeens.addAll(response.getData().getShops());

            mClassIfyContentAdapter.notifyDataSetChanged();
//            mRecyclerView.setAdapter(mAdapter);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

//            case R.id.getDistricts:
//                getCitys();
//
//                linkageViewSeparate.setLeftItemClickCallback(new LinkageView_Separate.OnLeftItemClickCallback() {
//                    @Override
//                    public void onItemClick(FatherItem fatherItem, int postion) {
//
//                        String cityID = mCityDatas.get(postion).getCityId();
//
//                        L.i(cityID.toString() + "   ID是");
//                        mSelectedCity_ID = cityID;
//                        OkHttpUtils.get().url(Api.DISTRICTS).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").addParams("city_id", cityID).build().execute(new RegionCallback());
//
//                    }
//                });
//
//                linkageViewSeparate.setOnRightItemClickCallback(new LinkageView_Separate.OnRightItemClickCallback() {
//                    @Override
//                    public void onItemClick(ChildItem childItem, int postion) {
//                        L.i("回调回调");
//                        getDistricts.setText(childItem.getSubcat_name() + "");
//                        mDistrict_ids = childItem.getmDistrict_ids();
//                        if (null != popupWindow2 && popupWindow2.isShowing()) {
//                            popupWindow2.dismiss();
//                        }
//
//                    }
//                });
//                break;
//            case R.id.getCitys:
//                startActivityForResult(intent, 333);
//                break;
//            case R.id.getClassify:
//                popupWindow.getContent().setmOnRightItemClickCallback(new LinkageView.OnRightItemClickCallback() {
//                    @Override
//                    public void onItemClick(ChildItem subcategoriesEntity, int postion) {
//                        L.e("哈哈哈" + subcategoriesEntity.toString() + " " + postion);
//                        if (popupWindow.isShowing()) {
//                            popupWindow.dismiss();
//                        }
//
//                        Map<String, String> params = new HashMap<String, String>();
//                        params.put("city_id", mSelectedCity_ID);
//                        params.put("cat_ids", mCat_ids);
//                        params.put("subcat_ids", subcategoriesEntity.getSubcat_id() + "");
//                        params.put("district_ids", mDistrict_ids);
//                        params.put("bizarea_ids", mBizarea_ids);
//                        params.put("location", mLocation);
//                        params.put("keyword", mkeyword);
//                        params.put("radius", mRadius);
//                        params.put("sort", mSort);
//                        params.put("page", mPage);
//                        params.put("page_size", mPage_size);
//                        params.put("is_reservation_required", mIs_reservation_required);
//
//
//                        OkHttpUtils
//                                .get()
//                                .url(Api.SEARCHDEALS)
//                                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
//                                .params(params)
//                                .build()
//                                .execute(new SharChdealsCallback());
//                    }
//                });
//                getClassIfy();
//                break;


        }
    }

    List<FatherItem> mRegionDataBeens = new ArrayList<>();


    public class RegionCallback extends Callback<DistrictBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public DistrictBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            DistrictBean user = new Gson().fromJson(string, DistrictBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(DistrictBean response) {
//            L.e("列表数据来了" + response.toString());
//            if (null != mChildDatas) {
//                mChildDatas.clear();
//            }
//            for (int i = 0; i < response.getDistricts().size(); i++) {
//                ShopInfoBean childItem = new ShopInfoBean();
//                childItem.setSubcat_name(response.getDistricts().get(i).getDistrict_name());
//                childItem.setmDistrict_ids(response.getDistricts().get(i).getDistrict_id() + "");
//                mChildDatas.add(childItem);
//
//            }


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


            mRegionSelector.setData(mRegionDataBeens);


//            linkageViewSeparate.setChildData(mChildDatas);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == 333) {

            String cityID = data.getStringExtra("cityID");
            String cityName = data.getStringExtra("cityName");
            String cityPinyin = data.getStringExtra("cityPinyin");
            String cityShortName = data.getStringExtra("cityShortName");
            String cityShortPinyin = data.getStringExtra("cityShortPinyin");

            L.e("" + cityID + cityName);

        }

        super.onActivityResult(requestCode, resultCode, data);
    }

//    private void getClassIfy() {
//        OkHttpUtils.get().url(Api.CLASSIFY).addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82").build().execute(new ClassifyCallback());
//        showDialog();
//    }

//    public class SharChdealsCallback extends Callback<SharChdeals> {
//        //非UI线程，支持任何耗时操作
//        @Override
//        public SharChdeals parseNetworkResponse(Response response) throws IOException {
//            String string = response.body().string();
//            SharChdeals user = new Gson().fromJson(string, SharChdeals.class);
//            return user;
//        }
//
//        @Override
//        public void onError(Request request, Exception e) {
//
//        }
//
//
//        @Override
//        public void onResponse(SharChdeals response) {
//
//            if (response.getErrno() == 1001) {
//                Toast.makeText(ClassIfySearchActivSity.this, "没有数据", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            if (response.getErrno() == 1002) {
//                Toast.makeText(ClassIfySearchActivSity.this, "参数错误", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            if (response.getErrno() == 1003) {
//                Toast.makeText(ClassIfySearchActivSity.this, "缺失必须参数", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if (response.getErrno() == 1004) {
//                Toast.makeText(ClassIfySearchActivSity.this, "认证未通过", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if (response.getErrno() == 1005) {
//                Toast.makeText(ClassIfySearchActivSity.this, "获取数据为空", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            mSharChdealBeens.clear();
////            mCitiesEntity = response.getCities();
//            // mClassifyBeen.addAll(response.getCategories());
//            // mLeftAdapter.notifyDataSetChanged();
//            mSharChdealBeens.addAll(response.getData().getDeals());
//
//            mClassIfyContentAdapter.notifyDataSetChanged();
//
//        }
//    }


//    public class ClassifyCallback extends Callback<ClassifyBean> {
//        //非UI线程，支持任何耗时操作
//        @Override
//        public ClassifyBean parseNetworkResponse(Response response) throws IOException {
//            String string = response.body().string();
//            ClassifyBean user = new Gson().fromJson(string, ClassifyBean.class);
//            return user;
//        }
//
//        @Override
//        public void onError(Request request, Exception e) {
//
//        }
//
//
//        @Override
//        public void onResponse(ClassifyBean response) {
//            L.e("哈哈哈" + response.toString());
//            mDataBeens.clear();
////            mCitiesEntity = response.getCities();
//            // mClassifyBeen.addAll(response.getCategories());
//            // mLeftAdapter.notifyDataSetChanged();
//
//
//            for (int i = 0; i < response.getCategories().size(); i++) {
//
//
//                ClassIfyBean fatherItem = new ClassIfyBean();
//
//                fatherItem.setCat_id(response.getCategories().get(i).getCat_id());
//                fatherItem.setmFatherName(response.getCategories().get(i).getCat_name());
//                List<ChildItem> subcategoriesEntitys = new ArrayList<ChildItem>();
//
//                for (int y = 0; y < response.getCategories().get(i).getSubcategories().size(); y++) {
//
//                    ChildItem subcategoriesEntity = new ChildItem();
//                    subcategoriesEntity.setSubcat_id(response.getCategories().get(i).getSubcategories().get(y).getSubcat_id());
//                    subcategoriesEntity.setSubcat_name(response.getCategories().get(i).getSubcategories().get(y).getSubcat_name());
//
//                    subcategoriesEntitys.add(subcategoriesEntity);
//
//                }
//                fatherItem.setChildItems(subcategoriesEntitys);
//                mDataBeens.add(fatherItem);
//
//            }
//            popupWindow.setData(mDataBeens);
//
//        }
//    }


    private void showDialog() {


        //LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View contentview = inflater.inflate(R.layout.activity_test, null);


        popupWindow.showAsDropDown(getClassify, 0, 0);

    }

    LinkageView_Separate linkageViewSeparate;
    PopupWindow popupWindow2;

    private void getCitys() {

        OkHttpUtils
                .get()
                .url(Api.CITYS)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .build()
                .execute(new CityCallback());

        linkageViewSeparate = new LinkageView_Separate(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linkageViewSeparate.setLayoutParams(layoutParams);
//        content = (LinkageView<List<FatherItem>>) contentview.findViewById(R.id.content);
        linkageViewSeparate.setFocusable(true); // 这个很重要
        linkageViewSeparate.setFocusableInTouchMode(true);


        popupWindow2 = new PopupWindow(linkageViewSeparate, ViewGroup.LayoutParams.MATCH_PARENT, (App.getScreenHeight() / 2));

        popupWindow2.setFocusable(true);
        popupWindow2.setBackgroundDrawable(new PaintDrawable());
        popupWindow2.setOutsideTouchable(true);

        popupWindow2.showAsDropDown(getClassify, 0, 0);
    }

    List<CityBean> mCityDatas = new ArrayList<>();
    List<ChildItem> mChildDatas = new ArrayList<>();


    public class CityCallback extends Callback<CityBean> {
        //非UI线程，支持任何耗时操作
        @Override
        public CityBean parseNetworkResponse(Response response) throws IOException {
            String string = response.body().string();
            CityBean user = new Gson().fromJson(string, CityBean.class);
            return user;
        }

        @Override
        public void onError(Request request, Exception e) {

        }

        @Override
        public void onResponse(CityBean response) {
            L.e(response.toString());
            mCityDatas.clear();


            for (int i = 0; i < response.getCities().size(); i++) {
                CityBean cityBean = new CityBean();
                cityBean.setmFatherName(response.getCities().get(i).getCity_name());
                cityBean.setCityId(response.getCities().get(i).getCity_id());
                mCityDatas.add(cityBean);
            }

            linkageViewSeparate.setFatherData(mCityDatas);


//            mCitiesEntity = response.getCities();
            //mCitiesEntity.addAll(response.getCities());
            //mCityAdapter.notifyDataSetChanged();
        }
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
    public void addData(SharChdeals response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError() {

    }


}
