package com.ty.dagger.daggerdemo.mvp.data;

import okhttp3.internal.http.HttpMethod;
import rx.Observable;

/**
 * Created by ty on 2017/12/11.
 */

public interface DataManager {
    /**
     *
     * @param method 访问方法 GET/POST
     * @param url   访问链接
     * @param json post参数
     * @param <T>
     * @return Observable<T>
     */
    <T> Observable<T> RequestWithoutHead(HttpMethod method, String url, String json);
}
