package com.onenews.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onenews.R;

import java.util.List;

/**
 * Created by yangweidong on 16/1/4.
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.CityViewHolder> {
    private SparseBooleanArray selectedItems = new SparseBooleanArray();
    private Context mContext;
    private List<FatherItem> mCategoriesEntities;

    public LeftAdapter(Context context, List<FatherItem> categoriesEntities) {
        this.mContext = context;
        this.mCategoriesEntities = categoriesEntities;

    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CityViewHolder cityViewHolder = new CityViewHolder(LayoutInflater.from(mContext).inflate(R.layout.city_item, parent, false), mMyItemClickListener);

        return cityViewHolder;
    }

    MyItemClickListener mMyItemClickListener;

    public void setOnItemClickListener(MyItemClickListener onItemClickListener) {
        mMyItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        holder.tv.setText(mCategoriesEntities.get(position).getmFatherName());
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

    int lastPosition = -1;
    TextView lastTextView;

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
//
//                // Save the selected positions to the SparseBooleanArray
//                if (selectedItems.get(getAdapterPosition(), false)) {
//
//                    selectedItems.delete(lastPosition);
//
//                    tv.setSelected(false);
//                } else {
//                    lastPosition = getAdapterPosition();
//                    selectedItems.put(getAdapterPosition(), true);
//
//                }
                if(null!=lastTextView) {
                    lastTextView.setSelected(false);
                    notifyItemChanged(lastPosition);
                }

                tv.setSelected(true);
                lastTextView = tv;


            }
        }
    }
}
