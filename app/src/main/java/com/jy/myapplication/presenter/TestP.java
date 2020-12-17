package com.jy.myapplication.presenter;

import com.jy.myapplication.base.BasePresenter;
import com.jy.myapplication.contract.MainContract;

public class TestP extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPrasenter {

    @Override
    public void login(String name, String password) {


    }

    @Override
    public void loginResult(String result) {

    }
}
