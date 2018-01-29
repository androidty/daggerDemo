package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.ApiService;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ty on 2017/12/11.
 */

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private V mMvpView;

    @Inject
    public ApiService mApiService;

    @Inject
    public BasePresenter() {
    }


    @Override
    public void onAttach(V view) {
        mMvpView = view;
    }

    @Override
    public void onDetach() {

    }

    private static final String TAG = "tytytyty";

    public <T> void RequestNormalData(final BaseGankRequest<T> baseRequest) {
        mApiService.getGankDataList(baseRequest.getHashMap().get("type").toString(), baseRequest
                .getIntegerHashMap().get("page"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<T>
                () {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                baseRequest.getResponseCallback().onError(e);
            }

            @Override
            public void onNext(T response) {
                if (response instanceof GankData) {
                    GankData<List<GankLastData>> result = (GankData<List<GankLastData>>) response;
                    Log.d(TAG, "onNext: " + result.getResults().get(0).getUrl());
                    baseRequest.getResponseCallback().onSuccess(response);
                }


            }
        });

    }

    public V getMvpView() {
        return mMvpView;
    }
}
