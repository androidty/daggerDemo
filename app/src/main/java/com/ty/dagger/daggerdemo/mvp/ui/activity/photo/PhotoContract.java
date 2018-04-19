package com.ty.dagger.daggerdemo.mvp.ui.activity.photo;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.entity.Img;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

/**
 * Created by ty on 2018/4/19.
 */

public class PhotoContract {
    public interface View extends MvpView{
        void returnPhotos(BaseData<List<Img>> photoes);
    }


    public interface Presenter<V extends PhotoContract.View> extends MvpPresenter<V>{
        void requestPhotos(int num);
    }
}
