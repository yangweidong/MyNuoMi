package com.onenews.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by yangweidong on 16/1/15.
 */
public class HomeViewPagerAdapter extends PagerAdapter {

    ArrayList<View> viewContainter;

    //滑动切换的时候销毁当前的组件
    @Override
    public void destroyItem(ViewGroup container, int position,
                            Object object) {
        ((ViewPager) container).removeView(viewContainter.get(position));
    }

    public HomeViewPagerAdapter(ArrayList<View> viewContainter) {
        this.viewContainter = viewContainter;
    }

    @Override
    public int getCount() {
        return viewContainter.size();
    }

    //每次滑动的时候生成的组件
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(viewContainter.get(position));
        return viewContainter.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
