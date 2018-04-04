package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.entity.Img;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2018/2/7.
 */

public class HomePresenter<V extends HomeContract.View> extends BasePresenter<V> implements HomeContract
        .Presenter<V> {

    @Inject
    public HomePresenter(){

    }

    @Override
    public void requestAllData() {
        BaseGankRequest<GankData<List<GankLastData>>> baseGankRequest = new BaseGankRequest<GankData<List<GankLastData>>>();
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("type", Constants.ALL);
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("page", 1);

        ResponseCallback<GankData<List<GankLastData>>> gankLastDataResponseCallback = new ResponseCallbackImpl<GankData<List<GankLastData>>>() {
            @Override
            public void onSuccess(GankData<List<GankLastData>> response) {
                getMvpView().returnAllData(response);
            }
        };

        baseGankRequest.setIntegerHashMap(integerHashMap);
        baseGankRequest.setHashMap(stringHashMap);
        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        RequestCombiData(baseGankRequest);
    }

    @Override
    public void getMoreData(int page) {
        BaseGankRequest<GankData<List<GankLastData>>> baseGankRequest = new BaseGankRequest<GankData<List<GankLastData>>>();
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("type", Constants.ALL);
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("page", page);

        ResponseCallback<GankData<List<GankLastData>>> gankLastDataResponseCallback = new ResponseCallbackImpl<GankData<List<GankLastData>>>() {
            @Override
            public void onSuccess(GankData<List<GankLastData>> response) {
                Log.d("onNextaa", "onSuccess: ");
                getMvpView().returnMoreData(response);
            }
        };

        baseGankRequest.setIntegerHashMap(integerHashMap);
        baseGankRequest.setHashMap(stringHashMap);
        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        RequestCombiData(baseGankRequest);
    }

    @Override
    public void requestImg() {
        BaseGankRequest<GankData<List<Img>>> baseGankRequest = new BaseGankRequest<GankData<List<Img>>>();

        ResponseCallback<GankData<List<Img>>> gankLastDataResponseCallback = new ResponseCallbackImpl<GankData<List<Img>>>() {
            @Override
            public void onSuccess(GankData<List<Img>> response) {
                Log.d("returnImg", "onSuccess: ");
                getMvpView().returnImg(response);
            }
        };


        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        RequestImg(baseGankRequest);
    }


}
