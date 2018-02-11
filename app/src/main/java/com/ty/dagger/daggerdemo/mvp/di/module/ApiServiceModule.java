package com.ty.dagger.daggerdemo.mvp.di.module;

import com.ty.dagger.daggerdemo.mvp.api.ApiService;
import com.ty.dagger.daggerdemo.mvp.api.config.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ty on 2017/12/11.
 */
@Module
public class ApiServiceModule {


    @Provides
    @Singleton
    protected OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).readTimeout
                (5000, TimeUnit
                        .MILLISECONDS).addInterceptor(new HttpLoggingInterceptor().setLevel
                (HttpLoggingInterceptor.Level
                        .BODY)).build();
    }

    @Provides
    @Singleton
    protected RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    protected GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    protected ApiService provideApiService(RxJavaCallAdapterFactory rxJavaCallAdapterFactory,
                                           GsonConverterFactory gsonConverterFactory, OkHttpClient
                                                   okHttpClient) {
        return new Retrofit.Builder().addCallAdapterFactory(rxJavaCallAdapterFactory).addConverterFactory
                (gsonConverterFactory).baseUrl(Constants.GANKURL).client(okHttpClient).build().create
                (ApiService.class);
    }
}
