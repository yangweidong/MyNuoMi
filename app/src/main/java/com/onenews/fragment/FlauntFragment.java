
package com.onenews.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.onenews.R;
import com.onenews.adapter.FlauntFragmentAdapter;
import com.onenews.bean.FlauntBean;
import com.onenews.home.FlauntContract;
import com.onenews.api.ApiUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangweidong on 16/1/20.
 */
public class FlauntFragment extends BaseFragment<List<FlauntBean.DataEntity.ResultArrayEntity>>
        implements FlauntContract.View {

    List<FlauntBean.DataEntity.ResultArrayEntity> mFlauntBean = new ArrayList<>();

    public static FlauntFragment newInstance() {
        return new FlauntFragment();
    }


    @Override
    int getLayout() {
        return R.layout.fragment_flaunt;
    }

    @Override
    void initData() {

    }

    RecyclerView test2_rl;
    FlauntFragmentAdapter flauntFragmentAdapter;

    @Override
    void initView(View view) {
        test2_rl = (RecyclerView) view.findViewById(R.id.test2_rl);

        flauntFragmentAdapter = new FlauntFragmentAdapter(mFlauntBean);

        StaggeredGridLayoutManager mgr = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);
        test2_rl.setLayoutManager(mgr);
        test2_rl.setAdapter(flauntFragmentAdapter);


    }

    @Override
    void getData() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("word", "美食分享");
        params.put("pn", "0");
        params.put("rn", "20");
        params.put("ie", "utf-8");

        mPresenter.loadFlauntData(ApiUrl.SEARCH, params);
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void addData(List<FlauntBean.DataEntity.ResultArrayEntity> response) {

    }


    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError(String msg) {

    }

    @Override
    public void showData(List<FlauntBean.DataEntity.ResultArrayEntity> response) {
        mFlauntBean.addAll(response);
        flauntFragmentAdapter.notifyDataSetChanged();
    }

    FlauntContract.Presenter mPresenter;

    @Override
    public void setPresenter(FlauntContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
