package com.onenews.base.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.onenews.R;
import com.onenews.base.adapter.BaseRlvAdapter;
import com.onenews.remodeling.fragment.BaseFragment;
import com.onenews.widgets.recyclerview.ProgressStyle;
import com.onenews.widgets.recyclerview.XRecyclerView;

/**
 * Created by yangweidong on 16/4/24.
 */
public abstract class BaseRlvFragment extends BaseFragment {
    XRecyclerView mXRecyclerView;
    //    ListFragment listFragment;
    BaseRlvAdapter mBaseRlvAdapter;

    //    ListActivity listActivity;
    @Override
    protected int getLayoutId() {
        return R.layout.recyclerview;
    }


    @Override
    protected void initView(View view) {
        mXRecyclerView = (XRecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mXRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

        mBaseRlvAdapter = getRlvAdater();
        mXRecyclerView.setAdapter(mBaseRlvAdapter);


        if (null != getHeader()) {
            mXRecyclerView.addHeaderView(getHeader());
        }
    }


    protected abstract BaseRlvAdapter getRlvAdater();

    /**
     * 获取adapter 获取条件为  onViewCreated 之后 和 覆盖getAdater() 并且返回正确的adapter
     *
     * @return
     */
    protected BaseRlvAdapter getAdapter() {
        if (null == mBaseRlvAdapter) {
            throw new NullPointerException("adapter not init null Please cover getAdater()");
        }
        return mBaseRlvAdapter;
    }


    protected XRecyclerView getRecyclerView() {
        return mXRecyclerView;
    }

    protected View getHeader() {
        return null;
    }


}
