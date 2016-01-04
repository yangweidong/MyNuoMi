package com.onenews;

import android.app.Application;

import jonathanfinerty.once.Once;

/**
 * Created by yangweidong on 15/12/30.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Once.initialise(this);
    }
}
