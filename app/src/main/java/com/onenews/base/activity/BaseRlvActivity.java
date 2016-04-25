package com.onenews.base.activity;

import android.support.v7.widget.LinearLayoutManager;

import com.onenews.R;
import com.onenews.base.adapter.BaseRlvAdapter;
import com.onenews.remodeling.activity.BaseActivity;
import com.onenews.widgets.recyclerview.ProgressStyle;
import com.onenews.widgets.recyclerview.XRecyclerView;

/**
 * Created by yangweidong on 16/4/24.
 */
public abstract class BaseRlvActivity extends BaseActivity {

    XRecyclerView mXRecyclerView;
    //    ListFragment listFragment;
    BaseRlvAdapter mBaseRlvAdapter;

    //    ListActivity listActivity;
    @Override
    protected int getLayout() {
        return R.layout.recyclerview;
    }


    @Override
    protected void initView() {
        mXRecyclerView = (XRecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(layoutManager);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mXRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

        mBaseRlvAdapter = getRlvAdater();
        mXRecyclerView.setAdapter(mBaseRlvAdapter);
    }

    protected abstract BaseRlvAdapter getRlvAdater();

    /**
     * 获取adapter 获取条件为  onCreated 之后 和 覆盖getAdater() 并且返回正确的adapter
     * @return
     */
    protected BaseRlvAdapter getAdapter(){
        if(null == mBaseRlvAdapter){
            throw new NullPointerException("adapter not init null Please cover getAdater()");
        }
        return mBaseRlvAdapter;
    }

}
