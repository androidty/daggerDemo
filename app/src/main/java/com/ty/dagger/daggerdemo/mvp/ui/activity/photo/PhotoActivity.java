package com.ty.dagger.daggerdemo.mvp.ui.activity.photo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;

/**
 * Created by ty on 2018/1/29.
 */

public class PhotoActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        PhotoView photoView = findViewById(R.id.photo_img);
        Glide.with(this).load("http://t2.hddhhn.com/uploads/tu/201709/9999/82001d5173.jpg").into(photoView);
    }

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return 0;
    }


}
