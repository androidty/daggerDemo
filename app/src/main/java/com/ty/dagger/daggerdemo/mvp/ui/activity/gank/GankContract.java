package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

/**
 * Created by ty on 2017/12/13.
 */

public class GankContract {

    public interface Presenter<V extends GankContract.View> extends MvpPresenter<V> {
        void getGankData();

        void onAttach(V view);

        void onDetach();

        void getBanners();
    }

    public interface View extends MvpView{
        void showData(BaseData<List<GankData>> gankLastDatas);

        void showBanners(List<String> imgs);
    }
}
