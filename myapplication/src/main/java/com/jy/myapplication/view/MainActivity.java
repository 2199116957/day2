package com.jy.myapplication.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jy.myapplication.Base.BaseActivity;
import com.jy.myapplication.Bean.JdbcBean;
import com.jy.myapplication.R;
import com.jy.myapplication.contart.MainContart;
import com.jy.myapplication.pressenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContart.IMainView {

    private RecyclerView mRv;
    private ArrayList<JdbcBean.ResultsDTO> list;
    private RecyclerAdap adap;



    @Override
    protected MainPresenter getPrenester() {
        return new MainPresenter(this);
    }

    @Override
    protected int getVieweId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adap = new RecyclerAdap(list,this);
        mRv.setAdapter(adap);
    }

    @Override
    protected void initData() {
        presenter.get();
    }

    @Override
    public void onSuccess(JdbcBean jdbcBean) {
        list.addAll(jdbcBean.getResults());
        adap.notifyDataSetChanged();
    }
}