package com.jy.myapplication.model;

import com.jy.myapplication.contart.MainContart;
import com.jy.myapplication.utils.net.INetCallBack;
import com.jy.myapplication.utils.net.RetrofUtils;

public class MainModel implements MainContart.IMainModel {
    @Override
    public <T> void getJava(String url, INetCallBack<T> callBack) {
        RetrofUtils.getInstance().get(url,callBack);
    }
}
