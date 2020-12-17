package com.jy.myapplication.utils.net;

public interface INetCallBack<T> {
    public void onSuccess(T t);
    public void onFail(String error);

}
