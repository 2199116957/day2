package com.jy.myapplication.contract;

import com.jy.myapplication.base.BaseView;
import com.jy.myapplication.model.UserBean;
import com.jy.myapplication.utills.net.INetCallBack;

public class MainContract {
    public interface IMainMidel {
        <T> void getLoginData(String url, INetCallBack<T> callBack);
    }
    public interface IMainPrasenter{
        void login(String name,String password);
        void loginResult(String result);
    }
    public interface IMainView extends BaseView{
        String getUserName();
        String getpassword();
        void getData(UserBean string);
    }
}
