package com.ty.dagger.daggerdemo.mvp.ui.activity.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.ui.adapter.viewpageradapter.PhotoViewPagerAdapter;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;
import com.ty.dagger.daggerdemo.mvp.widget.statuslayout.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ty on 2018/1/29.
 */

public class PhotoActivity extends BaseActivity implements PhotoViewPagerAdapter.PhotoItemOnClickListener {


    @BindView(R.id.photo_img)
    PhotoView mPhotoImg;
    @BindView(R.id.photo_viewpager)
    ViewPager mPhotoViewpager;

    PhotoViewPagerAdapter mPhotoViewPagerAdapter;

    int type = -1;
    String imgUrl = "";
    List<String> imgUrls = new ArrayList<>();
    @BindView(R.id.photo_num_tv)
    TextView mPhotoNumTv;
    private int mCurrentPos = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        StatusBarUtils.setTranslucentStatusBar(PhotoActivity.this, mPhotoImg, 0);
        ButterKnife.bind(this);
        getIntentData();
//        imgUrl="http://t2.hddhhn.com/uploads/tu/201709/9999/b0d28560cf.jpg";

        showImg();
    }

    private void showImg() {
        if (type == 0) {
            if (!imgUrl.equals("")) {
                Glide.with(this).load(imgUrl).centerCrop().into(mPhotoImg);
            } else {
                Glide.with(this).load("http://t2.hddhhn.com/uploads/tu/201709/9999/b0d28560cf.jpg")
                        .centerCrop()
                        .into(mPhotoImg);
            }
        } else if (type == 1) {
            mPhotoImg.setVisibility(View.GONE);
            mPhotoViewpager.setVisibility(View.VISIBLE);
            mPhotoNumTv.setVisibility(View.VISIBLE);
            mPhotoNumTv.setText("1/"+imgUrls.size());
            mPhotoViewPagerAdapter = new PhotoViewPagerAdapter(imgUrls, this);
            mPhotoViewPagerAdapter.setPhotoItemOnClickListener(this);
            mPhotoViewpager.setAdapter(mPhotoViewPagerAdapter);

            mPhotoViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    if (mCurrentPos > position) {
                        mPhotoViewPagerAdapter.setNextPosition(0);
//                        Log.d("instantiateItem", "onPageSelected: "+position+"  <--");
                    }
                    if (mCurrentPos < position) {
                        mPhotoViewPagerAdapter.setNextPosition(2);
//                        Log.d("instantiateItem", "onPageSelected: "+position+"  -->");
                    }
                    mCurrentPos = position;
                    mPhotoNumTv.setText(mCurrentPos+1+"/"+imgUrls.size());
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo;
    }

    public void getIntentData() {
        type = getIntent().getIntExtra("type", -1);
        if (type == 0) {
            imgUrl = getIntent().getStringExtra("imgUrl");
        } else if (type == 1) {
            imgUrls = getIntent().getStringArrayListExtra("imgUrls");
        }

    }


    @OnClick(R.id.photo_img)
    public void onViewClicked() {
        ActivityCompat.finishAfterTransition(PhotoActivity.this);
    }

    @Override
    public void onPhotoClick() {
//        ActivityCompat.finishAfterTransition(PhotoActivity.this);
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }


}
