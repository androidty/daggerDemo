package com.ty.dagger.daggerdemo.mvp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ty on 2017/12/11.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {

}
