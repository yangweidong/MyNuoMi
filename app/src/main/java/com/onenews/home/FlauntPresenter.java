package com.onenews.home;

import com.onenews.GsonRequestCallback;
import com.onenews.bean.FlauntBean;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Map;


/**
 * Created by yangweidong on 16/4/21.
 */
public class FlauntPresenter implements FlauntContract.Presenter {

    FlauntContract.View mFlauntView;

    public FlauntPresenter(FlauntContract.View mFlauntView) {
        this.mFlauntView = mFlauntView;

        this.mFlauntView.setPresenter(this);
    }

    @Override
    public void loadFlauntData(String url, Map<String, String> params) {
        OkHttpUtils
                .get()
                .url(url)
                .addHeader("apikey", "abcfe469f2ede2b495055162e97d8b82")
                .params(params)
                .build()
                .execute(new GsonRequestCallback<FlauntBean>(FlauntBean.class) {

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(FlauntBean response) {
                        if (response.getStatus().getCode().equals(1)) {
                            return;
                        }

                        if (response.getStatus().getCode().equals(2)) {
                            return;
                        }

                        if (response.getStatus().getCode().equals(3)) {
                            return;
                        }
                        if (response.getStatus().getCode().equals(4)) {
                            return;
                        }
                        if (response.getStatus().getCode().equals(5)) {
                            return;
                        }
                        mFlauntView.showData(response.getData().getResultArray());
                    }
                });
    }

}
