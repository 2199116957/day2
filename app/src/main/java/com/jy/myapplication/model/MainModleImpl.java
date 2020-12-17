package com.jy.myapplication.model;

import com.jy.myapplication.contract.MainContract;
import com.jy.myapplication.utills.net.INetCallBack;
import com.jy.myapplication.utills.net.RetrofitUtils;

public class MainModleImpl implements MainContract.IMainMidel {
    private MainContract.IMainPrasenter prasenter;

    public MainModleImpl(MainContract.IMainPrasenter prasenter) {
        this.prasenter = prasenter;
    }


    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {
        prasenter.loginResult("登录成功");
        RetrofitUtils.getInstance().get(url,callBack);
    }
}
