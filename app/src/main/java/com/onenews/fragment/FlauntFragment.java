
package com.onenews.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.onenews.R;
import com.onenews.adapter.TestFragment2Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyexiong on 4/25/15.
 */
public class FlauntFragment extends BaseFragment {

    List<String> mDatas = new ArrayList<>();

    public static FlauntFragment newInstance(String content) {
        FlauntFragment fragment = new FlauntFragment();
        return fragment;
    }


    @Override
    int getLayout() {
        return R.layout.fragment_flaunt;
    }

    @Override
    void initData() {
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");
//        mDatas.add("http://media-wallpapers.theotaku.com/1440-by-900-561897-20090323013242.jpg");
//        mDatas.add("http://e.hiphotos.baidu.com/zhidao/pic/item/f3d3572c11dfa9ecfeffd08960d0f703908fc15f.jpg");
//        mDatas.add("http://a.hiphotos.baidu.com/zhidao/pic/item/8694a4c27d1ed21b8e6c4be0ae6eddc451da3f09.jpg");
//        mDatas.add("http://img5.duitang.com/uploads/item/201412/28/20141228212401_XiSQm.jpeg");
//        mDatas.add("http://h.hiphotos.baidu.com/zhidao/pic/item/8435e5dde71190efa9940d0ecf1b9d16fcfa60f0.jpg");

    }

    RecyclerView test2_rl;

    @Override
    void initView(View view) {
        test2_rl = (RecyclerView) view.findViewById(R.id.test2_rl);

        TestFragment2Adapter testFragment2Adapter = new TestFragment2Adapter(mDatas);

        StaggeredGridLayoutManager mgr = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        test2_rl.setLayoutManager(mgr);
        test2_rl.setAdapter(testFragment2Adapter);

    }

    @Override
    void getData() {

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void addData(Object response) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void shoError(String msg) {

    }
}
