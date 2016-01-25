package com.onenews.widgets;

import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.onenews.test.FatherItem;

import java.util.List;

/**
 * Created by yangweidong on 16/1/7.
 */
public class MyPopupWindow<T> extends PopupWindow {
    LinkageView content;

    public MyPopupWindow(Context context, int width, int height) {
        super(width, height);
        init(context);
    }

    public LinkageView getContent() {
        return content;
    }

    private void init(Context context){
        content = new LinkageView<List<FatherItem>>(context);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        content.setLayoutParams(layoutParams);
//        content = (LinkageView<List<FatherItem>>) contentview.findViewById(R.id.content);
        content.setFocusable(true); // 这个很重要
        content.setFocusableInTouchMode(true);

        this.setFocusable(true);
        this.setBackgroundDrawable(new PaintDrawable());
        this.setOutsideTouchable(true);


        setContentView(content);

    }

    public void setData(T data) {
        content.setData(data);
    }


    public void setDataFather(List<FatherItem> data) {
        content.setData(data);
    }
}
