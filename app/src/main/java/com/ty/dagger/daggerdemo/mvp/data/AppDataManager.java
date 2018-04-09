package com.ty.dagger.daggerdemo.mvp.data;

import io.reactivex.Observable;
import okhttp3.internal.http.HttpMethod;

/**
 * Created by ty on 2018/1/4.
 */

public class AppDataManager implements DataManager {
    @Override
    public <T> Observable<T> RequestWithoutHead(HttpMethod method, String url, String json) {
        return null;
    }
}
