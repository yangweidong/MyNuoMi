package com.onenews.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.onenews.R;
import com.onenews.adapter.OrderDetailsAdapter;
import com.onenews.bean.OrderDetailsBean;
import com.onenews.http.Api;
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

public class OrderDetailsActivity extends BaseDetailsSliding<OrderDetailsBean> {

    String orderid;
    OrderDetailsPresenter mOrderDetailsPresenter;

    OrderDetailsAdapter mOrderDetailsAdapter;

    ArrayList<String> mDatas = new ArrayList<>();
    XRecyclerView details_rl;

    @Override
    protected int getLayout() {
        return R.layout.activity_order_details;
    }

    @Override
    protected void initData() {
        orderid = getIntent().getStringExtra("orderid");
        LL.e(orderid);
    }

    HtmlTextView htmlTextView;
    @Override
    protected void initView() {
        mOrderDetailsPresenter = new OrderDetailsPresenterImpl(this);
        mOrderDetailsAdapter = new OrderDetailsAdapter(mDatas);


        details_rl = (XRecyclerView) findViewById(R.id.details_rl);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        details_rl.setLayoutManager(layoutManager);
        details_rl.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        details_rl.setLaodingMoreProgressStyle(ProgressStyle.BallRotate);
        details_rl.setArrowImageView(R.drawable.iconfont_downgrey);

        View view = LayoutInflater.from(this).inflate(R.layout.orderdetails_head, details_rl, false);
        htmlTextView = (HtmlTextView) view.findViewById(R.id.html_text);


//        details_rl.addHeaderView(view);
        details_rl.setAdapter(mOrderDetailsAdapter);
    }

    @Override
    protected void getData() {
        Map<String, String> parmas = new HashMap<>();
        parmas.put("deal_id", orderid);
        mOrderDetailsPresenter.loadData(Api.DEALDETAIL, parmas);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void addData(OrderDetailsBean response) {
        LL.e("店铺详情页面: " + response.toString());
        setImage(response.getDeal().getImage());

        Document doc = Jsoup.parse(response.getDeal().getBuy_details());

        Elements el = doc.select("img");
        for (int i = 0; i < el.size(); i++) {

            Element element = el.get(i);

            String url = element.attr("src");
            mDatas.add(url);
        }
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
