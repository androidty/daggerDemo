package com.ty.dagger.daggerdemo.mvp.ui.fragment.other;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.entity.ImgList;
import com.ty.dagger.daggerdemo.mvp.ui.adapter.otheradapter.OtherAdapter;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ty on 2018/2/6.
 */

public class OtherFragment extends BaseFragment implements OtherContract.View {
    @Inject
    OtherPresenter<OtherContract.View> mPresenter;
    @BindView(R.id.other_rv)
    RecyclerView mOtherRv;
    Unbinder unbinder;

    private OtherAdapter mOtherAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_other;
    }

    @Override
    public void initViews() {

        initRecycler();
        initData();
    }

    private void initRecycler() {
        mOtherAdapter = new OtherAdapter(R.layout.item_other,new ArrayList<ImgList>());
        mOtherRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mOtherRv.setAdapter(mOtherAdapter);
//        mOtherAdapter.setOnLoadMoreListener(this, mOtherRv);
//        mOtherAdapter.disableLoadMoreIfNotFullPage();
    }
    private void initData() {
        mPresenter.requestImgList();
    }
    @Override
    public void injectView() {
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }



    @Override
    public void returnImgList(BaseData<List<ImgList>> imgList) {
        Log.d("returnImgList", "returnImgList: " + imgList.getResults().size());
        mOtherAdapter.setNewData(imgList.getResults());
    }

    @Override
    public void returnMoreImgList(BaseData<List<ImgList>> imgList) {

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
        unbinder.unbind();
    }
}
