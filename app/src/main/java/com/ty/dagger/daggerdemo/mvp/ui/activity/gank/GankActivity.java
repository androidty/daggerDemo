package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.ui.adapter.viewpageradapter.GankPagerAdapter;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.android.AndroidFragment;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.home.HomeFragment;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.ios.IosFragment;
import com.ty.dagger.daggerdemo.mvp.ui.fragment.other.OtherFragment;
import com.ty.dagger.daggerdemo.mvp.widget.banner.GlideImageLoader;
import com.ty.dagger.daggerdemo.mvp.widget.statuslayout.StatusBarUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
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
        @BindView(R.id.head_layout)
        LinearLayout mHeadLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.tablayout)
    TabLayout mTablayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.nestedScrollView)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;



    private HomeFragment mHomeFragment;
    private AndroidFragment mAndroidFragment;
    private IosFragment mIosFragment;
    private OtherFragment mOtherFragment;

    private List<Fragment> mFragments = new ArrayList<>();
    private GankPagerAdapter mGankPagerAdapter;

    @Override
    protected void initInjector() {
        getActivityComponent().inject(this);
        mGankPresenter.onAttach(this);
    }


    @Override
    public void initView() {
//        StatusBarUtils.setStatusColor(this,0,0);
        StatusBarUtils.setTranslucentStatusBar(GankActivity.this,mToolbar,0);
        mGankPresenter.getBanners();
        mTablayout.setupWithViewPager(mViewpager);

       initAppBar();

       initFragments();



       mGankPagerAdapter = new GankPagerAdapter(getSupportFragmentManager(),mFragments);
       mViewpager.setAdapter(mGankPagerAdapter);
       mViewpager.setOnTouchListener(new View.OnTouchListener() {
           @Override
           public boolean onTouch(View view, MotionEvent motionEvent) {
//               view.getParent().requestDisallowInterceptTouchEvent(true);
               return false;
           }
       });

       mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               mViewpager.getParent().requestDisallowInterceptTouchEvent(true);
           }

           @Override
           public void onPageSelected(int position) {

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
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
        banner.setBannerAnimation(Transformer.ZoomIn);
//        banner.setPageTransformer(true, new DepthPageTransformer());
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

        initBanner(mBanner, imgs, 3000);
    }

    private void initAppBar(){
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs((verticalOffset)) >= appBarLayout.getTotalScrollRange()) {
                    StatusBarUtils.setStatusColor(GankActivity.this, getResources().getColor(R.color.colorPrimary));
                } else {
                    StatusBarUtils.setTranslucentStatusBar(GankActivity.this,mToolbar,0);
                }
            }
        });
    }

    private void initFragments(){
        if(mHomeFragment ==null){
            mHomeFragment = new HomeFragment();
            mFragments.add(mHomeFragment);
        }
        if(mAndroidFragment ==null){
            mAndroidFragment = new AndroidFragment();
            mFragments.add(mAndroidFragment);
        }
        if(mIosFragment ==null){
            mIosFragment = new IosFragment();
            mFragments.add(mIosFragment);
        }
        if(mOtherFragment ==null){
            mOtherFragment = new OtherFragment();
            mFragments.add(mOtherFragment);
        }
    }


}
