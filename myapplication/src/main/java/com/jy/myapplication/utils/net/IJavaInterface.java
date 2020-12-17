package com.jy.myapplication.utils.net;

import java.util.HashMap;

public interface IJavaInterface {
    public <T> void get(String url ,INetCallBack<T> callBack);
    public <T> void post(String url ,INetCallBack<T> callBack);
    public <T> void post(String url , HashMap<String,String>map,INetCallBack<T> callBack);
}
