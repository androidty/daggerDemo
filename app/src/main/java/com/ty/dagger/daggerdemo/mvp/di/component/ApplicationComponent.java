package com.ty.dagger.daggerdemo.mvp.di.component;

import android.app.Application;

import com.ty.dagger.daggerdemo.TyApplication;
import com.ty.dagger.daggerdemo.mvp.api.ApiService;
import com.ty.dagger.daggerdemo.mvp.di.module.ApiServiceModule;
import com.ty.dagger.daggerdemo.mvp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ty on 2017/12/15.
 * 步骤1：查找Module中是否存在创建该类的方法。
 * 步骤2：若存在创建类方法，查看该方法是否存在参数
 * 步骤2.1：若存在参数，则按从步骤1开始依次初始化每个参数
 * 步骤2.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 * 步骤3：若不存在创建类方法，则查找Inject注解的构造函数，
 * 看构造函数是否存在参数
 * 步骤3.1：若存在参数，则从步骤1开始依次初始化每个参数
 * 步骤3.2：若不存在参数，则直接初始化该类实例，一次依赖注入到此结束
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiServiceModule.class})
public interface ApplicationComponent {
    void inject(TyApplication tyApplication);

    ApiService getApiService();

    Application getApplication();
}
