package com.onenews.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onenews.R;

import java.util.List;

/**
 * Created by yangweidong on 16/1/4.
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.CityViewHolder> {

    private Context mContext;
    private List<ChildItem> mCategoriesEntities;

    public RightAdapter(Context context,  List<ChildItem> categoriesEntities) {
        this.mContext = context;
        this.mCategoriesEntities = categoriesEntities;

    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CityViewHolder cityViewHolder = new CityViewHolder(LayoutInflater.from(mContext).inflate(R.layout.district_item, parent, false), mMyItemClickListener);

        return cityViewHolder;
    }

    MyItemClickListener mMyItemClickListener;

    public void setOnItemClickListener(MyItemClickListener onItemClickListener) {
        mMyItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.tv.setText(mCategoriesEntities.get(position).getSubcat_name());
    }

    @Override
    public int getItemCount() {
        if (null != mCategoriesEntities) {
            return mCategoriesEntities.size();
        }
        return 0;
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, int postion);
    }

    class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        MyItemClickListener mMyItemClickListener;

        public CityViewHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.city_item_textview);
            this.mMyItemClickListener = myItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mMyItemClickListener != null) {
                mMyItemClickListener.onItemClick(v, getLayoutPosition());
            }
        }
    }
}
