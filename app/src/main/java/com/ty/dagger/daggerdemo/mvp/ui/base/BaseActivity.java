package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.TyApplication;
import com.ty.dagger.daggerdemo.mvp.di.component.ActivityComponent;
import com.ty.dagger.daggerdemo.mvp.di.component.DaggerActivityComponent;
import com.ty.dagger.daggerdemo.mvp.di.module.ActivityModule;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

/**
 * Created by ty on 2017/12/11.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        initActivityComponent();
        initData();
        initInjector();
        Log.d("gank", "onCreate: BaseActivity");
    }

    protected abstract void initInjector();

    //    public abstract void initView();
    public abstract void initData();

    public ActivityComponent getActivityComponent() {
        Log.d("gank", "getActivityComponent: ");
        return mActivityComponent;
    }

    private void initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((TyApplication) getApplication()).getApplicationComponent())
                .build();

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
}
