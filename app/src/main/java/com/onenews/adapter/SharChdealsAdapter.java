package com.onenews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.api.SharChdeals;

import java.util.List;

/**
 * Created by yangweidong on 15/12/31.
 */
public class SharChdealsAdapter extends RecyclerView.Adapter<SharChdealsAdapter.CityViewHolder> {
    private  List<SharChdeals.DealsEntity> mCityBean;

    public SharChdealsAdapter(List<SharChdeals.DealsEntity> cityBean) {
        this.mCityBean = cityBean;

    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CityViewHolder cityViewHolder = new CityViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sharchdeals_item, parent, false), mMyItemClickListener);

        return cityViewHolder;
    }

    MyItemClickListener mMyItemClickListener;

    public void setOnItemClickListener(MyItemClickListener onItemClickListener) {
        mMyItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.tv.setText(mCityBean.get(position).getTitle());
        holder.min_title.setText(mCityBean.get(position).getMin_title());
        holder.description.setText(mCityBean.get(position).getDescription());
        Uri uri = Uri.parse(mCityBean.get(position).getImage());
        holder.simpleDraweeView.setImageURI(uri);
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
        TextView min_title;
        TextView description;
        SimpleDraweeView simpleDraweeView;
        MyItemClickListener mMyItemClickListener;

        public CityViewHolder(View itemView, MyItemClickListener myItemClickListener) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.sharchdeals_item_textview);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sharchdeals_item);
            min_title = (TextView) itemView.findViewById(R.id.min_title);
            description = (TextView) itemView.findViewById(R.id.description);

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
