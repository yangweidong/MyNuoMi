package com.onenews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.bean.OrderDetailsImageBean;
import com.onenews.utils.LL;

import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.ViewHolder> {

    List<OrderDetailsImageBean> mListData;

    public OrderDetailsAdapter(List<OrderDetailsImageBean> mListData) {
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


        LL.e("添加视图: " + i);
        Uri uri = Uri.parse(mListData.get(i).getImageUrl());
        viewHolder.rl_image.setImageURI(uri);
        viewHolder.details.setText(mListData.get(i).getDetails());


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
        TextView details;
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
            details = (TextView) itemView.findViewById(R.id.details);
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

