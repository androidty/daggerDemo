package com.ty.dagger.daggerdemo.mvp.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ty on 2017/12/15.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application){
        this.mApplication  = application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return mApplication;
    }
}
