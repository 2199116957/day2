package com.jy.myapplication.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView {
    public T presenter;;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getVieweId());
        if (presenter == null){
            presenter = getPrenester();
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    protected abstract T getPrenester();

    protected abstract int getVieweId();

    protected abstract void initView();

    protected abstract void initData();
}
