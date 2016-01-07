package com.onenews.test;

/**
 * Created by yangweidong on 16/1/7.
 */
public class ChildItem {
    private String childName;
    private int subcat_id;

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
