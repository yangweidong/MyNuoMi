package com.onenews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;
import com.onenews.bean.FlauntBean;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.List;

/**
 * Created by yangweidong on 16/1/26.
 */
public class FlauntFragmentAdapter extends RecyclerView.Adapter<FlauntFragmentAdapter.ViewHolder> {

    private List<FlauntBean.DataEntity.ResultArrayEntity> mFlauntBean;

    public FlauntFragmentAdapter(List<FlauntBean.DataEntity.ResultArrayEntity> flauntBean) {
        this.mFlauntBean = flauntBean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder cityViewHolder = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test2_item, parent, false));

//        View v = parent.getContext().get.inflate(R.layout.test2_item, null);

        return cityViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Uri uri = Uri.parse(mFlauntBean.get(position).getObjUrl());
        holder.simpleDraweeView.setImageURI(uri);

        holder.textView.setHtmlFromString(mFlauntBean.get(position).getDesc().toString(), new HtmlTextView.LocalImageGetter());
    }

    @Override
    public int getItemCount() {
        return mFlauntBean.size();
    }

    //自定义的ViewHolder,减少findViewById调用次数
    class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView simpleDraweeView;
        HtmlTextView textView;

        //在布局中找到所含有的UI组件
        public ViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.test2_sdv);
            textView = (HtmlTextView) itemView.findViewById(R.id.describe);

        }
    }

}
