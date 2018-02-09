package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
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
        stringHashMap.put("type", Constants.FULI);
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
        RequestNormalData(baseGankRequest);
    }
}
