package com.jy.myapplication.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());

        if (presenter==null){
            presenter = add();
            presenter.attachView(this);
        }

        initView();
        initData();
    }

    protected abstract int getLayoutID();


    protected abstract void initView() ;
    protected abstract void initData() ;

    public abstract P add();
}
