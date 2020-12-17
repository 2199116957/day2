package com.jy.myapplication.utils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofUtils implements IJavaInterface {
    private static RetrofUtils retrofUtils;
    private ApiService apiService;

    private RetrofUtils(){
        Retrofit build = new Retrofit.Builder()
                .baseUrl(URLconstant.baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = build.create(ApiService.class);
    }
    public static RetrofUtils getInstance(){
        if (retrofUtils==null){
            synchronized (RetrofUtils.class){
                if (retrofUtils==null){
                    retrofUtils = new RetrofUtils();
                }
            }
        }
        return retrofUtils;
    }

    @Override

    public <T> void get(String url, INetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type actualTypeArgument = actualTypeArguments[0];
                            T result = new Gson().fromJson(string, actualTypeArgument);
                            callBack.onSuccess(result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, INetCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, INetCallBack<T> callBack) {

    }
}
