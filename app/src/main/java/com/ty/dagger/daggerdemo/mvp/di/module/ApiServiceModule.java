package com.ty.dagger.daggerdemo.mvp.di.module;

import com.ty.dagger.daggerdemo.mvp.api.ApiService;
import com.ty.dagger.daggerdemo.mvp.api.config.Constants;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
                (5000, TimeUnit.MILLISECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel
                (HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                //获取request
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                List<String> headers = request.headers(Constants.BASEURL);
                //这里可以添加公共请求头
                //....
                //区分要用哪个baseurl
                if (headers != null && headers.size() > 0) {
                    builder.removeHeader(Constants.BASEURL);
                    HttpUrl oldHttpUrl = request.url();
                    HttpUrl newBaseUrl = null;
                    if (headers.contains(Constants.IMG)) {
                        newBaseUrl = HttpUrl.parse(Constants.IMGURL);
                    } else if (headers.contains(Constants.GANK)) {
                        newBaseUrl = HttpUrl.parse(Constants.GANKURL);
                    }else if(headers.contains(Constants.HUOBI)){
                        newBaseUrl = HttpUrl.parse(Constants.HUOBI_URL);
                    } else {
                        newBaseUrl = oldHttpUrl;
                    }
                    HttpUrl newFullUrl = oldHttpUrl.newBuilder().scheme(newBaseUrl.scheme())
                            .host(newBaseUrl.host()).port(newBaseUrl.port()).build();
                    return chain.proceed(builder.url(newFullUrl).build());
                } else {
                    return chain.proceed(request);
                }

            }
        }).build();
    }

    @Provides
    @Singleton
    protected RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    protected GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    protected Retrofit provideRetrofit(RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                                       GsonConverterFactory gsonConverterFactory, OkHttpClient
                                               okHttpClient) {
        return new Retrofit.Builder().addCallAdapterFactory(rxJava2CallAdapterFactory).addConverterFactory
                (gsonConverterFactory).baseUrl(Constants.GANKURL).client(okHttpClient).build();
    }


    @Provides
    @Singleton
    protected ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


}
