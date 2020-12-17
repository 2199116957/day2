package com.jy.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.jy.myapplication.base.BaseActivity;
import com.jy.myapplication.base.BasePresenter;
import com.jy.myapplication.contract.MainContract;
import com.jy.myapplication.model.UserBean;
import com.jy.myapplication.presenter.MainPresenterImpl;

import java.util.jar.Attributes;

public class LoginActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {


    private EditText name;
    private EditText pwd;
    @Override
    protected void initData() {
        presenter.login(getUserName(),getpassword());
    }
    @Override
    protected void initView() {
        name.findViewById(R.id.et_name);
        pwd.findViewById(R.id.et_pwd);
    };

    @Override
    protected int getLayoutID() { return R.layout.activity_main; }

    @Override
    public MainPresenterImpl add() {
        return new MainPresenterImpl(this);
    }

    /**
     * 登录按钮
     * @param view
     */
    public void loginButton(View view) {
        if(!TextUtils.isEmpty(getUserName()) && !TextUtils.isEmpty(getpassword())){

            presenter.login(getUserName(),getpassword());

        }
    }

    @Override
    public String getUserName() {
        return name.getText().toString();
    }

    @Override
    public String getpassword() {
        return pwd.getText().toString();

    }

    @Override
    public void getData(UserBean string) {

        //网络请求返回

    }
}