package com.ty.dagger.daggerdemo.mvp.data.remote;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankResponse;

/**
 * Created by ty on 2018/1/4.
 */

public  abstract  class ResponseCallbackImpl<T> implements ResponseCallback<T>{
    @Override
    public void onStart() {

    }

    @Override
    public abstract  void onSuccess(T response);

    @Override
    public void onFailed(BaseGankResponse response) {

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
