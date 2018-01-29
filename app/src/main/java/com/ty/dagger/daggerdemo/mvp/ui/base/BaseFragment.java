package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.support.v4.app.Fragment;

import com.ty.dagger.daggerdemo.mvp.di.component.ActivityComponent;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

/**
 * Created by ty on 2018/1/10.
 */

public abstract class BaseFragment extends Fragment implements MvpView {

    private BaseActivity mBaseActivity;



    public abstract int getLayoutId();

    public abstract void initViews();

    public abstract void injectView();

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showToast(String str) {

    }

    @Override
    public void showToast(int resId) {

    }

    @Override
    public void showLoadingFail() {

    }

    @Override
    public void showLoadingFail(String error) {

    }


    public ActivityComponent getActivityComponent() {
        return mBaseActivity.getActivityComponent();
    }
}
