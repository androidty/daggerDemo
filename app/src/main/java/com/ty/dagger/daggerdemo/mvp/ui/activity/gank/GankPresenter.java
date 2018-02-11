package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import com.ty.dagger.daggerdemo.mvp.api.TestApi;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2017/12/13.
 */

public class GankPresenter<V extends GankContract.View> extends BasePresenter<V> implements
        GankContract.Presenter<V> {
    private static final String TAG = "tytytyty";

    @Inject
    public GankPresenter() {

    }

    @Override
    public void getGankData() {

    }

    @Override
    public void getBanners() {
        List<String> imgs = new ArrayList<>();
        imgs.add(TestApi.img1);
        imgs.add(TestApi.img2);
        imgs.add(TestApi.img3);
        imgs.add(TestApi.img4);
        getMvpView().showBanners(imgs);
    }


}
