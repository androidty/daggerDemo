package com.ty.dagger.daggerdemo.mvp.data.remote;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankResponse;

/**
 * Created by ty on 2018/1/4.
 */

public interface ResponseCallback<T> {

    /**
     * 开始的时候
     */
    void onStart();

    /**
     * success为true
     *
     * @param response
     */
    void onSuccess(T response);

    /**
     * success为false
     */
    void onFailed(BaseGankResponse response);

    /**
     * 异常的时候
     *
     * @param throwable
     */
    void onError(Throwable throwable);

    /**
     * 在finish的时候
     */
    void onComplete();
}
