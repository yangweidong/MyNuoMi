package com.onenews.bean;

/**
 * Created by yangweidong on 16/1/12.
 */
public class SortBean {
    private String key;
    private String name;

    public SortBean(String key, String name) {
        this.key = key;
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
