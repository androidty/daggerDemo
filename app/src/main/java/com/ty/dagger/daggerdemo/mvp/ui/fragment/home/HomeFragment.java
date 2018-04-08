package com.ty.dagger.daggerdemo.mvp.ui.fragment.home;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.entity.Img;
import com.ty.dagger.daggerdemo.mvp.ui.adapter.recyclerviewadapter.HomeAdapter;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ty on 2018/2/6.
 * xshell免费下载链接
 * http://www.netsarang.com/download/free_license.html
 */

public class HomeFragment extends BaseFragment implements HomeContract.View,
        BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.home_recyclerview)
    RecyclerView mHomeRecyclerview;
    @BindView(R.id.home_swipeRefreshLayout)
    SwipeRefreshLayout mHomeSwipeRefreshLayout;
    Unbinder unbinder;
    int page = 1;

    private HomeAdapter mHomeAdapter;
    @Inject
    HomeContract.Presenter<HomeContract.View> mPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews() {
        mPresenter.requestAllData();

        initData();
        initRecycler();
    }

    private void initRecycler() {
        mHomeAdapter = new HomeAdapter(R.layout.item_home, new ArrayList<GankLastData>());
        mHomeRecyclerview.setLayoutManager(new LinearLayoutManager(mBaseActivity));
        mHomeRecyclerview.setAdapter(mHomeAdapter);
        mHomeAdapter.setOnLoadMoreListener(this, mHomeRecyclerview);
        mHomeAdapter.disableLoadMoreIfNotFullPage();
    }

    private void initData() {
    }

    @Override
    public void injectView() {
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }

    @Override
    public void returnAllData(GankData<List<GankLastData>> gankLastDatas) {
        mHomeAdapter.setNewData(gankLastDatas.getResults());
        mPresenter.requestImg();
    }

    @Override
    public void returnMoreData(GankData<List<GankLastData>> gankLastDatas) {

        mHomeAdapter.addData(gankLastDatas.getResults());
        mHomeAdapter.loadMoreComplete();
    }

    @Override
    public void returnImg(GankData<List<Img>> imgs) {
        Log.d("returnImg", "returnImg: "+imgs.getResults().size());
        List<String> img = new ArrayList<>();
        for (int i = 0; i <imgs.getResults().size(); i++) {
            img.add(imgs.getResults().get(i).getUrl());
        }
        mHomeAdapter.setImgs(img);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        page = 1;
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }


    @Override
    public void onLoadMoreRequested() {
        page++;//进行page+1
        mPresenter.getMoreData(page);
    }
}


