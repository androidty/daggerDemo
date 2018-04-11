package com.ty.dagger.daggerdemo;

import android.app.Application;
import android.content.Context;

import com.tencent.smtt.sdk.QbSdk;
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
        initX5WebSdk();
        mContext = this;
        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new
                ApplicationModule(this)).build();
        mApplicationComponent.inject(this);
    }

    private void initX5WebSdk() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        };

        QbSdk.initX5Environment(getApplicationContext(),cb);
    }

    public static ApplicationComponent getApplicationComponent() {
        return ((TyApplication) mContext.getApplicationContext()).mApplicationComponent;
    }
}
