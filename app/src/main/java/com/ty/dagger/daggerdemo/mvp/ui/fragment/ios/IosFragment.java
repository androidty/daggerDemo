package com.ty.dagger.daggerdemo.mvp.ui.fragment.ios;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseFragment;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.home.HomeContract;

import java.util.List;

/**
 * Created by ty on 2018/2/6.
 */

public class IosFragment extends BaseFragment implements HomeContract.View{
    @Override
    public int getLayoutId() {
        return R.layout.fragment_ios;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void injectView() {

    }

    @Override
    public void returnAllData(GankData<List<GankLastData>> gankLastDatas) {

    }
}
