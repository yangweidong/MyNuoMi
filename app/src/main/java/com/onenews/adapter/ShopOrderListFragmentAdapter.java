package com.onenews.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onenews.R;

import java.util.List;

/**
 * Created by @vitovalov on 30/9/15.
 */
public class ShopOrderListFragmentAdapter extends RecyclerView.Adapter<ShopOrderListFragmentAdapter.ViewHolder> {

    List<String> mListData;

    public ShopOrderListFragmentAdapter(List<String> mListData) {
        this.mListData = mListData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shop_order_list_item,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(mListData.get(i));
    }

    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.listitem_name);
        }
    }

}

