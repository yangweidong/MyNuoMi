package com.onenews.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.onenews.R;

import java.util.List;

/**
 * Created by yangweidong on 16/1/26.
 */
public class TestFragment2Adapter extends RecyclerView.Adapter<TestFragment2Adapter.ViewHolder> {

    private List<String> mDatas;

    public TestFragment2Adapter(List<String> mDatas) {
        this.mDatas = mDatas;
    }

//    @Override
//    public void getItemOffsets (Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//
//        outRect.set(0, vertOverlap, 0, 0);
//
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder cityViewHolder = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.test2_item, parent, false));

//        View v = parent.getContext().get.inflate(R.layout.test2_item, null);

        return cityViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Uri uri = Uri.parse(mDatas.get(position));
        holder.textView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    //自定义的ViewHolder,减少findViewById调用次数
    class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView textView;

        //在布局中找到所含有的UI组件
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (SimpleDraweeView) itemView.findViewById(R.id.test2_sdv);
        }
    }

}
