package com.onenews;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;

/**
 * Created by yangweidong on 16/4/21.
 */
public abstract class GsonRequestCallback<T> extends Callback<T> {
    private Class<T> mClass;

    public GsonRequestCallback(Class<T> mClass) {
        this.mClass = mClass;
    }

    @Override
    public T parseNetworkResponse(Response response) throws IOException {
        String jsonString = new String(response.body().string());
        T t = new Gson().fromJson(jsonString, mClass);
        return t;
    }


}
