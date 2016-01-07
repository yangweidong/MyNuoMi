package com.onenews.widgets;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.onenews.bean.CityBean;
import com.onenews.test.ChildItem;
import com.onenews.test.FatherItem;
import com.onenews.test.LeftAdapter;
import com.onenews.test.RightAdapter;
import com.onenews.utils.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangweidong on 16/1/4.
 */
public class LinkageView2 extends LinearLayout {
    public LinkageView2(Context context) {
        this(context, null);
    }

    public LinkageView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinkageView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    RecyclerView left;
    RecyclerView right;

    LeftAdapter mLeftAdapter;
    RightAdapter mRightAdapter;

    OnRightItemClickCallback mOnRightItemClickCallback;

    public void setmOnRightItemClickCallback(OnRightItemClickCallback mOnRightItemClickCallback) {
        this.mOnRightItemClickCallback = mOnRightItemClickCallback;
    }

    private void init(Context context) {
        this.setBackgroundColor(Color.WHITE);
        // mOnRightItemClickCallback = (OnRightItemClickCallback) context;


        left = new RecyclerView(context);
        right = new RecyclerView(context);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);

        left.setLayoutParams(layoutParams);
        right.setLayoutParams(layoutParams);
        setOrientation(LinearLayout.HORIZONTAL);


        LayoutParams param = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT, 1.0f);
        addView(left, param);
        addView(right, param);

        left.setSelected(true);
        left.setLayoutManager(new LinearLayoutManager(context));
        left.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));


        right.setLayoutManager(new LinearLayoutManager(context));
        right.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL_LIST));


        mLeftAdapter = new LeftAdapter(context, mLeftItems);
        mRightAdapter = new RightAdapter(context, mRightItems);

        mLeftAdapter.setOnItemClickListener(new LeftAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                FatherItem fatherItem = mLeftItems.get(postion);
                mRightItems.clear();

                mRightItems.addAll(fatherItem.getChildItems());
                mRightAdapter.notifyDataSetChanged();
            }
        });

        left.setAdapter(mLeftAdapter);
        right.setAdapter(mRightAdapter);


        mRightAdapter.setOnItemClickListener(new RightAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                mOnRightItemClickCallback.onItemClick(mRightItems.get(postion), postion);
            }
        });
    }

    List<FatherItem> mLeftItems = new ArrayList<>();
    List<ChildItem> mRightItems = new ArrayList<>();


    public interface OnRightItemClickCallback {
        public void onItemClick(ChildItem subcategoriesEntity, int postion);
    }


    public void setFatherData(List<CityBean> data) {
        L.i("setData");
        if (null != mLeftItems && !mLeftItems.isEmpty()) {
            mLeftItems.clear();
        }
        mLeftItems.addAll((List) data);
        mLeftAdapter.notifyDataSetChanged();
    }


    public void setChildData( List<ChildItem> data) {
        L.i("setData");
        if (null != mRightItems && !mRightItems.isEmpty()) {
            mRightItems.clear();
        }
        mRightItems.addAll((List) data);
        mRightAdapter.notifyDataSetChanged();
    }


//    //默认执行，计算view的宽高,在onDraw()之前
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int width = measureWidth(widthMeasureSpec);
//        int height = measureHeight(heightMeasureSpec);
//        //设置宽高
//        setMeasuredDimension(width, height);
//    }
//
//    //根据xml的设定获取宽度
//    private int measureWidth(int measureSpec) {
//        int specMode = MeasureSpec.getMode(measureSpec);
//        int specSize = MeasureSpec.getSize(measureSpec);
//        //wrap_content
//        if (specMode == MeasureSpec.AT_MOST) {
//        }
//        //fill_parent或者精确值
//        else if (specMode == MeasureSpec.EXACTLY) {
//
//            return LayoutParams.MATCH_PARENT;
//
//
//        }
//        return specSize;
//    }
//
//    //根据xml的设定获取高度
//    private int measureHeight(int measureSpec) {
//        int specMode = MeasureSpec.getMode(measureSpec);
//        int specSize = MeasureSpec.getSize(measureSpec);
//        //wrap_content
//        if (specMode == MeasureSpec.AT_MOST) {
//        }
//        //fill_parent或者精确值
//        else if (specMode == MeasureSpec.EXACTLY) {
//        }
//        return specSize;
//    }


}
