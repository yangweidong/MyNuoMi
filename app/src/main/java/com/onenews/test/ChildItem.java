package com.onenews.test;

/**
 * Created by yangweidong on 16/1/7.
 */
public class ChildItem {
    private String childName;
    private int subcat_id;
    private String mDistrict_ids;//行政区ID


    public String getmDistrict_ids() {
        return mDistrict_ids;
    }

    public void setmDistrict_ids(String mDistrict_ids) {
        this.mDistrict_ids = mDistrict_ids;
    }

    public void setSubcat_name(String subcat_name) {
        this.childName = subcat_name;
    }

    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }

    public String getSubcat_name() {
        return childName;
    }

    public int getSubcat_id() {
        return subcat_id;
    }

}
