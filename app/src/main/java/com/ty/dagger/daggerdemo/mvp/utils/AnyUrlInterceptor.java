package com.ty.dagger.daggerdemo.mvp.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author ty
 * @date 2019/11/22.
 * GitHub：
 * email：
 * description：
 */
public class AnyUrlInterceptor implements Interceptor {
    private String baseUrl;
    public AnyUrlInterceptor(String baseUrl){
        this.baseUrl = baseUrl;
    }
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        //获取request
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        HttpUrl oldHttpUrl = request.url();
        HttpUrl newBaseUrl =HttpUrl.parse(oldHttpUrl.toString());
        String oldUrl = oldHttpUrl.toString();
        if(!oldUrl.startsWith(baseUrl)){
            HttpUrl newFullUrl = oldHttpUrl.newBuilder().scheme(newBaseUrl.scheme())
                    .host(newBaseUrl.host()).port(newBaseUrl.port()).build();
            return chain.proceed(builder.url(newFullUrl).build());
        }
        return chain.proceed(request);
    }
}
