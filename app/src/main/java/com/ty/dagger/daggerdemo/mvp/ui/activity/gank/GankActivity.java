package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2017/12/13.
 */

public class GankActivity extends BaseActivity implements GankContract.View{

    @Inject
    GankContract.Presenter<GankContract.View> mGankPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank);
        mGankPresenter.getGankData();
    }

    @Override
    protected void initInjector() {
        mGankPresenter.onAttach(this);
        getActivityComponent().inject(this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void showData(GankData<List<GankLastData>> gankLastDatas) {
        Log.d("GankActivity", "showData: "+gankLastDatas.getResults().get(0).getDesc());
    }
}
