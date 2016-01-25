package com.onenews.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

/**
 * Created by yangweidong on 16/1/25.
 */
public class NuoMiMaterialSearchView extends MaterialSearchView {
    public NuoMiMaterialSearchView(Context context) {
        super(context);
    }

    public NuoMiMaterialSearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NuoMiMaterialSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private NuoMiOnItemClickListener mNuoMiOnItemClickListener;

    public void setmNuoMiOnItemClickListener(NuoMiOnItemClickListener mNuoMiOnItemClickListener) {
        this.mNuoMiOnItemClickListener = mNuoMiOnItemClickListener;
    }

    @Override
    public void setQuery(CharSequence query, boolean submit) {
        mNuoMiOnItemClickListener.onItemClick(query.toString());
    }

    public interface NuoMiOnItemClickListener {
        public void onItemClick(String string);
    }
}
