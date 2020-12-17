package com.jy.myapplication.utills.net;

public interface INetCallBack<T> {

    public void onSuccess(T t);

    public void onFail(String err);

}
