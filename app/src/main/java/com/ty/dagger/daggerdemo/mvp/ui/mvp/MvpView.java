package com.ty.dagger.daggerdemo.mvp.ui.mvp;

import android.support.annotation.StringRes;

/**
 * Created by ty on 2017/12/11.
 */

public interface MvpView {
    void showLoading();

    void hideLoading();

    void showToast(String str);

    void showToast(@StringRes int resId);

    void showLoadingFail();

    void showLoadingFail(String error);


}
