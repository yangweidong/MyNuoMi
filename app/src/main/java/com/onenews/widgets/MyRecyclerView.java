package com.onenews.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Created by yangweidong on 16/1/26.
 */
public class MyRecyclerView extends RecyclerView {
    public MyRecyclerView(Context context) {
        super(context);
    }

    @Override
    protected int getChildDrawingOrder(int childCount, int i) {
        if (i >= childCount - 1) return 0;
            //when asked for the last view to draw, answer ZERO
        else return i + 1;
        //when asked for the i-th view to draw, answer "the next one"
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setChildrenDrawingOrderEnabled(true);
    }
}
