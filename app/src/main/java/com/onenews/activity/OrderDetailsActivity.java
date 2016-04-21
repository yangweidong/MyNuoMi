package com.onenews.activity;

import android.graphics.Paint;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.onenews.R;
import com.onenews.adapter.OrderDetailsAdapter;
import com.onenews.bean.OrderDetailsBean;
import com.onenews.bean.OrderDetailsImageBean;
import com.onenews.api.ApiUrl;
import com.onenews.presenter.OrderDetailsPresenter;
import com.onenews.presenter.impl.OrderDetailsPresenterImpl;
import com.onenews.utils.LL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import me.henrytao.smoothappbarlayout.SmoothAppBarLayout;
import me.henrytao.smoothappbarlayout.SmoothCollapsingToolbarLayout;
import me.henrytao.smoothappbarlayout.utils.ResourceUtils;

public class OrderDetailsActivity extends BaseActivity<OrderDetailsBean> {

    private static final int ITEM_COUNT = 100;
    CollapsingToolbarLayout vCollapsingToolbarLayout;

    XRecyclerView mXRecyclerView;

    SmoothAppBarLayout vSmoothAppBarLayout;

    SmoothCollapsingToolbarLayout vSmoothCollapsingToolbarLayout;

    Toolbar vToolbar;
    SimpleDraweeView cover;

    @Override
    protected void initView() {
        vCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        cover = (SimpleDraweeView) findViewById(R.id.cover);
        mXRecyclerView = (XRecyclerView) findViewById(R.id.list);
        vSmoothAppBarLayout = (SmoothAppBarLayout) findViewById(R.id.smooth_app_bar_layout);
        vSmoothCollapsingToolbarLayout = (SmoothCollapsingToolbarLayout) findViewById(R.id.smooth_collapsing_toolbar_layout);
        vToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(vToolbar);
//        getSupportActionBar().setTitle("团购订单详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        boolean isFitsSystemWindows = ViewCompat.getFitsSystemWindows(vSmoothAppBarLayout);
        if (isFitsSystemWindows) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        vCollapsingToolbarLayout.setTitleEnabled(false);

        mXRecyclerView.hasFixedSize();
        mXRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // use this SmoothCollapsingToolbarLayout for customizing layout when AppBar offset changed
        mActionBarSize = ResourceUtils.getStatusBarSize(this);
        mStatusBarSize = isFitsSystemWindows ? ResourceUtils.getStatusBarSize(this) : 0;
        mSmoothAppBarLayoutSize = vToolbar.getHeight();///+ getResources().getDimensionPixelSize(R.dimen.statubar_height);
        mTitle = getTitle();
//        vSmoothCollapsingToolbarLayout.setOnOffsetChangedListener(new SmoothCollapsingToolbarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(float ratio) {
//                int offset = (int) (ratio * mSmoothAppBarLayoutSize);
//                float dy = offset - mLastOffset;
//                boolean isTitleShowed = false;
//                if (dy <= 0 && offset > 0 && (offset >= (mSmoothAppBarLayoutSize - mActionBarSize - mStatusBarSize))) {
//                    isTitleShowed = true;
//                }
//                vToolbar.setTitle(isTitleShowed ? mTitle : "");
//                mLastOffset = offset;
//            }
//        });

        mOrderDetailsPresenter = new OrderDetailsPresenterImpl(this);
        mOrderDetailsAdapter = new OrderDetailsAdapter(mDatas);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mXRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        mXRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);
        mXRecyclerView.setPullRefreshEnabled(false);
        initHeader(mXRecyclerView);
        mXRecyclerView.setAdapter(mOrderDetailsAdapter);

    }


    TextView shop_name;
    TextView sale_num;
    TextView min_title;
    TextView current_price;
    TextView market_price;
    TextView long_title;
    CheckBox cb1;
    CheckBox cb2;
    HtmlTextView buy_contents;
    HtmlTextView consumer_tips;

    private void initHeader(XRecyclerView mXRecyclerView) {
        View view = LayoutInflater.from(this).inflate(R.layout.orderdetails_head, mXRecyclerView, false);

        shop_name = (TextView) view.findViewById(R.id.shop_name);
        sale_num = (TextView) view.findViewById(R.id.sale_num);
        min_title = (TextView) view.findViewById(R.id.min_title);
        current_price = (TextView) view.findViewById(R.id.current_price);
        market_price = (TextView) view.findViewById(R.id.market_price);
        long_title = (TextView) view.findViewById(R.id.long_title);
        cb1 = (CheckBox) view.findViewById(R.id.cb1);
        cb2 = (CheckBox) view.findViewById(R.id.cb2);


        buy_contents = (HtmlTextView) view.findViewById(R.id.buy_contents);
        consumer_tips = (HtmlTextView) view.findViewById(R.id.consumer_tips);


        mXRecyclerView.addHeaderView(view);
    }


    private int mActionBarSize;

    private int mLastOffset;

    private int mSmoothAppBarLayoutSize;

    private int mStatusBarSize;

    private CharSequence mTitle;

    @Override
    public boolean isAddToolbar() {
        return false;
    }


    String orderid;
    OrderDetailsPresenter mOrderDetailsPresenter;

    OrderDetailsAdapter mOrderDetailsAdapter;

    ArrayList<OrderDetailsImageBean> mDatas = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void initData() {
        orderid = getIntent().getStringExtra("orderid");
        LL.e(orderid);
    }


    @Override
    protected void getData() {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("deal_id", orderid);
        mOrderDetailsPresenter.loadData(ApiUrl.DEALDETAIL, parmas);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(OrderDetailsBean response) {
        LL.e("店铺详情页面: " + response.toString());
//        setImage(response.getDeal().getImage());





        shop_name.setText(response.getDeal().getTitle());
        sale_num.setText(response.getDeal().getSale_num());
        min_title.setText(response.getDeal().getMin_title());


        String current_price_txt = "￥"+(Integer.valueOf(response.getDeal().getCurrent_price())/100)+"";

        current_price.setText(current_price_txt);

        String market_price_txt = ""+ (Integer.valueOf(response.getDeal().getMarket_price())/100);

        market_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        market_price.setText("原价"+market_price_txt);


        long_title.setText(response.getDeal().getLong_title());



        cb1.setChecked(true);
        cb2.setChecked(true);
        cb1.setClickable(false);
        cb2.setClickable(false);


         buy_contents.setHtmlFromString(response.getDeal().getBuy_contents(),new HtmlTextView.LocalImageGetter());
         consumer_tips.setHtmlFromString(response.getDeal().getConsumer_tips(),new HtmlTextView.LocalImageGetter());


        Document doc = Jsoup.parse(response.getDeal().getBuy_details());

        String[] text = doc.body().text().split(" ");




        Elements el = doc.select("img");
        for (int i = 0; i < el.size(); i++) {

            Element element = el.get(i);

            String url = element.attr("src");

            String details_txt="暂无描述";
            if(i<text.length || i< text.length){
                details_txt = text[i];
            }
            mDatas.add(new OrderDetailsImageBean(details_txt,url));

        }





        LL.e("text" + text);





        Uri uri = Uri.parse(response.getDeal().getImage());
        cover.setImageURI(uri);

        // htmlTextView.setHtmlFromString(response.getDeal().getBuy_details().toString(),new HtmlTextView.LocalImageGetter());
        mOrderDetailsAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideProgress() {

    }


    @Override
    public void shoError(String msg) {

    }

}
