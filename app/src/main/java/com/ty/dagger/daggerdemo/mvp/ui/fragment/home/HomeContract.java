package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.entity.Img;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

/**
 * Created by ty on 2018/2/6.
 */

public interface HomeContract {
     interface View extends MvpView {
        void returnAllData(BaseData<List<GankData>> gankLastDatas);

        void returnMoreData(BaseData<List<GankData>> gankLastDatas);
        void returnImg(BaseData<List<Img>> imgs);
    }

     interface Presenter<V extends HomeContract.View> extends MvpPresenter<V> {
        void requestAllData();

        void getMoreData(int page);

        void requestImg();
    }
}
