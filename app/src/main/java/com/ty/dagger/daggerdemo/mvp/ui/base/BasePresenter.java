package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.ApiService;
import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;


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


    public <T> void RequestNormalData(final BaseRequest<T> baseRequest) {

        mApiService.getGankDataList(baseRequest.getHashMap().get("type").toString(), baseRequest
                .getIntegerHashMap().get("page"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                baseRequest.getResponseCallback().onSuccess((T) o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }


        });
    }

    public <T> void RequestCombiData(final BaseRequest<T> baseRequest) {

        Observable observable1 = mApiService.getGankDataList(baseRequest.getHashMap().get("type").toString
                (), baseRequest
                .getIntegerHashMap().get("page")).subscribeOn(Schedulers.io());
        Observable observable2 = mApiService.getGankDataList(Constants.FULI, baseRequest.getIntegerHashMap
                ().get("page")).subscribeOn
                (Schedulers.io());
        Observable.zip(observable1, observable2, new BiFunction<T, T, T>() {

            @Override
            public T apply(T t, T t2) throws Exception {
                BaseData gankData1 = (BaseData) t;
                BaseData gankData2 = (BaseData) t2;
                List<GankData> gankLastDataList2 = (List<GankData>) gankData2.getResults();
                for (int i = 0; i < gankLastDataList2.size(); i++) {
                    ((List<GankData>) gankData1.getResults()).get(i).setSource(
                            (gankLastDataList2.get(i).getUrl()));
                }
                return (T) gankData1;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer() {

            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                baseRequest.getResponseCallback().onSuccess((T) o);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    public <T> void RequestImg(final BaseRequest<T> baseRequest) {
        mApiService.getImgs().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        baseRequest.getResponseCallback().onSuccess((T) o);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public <T> void requestData(final BaseRequest<T> request) {
        request.getObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object o) {
                        request.getResponseCallback().onSuccess((T) o);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("HttpOnError", "onError: "+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public V getMvpView() {
        return mMvpView;
    }
}
