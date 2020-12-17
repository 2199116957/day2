package com.jy.myapplication.presenter;

import com.jy.myapplication.base.BasePresenter;
import com.jy.myapplication.contract.MainContract;
import com.jy.myapplication.model.MainModleImpl;
import com.jy.myapplication.model.UserBean;
import com.jy.myapplication.utills.net.INetCallBack;


public class MainPresenterImpl extends BasePresenter<MainContract.IMainView> implements MainContract.IMainPrasenter{

    private MainContract.IMainMidel mainModel;

    public MainPresenterImpl(MainContract.IMainView mainView) {
        this.mainModel = new MainModleImpl(this);

    }
    @Override
    public void login(String name,String password) {

//        URL就在P层确定,不要从Activity中传递过来
        mainModel.getLoginData("", new INetCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean userBean) {
                iView.getData(userBean);
            }

            @Override
            public void onFail(String err) {

            }
        });
    }

    @Override
    public void loginResult(String result) {

    }
}
