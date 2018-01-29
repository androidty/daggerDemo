package com.ty.dagger.daggerdemo;

import android.app.Application;
import android.content.Context;

import com.ty.dagger.daggerdemo.mvp.di.component.ApplicationComponent;
import com.ty.dagger.daggerdemo.mvp.di.component.DaggerApplicationComponent;
import com.ty.dagger.daggerdemo.mvp.di.module.ApplicationModule;

/**
 * Created by ty on 2017/12/11.
 */

public class TyApplication extends Application {
    private static Context mContext;
    private ApplicationComponent mApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new
                ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return ((TyApplication) mContext.getApplicationContext()).mApplicationComponent;
    }
}
