package com.jy.myapplication.utills.net;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements INetWorkInterface {
    private static RetrofitUtils retrofitUtils;

    private ApiServices apiServices;

    private RetrofitUtils() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiServices = retrofit.create(ApiServices.class);

    }


    public static RetrofitUtils getInstance() {
        if(retrofitUtils == null){
            synchronized (RetrofitUtils.class){
                if(retrofitUtils == null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    @Override
    public <T> void get(String url, INetCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, INetCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack) {

    }
}
