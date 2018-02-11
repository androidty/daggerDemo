package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.ApiService;
import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func2;
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
                GankData gankData = (GankData) response;


                baseRequest.getResponseCallback().onSuccess(response);
            }
        });
    }

    public <T> void RequestCombiData(final BaseGankRequest<T> baseRequest) {
        Observable observable1 = mApiService.getGankDataList(baseRequest.getHashMap().get("type").toString
                (), baseRequest
                .getIntegerHashMap().get("page")).subscribeOn(Schedulers.io());
        Observable observable2 = mApiService.getGankDataList(Constants.FULI, baseRequest.getIntegerHashMap
                ().get("page")).subscribeOn
                (Schedulers.io
                ());
        Observable.zip(observable1, observable2, new Func2<T, T, T>() {
            @Override
            public T call(T t, T t2) {
                GankData gankData1 = (GankData) t;
                GankData gankData2 = (GankData) t2;
                List<GankLastData> gankLastDataList2 = (List<GankLastData>) gankData2.getResults();
                for (int i = 0; i < gankLastDataList2.size(); i++) {
                    ((List<GankLastData>) gankData1.getResults()).get(i).setSource(
                            (gankLastDataList2.get(i).getUrl()));
                }
                return (T) gankData1;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                Log.d("onNextaa", "onNext");
                baseRequest.getResponseCallback().onSuccess((T) o);
            }
        });


    }


    public V getMvpView() {
        return mMvpView;
    }
}
