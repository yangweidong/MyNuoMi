package com.onenews.test;

import java.util.List;

/**
 * Created by yangweidong on 16/1/4.
 */
public class FatherItem {


    private String mFatherName;
    /**
     * subcat_name : 快照冲印
     * subcat_id : 319
     */

    private List<ChildItem> childItems;

    public String getmFatherName() {
        return mFatherName;
    }

    public void setmFatherName(String mFatherName) {
        this.mFatherName = mFatherName;
    }

    public List<ChildItem> getChildItems() {
        return childItems;
    }

    public void setChildItems(List<ChildItem> childItems) {
        this.childItems = childItems;
    }

    @Override
    public String toString() {
        return "FatherItem{" +
                "mFatherName='" + mFatherName + '\'' +
                ", childItems=" + childItems +
                '}';
    }
}
