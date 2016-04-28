package com.onenews.api;

/**
 * Created by yangweidong on 16/4/27.
 */
public class ApiResponse<T> {
    private int errno;
    private String msg;
    private T data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
