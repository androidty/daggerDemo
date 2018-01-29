package com.ty.dagger.daggerdemo.mvp.di.module;

import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankContract;
import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ty on 2017/12/15.
 */
@Module
public class ActivityModule {
    private final BaseActivity mActivity;

    public ActivityModule(BaseActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    public BaseActivity provideActivity() {
        return mActivity;
    }

    @Provides
    public GankContract.Presenter<GankContract.View> provideGankPresenter(GankPresenter<GankContract.View> presenter) {
        return presenter;
    }

}
