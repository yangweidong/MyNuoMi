package com.onenews.base;

import com.onenews.api.ApiResponse;

/**
 * Created by yangweidong on 16/4/27.
 */
public class BasePresenter {


    /**
     * 检查数据
     */
    protected boolean checkData(ApiResponse apiResponse) {
        if (apiResponse.getErrno() == 1001) {
            //Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (apiResponse.getErrno() == 1002) {
            //Toast.makeText(getActivity(), "参数错误", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (apiResponse.getErrno() == 1003) {
            //Toast.makeText(getActivity(), "缺失必须参数", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (apiResponse.getErrno() == 1004) {
            //Toast.makeText(getActivity(), "认证未通过", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (apiResponse.getErrno() == 1005) {
            //Toast.makeText(getActivity(), "获取数据为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}
