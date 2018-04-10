package com.ty.dagger.daggerdemo.mvp.utils;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by ty on 2018/4/10.
 * glide 升级到4.0以后添加一个继承自AppGlideModule的类即可用GlideApp调用之前的centerCrop和fitCenter方法
 */
@GlideModule
public final class MyAppGlideModule extends AppGlideModule {
}
