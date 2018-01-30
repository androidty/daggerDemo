package com.ty.dagger.daggerdemo.mvp.ui.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.TyApplication;
import com.ty.dagger.daggerdemo.mvp.di.component.ActivityComponent;
import com.ty.dagger.daggerdemo.mvp.di.component.DaggerActivityComponent;
import com.ty.dagger.daggerdemo.mvp.di.module.ActivityModule;
import com.ty.dagger.daggerdemo.mvp.ui.activity.splash.SplashActivity;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import butterknife.ButterKnife;

/**
 * Created by ty on 2017/12/11.
 */

public abstract class BaseActivity extends AppCompatActivity implements MvpView {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        ButterKnife.bind(this);
        initTranslucentStatus();
        initActivityComponent();
        initInjector();
        initView();
    }

    protected abstract void initInjector();

    public abstract void initView();


    public abstract int getLayoutId();

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

    /**
     * 设置状态栏
     */
    private void initTranslucentStatus() {
        Window window = getWindow();
        //透明
        if (!(this instanceof SplashActivity)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View
                        .SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
        // 沉浸式
        if (!(this instanceof SplashActivity)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            } else {
                SystemBarTintManager tintManager = new SystemBarTintManager(this);
                tintManager.setStatusBarTintEnabled(true);
                tintManager.setStatusBarTintColor(getResources().getColor(R.color.colorPrimary));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {

            }
        }
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
