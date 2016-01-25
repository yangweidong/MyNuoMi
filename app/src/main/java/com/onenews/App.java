package com.onenews;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;

import com.facebook.drawee.backends.pipeline.Fresco;

import jonathanfinerty.once.Once;

/**
 * Created by yangweidong on 15/12/30.
 */
public class App extends Application {
    public static String mCityID = "100010000";

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Once.initialise(this);
    }


    public static int px2dip(int pxValue)
    {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static float dip2px(float dipValue)
    {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return  (dipValue * scale + 0.5f);
    }

    /**
     * 获取屏幕区域
     */
    public static Rect getScreenRect() {
        DisplayMetrics displayMetric = new DisplayMetrics();
        displayMetric = Resources.getSystem().getDisplayMetrics();
        Rect rect = new Rect(0, 0, displayMetric.widthPixels, displayMetric.heightPixels);
        return rect;
    }

    /**
     * 获取屏幕宽度
     *
     */
    public static int getScreenWidth() {
        return getScreenRect().width();
    }

    /**
     * 获取屏幕高度
     *
     */
    public static int getScreenHeight() {
        return getScreenRect().height();
    }

}
