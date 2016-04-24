package com.onenews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.lzyzsd.randomcolor.RandomColor;
import com.onenews.R;
import com.onenews.bean.CityBean;

import java.util.List;

/**
 * Created by yangweidong on 15/12/31.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {
    private Context mContext;
    private List<CityBean.CitiesEntity> mCityBean;

    public CityAdapter(Context context, List<CityBean.CitiesEntity> cityBean) {
        this.mContext = context;
        this.mCityBean = cityBean;

    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CityViewHolder cityViewHolder = new CityViewHolder(LayoutInflater.from(mContext).inflate
                (R.layout.city_item, parent, false), mMyItemClickListener);

        return cityViewHolder;
    }

    MyItemClickListener mMyItemClickListener;
    RandomColor randomColor = new RandomColor();

    public void setOnItemClickListener(MyItemClickListener onItemClickListener) {
        mMyItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.tv.setText(mCityBean.get(position).getCity_name());
        randomColor.randomColor();
        holder.imageView.setBackgroundResource(R.color.colorPrimary);
    }

    @Override
    public int getItemCount() {
        if (null != mCityBean) {
            return mCityBean.size();
        }
        return 0;
    }

    public interface MyItemClickListener {
        public void onItemClick(View view, int postion);
    }

    class CityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv;
        ImageView imageView;
        MyItemClickListener mMyItemClickListener;

        public CityViewHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.city_item_textview);
            imageView = (ImageView) itemView.findViewById(R.id.icon);
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
