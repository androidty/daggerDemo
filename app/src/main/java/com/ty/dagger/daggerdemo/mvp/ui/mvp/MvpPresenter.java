package com.ty.dagger.daggerdemo.mvp.ui.mvp;

/**
 * Created by ty on 2017/12/11.
 */

public interface MvpPresenter<V extends MvpView> {
    void onAttach(V view);

    void onDetach();

}
