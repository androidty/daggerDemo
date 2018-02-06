package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

/**
 * Created by ty on 2018/2/6.
 */

public class HomeContract {
    public interface View extends MvpView {

    }

    public interface Presenter<V extends HomeContract.View> extends MvpPresenter<V>{

    }
}
