package com.jy.myapplication.presenter;

import com.wf.ds.base.BasePresenter;
import com.wf.ds.contract.MainContract;

public class TestP extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPresenter {

    @Override
    public void login(String name, String password) {


    }

    @Override
    public void loginResult(String result) {

    }
}
