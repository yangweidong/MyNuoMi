package com.onenews.adapter;

import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.bean.ShopOrderListBean;

import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ShopOrderListFragmentAdapter extends RecyclerView.Adapter<ShopOrderListFragmentAdapter.ViewHolder> {

    List<ShopOrderListBean.DealsEntity> mListData;

    public ShopOrderListFragmentAdapter(List<ShopOrderListBean.DealsEntity> mListData) {
        this.mListData = mListData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shop_order_list_item,
                viewGroup, false);
        return new ViewHolder(view, shopOrderRlItemClickListener);
    }

    ShopOrderRlItemClickListener shopOrderRlItemClickListener;

    public void setOnItemClickListener(ShopOrderRlItemClickListener shopOrderRlItemClickListener) {
        this.shopOrderRlItemClickListener = shopOrderRlItemClickListener;
    }


    SpannableString mSS;

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.title.setText(mListData.get(i).getMin_title());
        viewHolder.description.setText(mListData.get(i).getDescription());


        int promotion_price_int = Integer.valueOf(mListData.get(i).getPromotion_price()) / 100;
        int market_price_int = Integer.valueOf(mListData.get(i).getCurrent_price()) / 100;
        int discount_number = market_price_int - promotion_price_int;

        String promotion_price_str = "￥" + (promotion_price_int);//活动价格
        String market_price_str = market_price_int + "";//售卖价格


        mSS = new SpannableString(promotion_price_str);
        mSS.setSpan(new AbsoluteSizeSpan(20, true), 0, promotion_price_str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        msp.setSpan(new ForegroundColorSpan(Color.RED), 0, promotion_price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        msp.setSpan(new StrikethroughSpan(),promotion_price.length(),promotion_price.length()+market_price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        viewHolder.market_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

        viewHolder.market_price.setText(market_price_str);

        viewHolder.price.setText(mSS);
        viewHolder.price.setMovementMethod(LinkMovementMethod.getInstance());

        viewHolder.score.setText(mListData.get(i).getScore() + "分");


        viewHolder.discount_number.setText("立减" + discount_number);

        Uri uri = Uri.parse(mListData.get(i).getImage());
        viewHolder.image.setImageURI(uri);


    }

    public interface ShopOrderRlItemClickListener {
        public void onItemClick(View view, int postion);
    }

    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        LinearLayout item_content;
        TextView title;
        TextView description;
        TextView market_price;
        TextView discount_number;
        TextView score;
        SimpleDraweeView image;
        TextView price;
        ShopOrderRlItemClickListener shopOrderRlItemClickListener;

        public ViewHolder(View itemView, ShopOrderRlItemClickListener shopOrderRlItemClickListener) {
            super(itemView);
            this.shopOrderRlItemClickListener = shopOrderRlItemClickListener;
            item_content = (LinearLayout) itemView.findViewById(R.id.item_content);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (SimpleDraweeView) itemView.findViewById(R.id.image);
            description = (TextView) itemView.findViewById(R.id.description);
            market_price = (TextView) itemView.findViewById(R.id.market_price);
            discount_number = (TextView) itemView.findViewById(R.id.discount_number);
            score = (TextView) itemView.findViewById(R.id.score);
            price = (TextView) itemView.findViewById(R.id.price);
            item_content.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (shopOrderRlItemClickListener != null) {
                shopOrderRlItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

}

