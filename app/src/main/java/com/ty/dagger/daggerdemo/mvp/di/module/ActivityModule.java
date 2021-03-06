package com.ty.dagger.daggerdemo.mvp.di.module;

import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankContract;
import com.ty.dagger.daggerdemo.mvp.ui.activity.gank.GankPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.activity.photo.PhotoContract;
import com.ty.dagger.daggerdemo.mvp.ui.activity.photo.PhotoPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.other.OtherContract;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.other.OtherPresenter;

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
    public GankContract.Presenter<GankContract.View> provideGankPresenter(GankPresenter<GankContract.View>
                                                                                  presenter) {
        return presenter;
    }


//    @Provides
//    public HomeContract.Presenter<HomeContract.View> provideHomePresenter(HomePresenter<HomeContract.View>
//                                                                                  presenter) {
//        return presenter;
//    }

    @Provides
    public OtherContract.Presenter<OtherContract.View> provideOtherPresenter(OtherPresenter<OtherContract
            .View>
                                                                                     presenter) {
        return presenter;
    }

    @Provides
    public PhotoContract.Presenter<PhotoContract.View> providePhotoPresenter(PhotoPresenter<PhotoContract
            .View> presenter) {
        return presenter;
    }

}
