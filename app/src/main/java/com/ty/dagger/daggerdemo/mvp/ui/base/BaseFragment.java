package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ty.dagger.daggerdemo.mvp.di.component.ActivityComponent;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ty on 2018/1/10.
 */

public abstract class BaseFragment extends Fragment implements MvpView {

    public BaseActivity mBaseActivity;
    private Unbinder mUnbinder;



    public abstract int getLayoutId();

    public abstract void initViews();

    public abstract void injectView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view  = inflater.inflate(getLayoutId(),container,false);
        injectView();
        mUnbinder = ButterKnife.bind(this,view);
        initViews();
        return view;
    }

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


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof BaseActivity){
            this.mBaseActivity = (BaseActivity) context;
        }
    }

    @Override
    public void onDetach() {
        mBaseActivity = null;
        super.onDetach();
    }



    public ActivityComponent getActivityComponent() {
        return mBaseActivity.getActivityComponent();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}
