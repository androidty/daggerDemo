package com.ty.dagger.daggerdemo.mvp.ui.fragment.other;

import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.entity.ImgList;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

/**
 * Created by ty on 2018/4/17.
 */

public class OtherContract {
    public interface View extends MvpView {
        void returnImgList(BaseData<List<ImgList>> imgList);

        void returnMoreImgList(BaseData<List<ImgList>> imgList);
    }

    public interface Presenter<V extends OtherContract.View> extends MvpPresenter<V> {
        void requestImgList();

        void loadMoreImgList(int from,int count);
    }
}
