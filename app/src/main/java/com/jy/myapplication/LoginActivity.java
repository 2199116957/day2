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

public class LoginActivity extends BaseActivity<MainPresenterImpl> implements MainContract.IMainView {


    private EditText editTextTextPersonName;
    private EditText editTextTextPassword;
    @Override
    protected void initData() {
        presenter.login(getUserName(),getpassword());
    }
    @Override
    protected void initView() {
        editTextTextPersonName.findViewById(R.id.editTextTextPersonName);
        editTextTextPassword.findViewById(R.id.editTextTextPassword);

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
        return editTextTextPersonName.getText().toString();
    }

    @Override
    public String getpassword() {
        return editTextTextPassword.getText().toString();

    }


    @Override
    public void getData(UserBean string) {

        //网络请求返回

    }
}