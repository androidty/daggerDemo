package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;
import com.ty.dagger.daggerdemo.mvp.widget.banner.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.transformer.DepthPageTransformer;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by ty on 2017/12/13.
 */

public class GankActivity extends BaseActivity implements GankContract.View {

    @Inject
    GankContract.Presenter<GankContract.View> mGankPresenter;

    @BindView(R.id.banner)
    Banner mBanner;
//    @BindView(R.id.head_layout)
//    LinearLayout mHeadLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
//    @BindView(R.id.collapsingToolbarLayout)
//    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;




    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
        mGankPresenter.onAttach(this);
    }



    @Override
    public void initView() {
        mBanner = findViewById(R.id.banner);
        mGankPresenter.getBanners();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_gank;
    }


    private void initBanner(Banner banner, List<String> images, int time) {
        //设置banner样式
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.ScaleInOut);
        banner.setPageTransformer(true,new DepthPageTransformer());
        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(time);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }


    @Override
    public void showData(GankData<List<GankLastData>> gankLastDatas) {
        Log.d("GankActivity", "showData: " + gankLastDatas.getResults().get(0).getDesc());
    }

    @Override
    public void showBanners(List<String> imgs) {
        Toast.makeText(this, ""+(mBanner==null), Toast.LENGTH_SHORT).show();

        initBanner(mBanner,imgs,3000);
    }
}
