package com.ty.dagger.daggerdemo.mvp.ui.activity.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;
import com.ty.dagger.daggerdemo.mvp.widget.statuslayout.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ty on 2018/1/29.
 */

public class PhotoActivity extends BaseActivity {


    String imgUrl;
    @BindView(R.id.photo_img)
    PhotoView mPhotoImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        StatusBarUtils.setTranslucentStatusBar(PhotoActivity.this,mPhotoImg,0);
        ButterKnife.bind(this);
        getIntentData();
//        imgUrl="http://t2.hddhhn.com/uploads/tu/201709/9999/b0d28560cf.jpg";
        Glide.with(this).load(imgUrl).centerCrop().into(mPhotoImg);
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
        imgUrl = getIntent().getStringExtra("imgUrl");
    }


    @OnClick(R.id.photo_img)
    public void onViewClicked() {
        ActivityCompat.finishAfterTransition(PhotoActivity.this);
    }
}
