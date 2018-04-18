package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
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
        BaseRequest<BaseData<List<GankData>>> baseGankRequest = new BaseRequest<BaseData<List<GankData>>>();
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("type", Constants.ALL);
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("page", 1);

        ResponseCallback<BaseData<List<GankData>>> gankLastDataResponseCallback = new ResponseCallbackImpl<BaseData<List<GankData>>>() {
            @Override
            public void onSuccess(BaseData<List<GankData>> response) {
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
        BaseRequest<BaseData<List<GankData>>> baseGankRequest = new BaseRequest<BaseData<List<GankData>>>();
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("type", Constants.ALL);
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("page", page);

        ResponseCallback<BaseData<List<GankData>>> gankLastDataResponseCallback = new ResponseCallbackImpl<BaseData<List<GankData>>>() {
            @Override
            public void onSuccess(BaseData<List<GankData>> response) {
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
        BaseRequest<BaseData<List<Img>>> baseGankRequest = new BaseRequest<BaseData<List<Img>>>();
        ResponseCallback<BaseData<List<Img>>> gankLastDataResponseCallback = new ResponseCallbackImpl<BaseData<List<Img>>>() {
            @Override
            public void onSuccess(BaseData<List<Img>> response) {
                getMvpView().returnImg(response);
            }
        };


        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        RequestImg(baseGankRequest);
    }


}
