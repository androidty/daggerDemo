package com.ty.dagger.daggerdemo.mvp.ui.activity.x5webview;

import android.os.Bundle;

import com.tencent.smtt.sdk.WebView;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ty on 2018/4/11.
 */

public class X5WebViewActivity extends BaseActivity {

    @BindView(R.id.x5webView)
    WebView mX5webView;

    String url;

    @Override
    protected void initInjector() {

    }

    @Override
    public void initView() {
        getIntentData();
        initX5WebView();
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_x5web;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    private void initX5WebView() {
        mX5webView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getIntentData() {
        url = getIntent().getStringExtra("url");
    }

}
