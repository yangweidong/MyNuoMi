package com.onenews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.utils.LL;

import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder> {

    List<String> mListData;

    public OrderDetailsAdapter(List<String> mListData) {
        this.mListData = mListData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_details_item,
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
//        viewHolder.title.setText(mListData.get(i).getMin_title());
//        viewHolder.description.setText(mListData.get(i).getDescription());
//
//
//        int promotion_price_int = Integer.valueOf(mListData.get(i).getPromotion_price()) / 100;
//        int market_price_int = Integer.valueOf(mListData.get(i).getCurrent_price()) / 100;
//        int discount_number = market_price_int - promotion_price_int;
//
//        String promotion_price_str = "￥" + (promotion_price_int);//活动价格
//        String market_price_str = market_price_int + "";//售卖价格
//
//
//        mSS = new SpannableString(promotion_price_str);
//        mSS.setSpan(new AbsoluteSizeSpan(20, true), 0, promotion_price_str.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
////        msp.setSpan(new ForegroundColorSpan(Color.RED), 0, promotion_price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
////        msp.setSpan(new StrikethroughSpan(),promotion_price.length(),promotion_price.length()+market_price.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//
//        viewHolder.market_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//
//        viewHolder.market_price.setText(market_price_str);
//
//        viewHolder.price.setText(mSS);
//        viewHolder.price.setMovementMethod(LinkMovementMethod.getInstance());
//
//        viewHolder.score.setText(mListData.get(i).getScore() + "分");
//
//
//        viewHolder.discount_number.setText("立减" + discount_number);

        LL.e("添加视图: " + i);
        Uri uri = Uri.parse(mListData.get(i));
        viewHolder.rl_image.setImageURI(uri);


    }

    public interface ShopOrderRlItemClickListener {
        public void onItemClick(View view, int postion);
    }

    @Override
    public int getItemCount() {
        LL.e("大小: " + mListData.size());
        return mListData == null ? 0 : mListData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        SimpleDraweeView rl_image;
//        TextView title;
//        TextView description;
//        TextView market_price;
//        TextView discount_number;
//        TextView score;
//        SimpleDraweeView image;
//        TextView price;
//        ShopOrderRlItemClickListener shopOrderRlItemClickListener;

        public ViewHolder(View itemView, ShopOrderRlItemClickListener shopOrderRlItemClickListener) {
            super(itemView);
//            this.shopOrderRlItemClickListener = shopOrderRlItemClickListener;
            rl_image = (SimpleDraweeView) itemView.findViewById(R.id.rl_image);
//            title = (TextView) itemView.findViewById(R.id.title);
//            image = (SimpleDraweeView) itemView.findViewById(R.id.image);
//            description = (TextView) itemView.findViewById(R.id.description);
//            market_price = (TextView) itemView.findViewById(R.id.market_price);
//            discount_number = (TextView) itemView.findViewById(R.id.discount_number);
//            score = (TextView) itemView.findViewById(R.id.score);
//            price = (TextView) itemView.findViewById(R.id.price);
//            item_content.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (shopOrderRlItemClickListener != null) {
                shopOrderRlItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }

}

