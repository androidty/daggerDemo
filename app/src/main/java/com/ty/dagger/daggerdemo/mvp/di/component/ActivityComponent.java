package com.ty.dagger.daggerdemo.mvp.di.component;

import com.ty.dagger.daggerdemo.mvp.di.PerActivity;
import com.ty.dagger.daggerdemo.mvp.di.module.ActivityModule;
import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankActivity;
import com.ty.dagger.daggerdemo.mvp.ui.activity.photo.PhotoActivity;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.home.HomeFragment;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.other.OtherFragment;

import dagger.Component;

/**
 * Created by ty on 2017/12/15.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(GankActivity gankActivity);
    void inject(PhotoActivity photoActivity);

    void inject(HomeFragment homeFragment);

    void inject(OtherFragment otherFragment);

}
