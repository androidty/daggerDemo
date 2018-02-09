package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

/**
 * Created by ty on 2018/2/6.
 */

public class HomeContract {
    public interface View extends MvpView {
        void returnAllData(GankData<List<GankLastData>> gankLastDatas);
    }

    public interface Presenter<V extends HomeContract.View> extends MvpPresenter<V>{
        void requestAllData();
    }
}
