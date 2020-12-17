package com.jy.myapplication.pressenter;

import com.jy.myapplication.Base.BasePresenter;
import com.jy.myapplication.Bean.JdbcBean;
import com.jy.myapplication.contart.MainContart;
import com.jy.myapplication.model.MainModel;
import com.jy.myapplication.utils.net.INetCallBack;
import com.jy.myapplication.view.MainActivity;

public class MainPresenter extends BasePresenter<MainContart.IMainView> implements MainContart.IMainPresenter {
    private MainContart.IMainModel iMainModel;

    public MainPresenter(MainContart.IMainView iMainView) {
        this.iMainModel = new MainModel();
    }

    @Override
    public void get() {
        iMainModel.getJava("%E7%A6%8F%E5%88%A9/20/2", new INetCallBack<JdbcBean>() {
            @Override
            public void onSuccess(JdbcBean jdbcBean) {
                iView.onSuccess(jdbcBean);
            }

            @Override
            public void onFail(String error) {

            }
        });
    }
}
