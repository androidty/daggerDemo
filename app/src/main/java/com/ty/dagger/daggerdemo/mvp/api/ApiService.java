package com.ty.dagger.daggerdemo.mvp.api;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ty on 2017/12/11.
 */

public interface ApiService<T> {
    /**
     * http://gank.io/api/data/Android/10/1

     http://gank.io/api/data/福利/10/1

     http://gank.io/api/data/iOS/20/2

     http://gank.io/api/data/all/20/2
     */


    //all
    @GET("data/{type}/20/{page}")
     Observable<GankData<List<GankLastData>>> getGankDataList(@Path("type")String type, @Path("page")int page);


}
