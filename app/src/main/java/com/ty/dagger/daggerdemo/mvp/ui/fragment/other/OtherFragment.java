package com.ty.dagger.daggerdemo.mvp.ui.fragment.other;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.entity.ImgList;
import com.ty.dagger.daggerdemo.mvp.ui.activity.photo.PhotoActivity;
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

public class OtherFragment extends BaseFragment implements OtherContract.View, BaseQuickAdapter
        .RequestLoadMoreListener {
    @Inject
    OtherPresenter<OtherContract.View> mPresenter;
    @BindView(R.id.other_rv)
    RecyclerView mOtherRv;
    Unbinder unbinder;

    int page = 1, count = 6;

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
        mOtherAdapter = new OtherAdapter(R.layout.item_other, new ArrayList<ImgList>());
        mOtherRv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mOtherAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        mOtherRv.setAdapter(mOtherAdapter);
        mOtherAdapter.setOnLoadMoreListener(this, mOtherRv);
        mOtherAdapter.disableLoadMoreIfNotFullPage();
        mOtherRv.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                openPhotoActivity(position);
            }
        });
    }

    private void openPhotoActivity(int position) {
        //把编号传过去
        Intent intent = new Intent(mBaseActivity, PhotoActivity.class);
        intent.putExtra("type", -1);
        intent.putExtra("num", mOtherAdapter.getItem(position).getNum());
        startActivity(intent);
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
        mOtherAdapter.setNewData(imgList.getResults());
    }

    @Override
    public void returnMoreImgList(BaseData<List<ImgList>> imgList) {
        if (imgList.getResults().size() == 0) {
            mOtherAdapter.loadMoreEnd(true);
            mOtherAdapter.addFooterView(getLayoutInflater().inflate(R.layout.item_other_footer, null));
        } else {
            mOtherAdapter.removeAllFooterView();
            mOtherAdapter.addData(imgList.getResults());
            mOtherAdapter.loadMoreComplete();
        }

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

    @Override
    public void onLoadMoreRequested() {
        page++;//进行page+1
        mPresenter.loadMoreImgList(page * count, count);
    }
}
