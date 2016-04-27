package com.onenews.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.base.BaseViewHolder;
import com.onenews.base.adapter.BaseRlvAdapter;
import com.onenews.bean.SharChdeals;

import java.util.List;

/**
 * Created by yangweidong on 15/12/31.
 */
public class HomeRlAdapter extends BaseRlvAdapter<HomeRlAdapter.HomeRlViewHolder> {
    private List<SharChdeals.DataEntity.DealsEntity> mDealsEntities;

    public HomeRlAdapter(List<SharChdeals.DataEntity.DealsEntity> dealsEntities) {
        this.mDealsEntities = dealsEntities;

    }

    @Override
    public HomeRlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HomeRlViewHolder cityViewHolder = new HomeRlViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sharchdeals_item, parent, false), mHomeRlItemClickListener);

        return cityViewHolder;
    }

    HomeRlItemClickListener mHomeRlItemClickListener;

    public void setOnItemClickListener(HomeRlItemClickListener onItemClickListener) {
        mHomeRlItemClickListener = onItemClickListener;
    }


    @Override
    public void onBindViewHolder(HomeRlViewHolder holder, int position) {
        holder.tv.setText(mDealsEntities.get(position).getTitle());
        holder.min_title.setText(mDealsEntities.get(position).getMin_title());
        holder.description.setText(mDealsEntities.get(position).getDescription());
        Uri uri = Uri.parse(mDealsEntities.get(position).getImage());
        holder.simpleDraweeView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        if (null != mDealsEntities) {
            return mDealsEntities.size();
        }
        return 0;
    }

    public interface HomeRlItemClickListener {
        public void onItemClick(View view, int postion);
    }

    class HomeRlViewHolder extends BaseViewHolder implements View.OnClickListener {
        TextView tv;
        TextView min_title;
        TextView description;
        SimpleDraweeView simpleDraweeView;
        HomeRlItemClickListener homeRlItemClickListener;

        public HomeRlViewHolder(View itemView, HomeRlItemClickListener homeRlItemClickListener) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.sharchdeals_item_textview);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.sharchdeals_item);
            min_title = (TextView) itemView.findViewById(R.id.min_title);
            description = (TextView) itemView.findViewById(R.id.description);

            this.homeRlItemClickListener = homeRlItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mHomeRlItemClickListener != null) {
                mHomeRlItemClickListener.onItemClick(v, getLayoutPosition() - 2);
            }
        }
    }
}
