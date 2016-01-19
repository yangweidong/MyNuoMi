package com.onenews.view;

import com.onenews.test.FatherItem;

import java.util.List;

/**
 * Created by yangweidong on 16/1/14.
 */
public interface ClassIfySearchView<T> extends BaseView<T> {

    void addDistricts(List<FatherItem> cityBeens);
}
