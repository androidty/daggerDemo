package com.ty.dagger.daggerdemo.mvp.data.remote.gank;


import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;

import java.util.HashMap;

import io.reactivex.Observable;

/**
 * Created by ty on 2018/1/4.
 */

public class BaseRequest<T> {
    private Observable mObservable;
    private String url;
    private String Method;
    private ResponseCallback<T> mResponseCallback;
    private HashMap<?,?> mHashMap ;
    private HashMap<String,Integer> mIntegerHashMap;

    public Observable getObservable() {
        return mObservable;
    }

    public void setObservable(Observable observable) {
        mObservable = observable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return Method;
    }

    public void setMethod(String method) {
        Method = method;
    }

    public ResponseCallback<T> getResponseCallback() {
        return mResponseCallback;
    }

    public void setResponseCallback(ResponseCallback<T> responseCallback) {
        mResponseCallback = responseCallback;
    }

    public HashMap<?, ?> getHashMap() {
        return mHashMap;
    }

    public void setHashMap(HashMap<?, ?> hashMap) {
        mHashMap = hashMap;
    }

    public HashMap<String, Integer> getIntegerHashMap() {
        return mIntegerHashMap;
    }

    public void setIntegerHashMap(HashMap<String, Integer> integerHashMap) {
        mIntegerHashMap = integerHashMap;
    }
}
