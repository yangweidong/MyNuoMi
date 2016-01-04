package com.onenews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onenews.R;
import com.onenews.bean.CityBean;
import com.onenews.bean.RegionBean;

import java.util.List;

/**
 * Created by yangweidong on 16/1/4.
 */
public class RegionAdapter extends RecyclerView.Adapter<RegionAdapter.RegionViewHolder> {
    private Context mContext;
    private List<RegionBean.DistrictsEntity>  mDistrictsEntities;

    public RegionAdapter(Context context,  List<RegionBean.DistrictsEntity>  districtsEntities) {
        this.mContext = context;
        this.mDistrictsEntities = districtsEntities;

    }

    @Override
    public RegionAdapter.RegionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RegionViewHolder regionViewHolder = new RegionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.city_item, parent, false), mMyItemClickListener);

        return regionViewHolder;
    }

    MyItemClickListener mMyItemClickListener;

    public void setOnItemClickListener(MyItemClickListener onItemClickListener) {
        mMyItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(RegionViewHolder holder, int position) {
        holder.tv.setText(mDistrictsEntities.get(position).getDistrict_name());
    }

    @Override
    public int getItemCount() {
        if (null != mDistrictsEntities) {
            return mDistrictsEntities.size();
        }
        return 0;
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, int postion);
    }

    class RegionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        MyItemClickListener mMyItemClickListener;

        public RegionViewHolder(View itemView, MyItemClickListener myItemClickListener) {
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
