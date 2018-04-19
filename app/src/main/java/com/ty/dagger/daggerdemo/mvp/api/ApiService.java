package com.ty.dagger.daggerdemo.mvp.api;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.entity.Img;
import com.ty.dagger.daggerdemo.mvp.entity.ImgList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by ty on 2017/12/11.
 */

public interface ApiService<T> {
    /**
     * http://gank.io/api/data/Android/10/1
     * <p>
     * http://gank.io/api/data/福利/10/1
     * <p>
     * http://gank.io/api/data/iOS/20/2
     * <p>
     * http://gank.io/api/data/all/20/2
     * <p>
     * http://gank.io/api/random/data/福利/20
     */


    //all
    @Headers("baseurl:gank")
    @GET("api/data/{type}/10/{page}")
    Observable<BaseData<List<GankData>>> getGankDataList(@Path("type") String type, @Path("page") int
            page);


    @Headers("baseurl:gank")
    @GET("api/random/data/{type}/{count}")
    Observable<BaseData<List<GankData>>> getRandomDataList(@Path("type") String type, @Path("count") int
            count);


    @Headers("baseurl:img")
    @GET("demodev/image/findAll")
    Observable<BaseData<List<Img>>> getImgs();


    @Headers("baseurl:img")
    @POST("demodev/image/findList")
    Observable<BaseData<List<ImgList>>> getImgList(@Query("from") int from, @Query("count") int count);

    @FormUrlEncoded
    @Headers("baseurl:img")
    @POST("demodev/image/findImgsByNum")
    Observable<BaseData<List<Img>>> getImgsByNum(@Field("num") int num);

}
