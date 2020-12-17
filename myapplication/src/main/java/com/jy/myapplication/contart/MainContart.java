package com.jy.myapplication.contart;

import com.jy.myapplication.Base.BaseView;
import com.jy.myapplication.Bean.JdbcBean;
import com.jy.myapplication.utils.net.INetCallBack;

public class MainContart  {
    public interface  IMainView extends BaseView{
        void onSuccess(JdbcBean jdbcBean);
    }
    public interface IMainModel{
        <T> void getJava(String url, INetCallBack<T> callBack);
    }
    public interface IMainPresenter{
        void  get();
    }
}
