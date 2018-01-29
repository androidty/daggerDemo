package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseGankRequest;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2017/12/13.
 */

public class GankPresenter<V extends GankContract.View> extends BasePresenter<V> implements
        GankContract.Presenter<V> {
    private static final String TAG = "tytytyty";

    @Inject
    public GankPresenter() {

    }

    @Override
    public void getGankData() {

        BaseGankRequest<GankData<List<GankLastData>>> baseGankRequest = new BaseGankRequest<GankData<List<GankLastData>>>();
        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("type", Constants.ANDROID);
        HashMap<String, Integer> integerHashMap = new HashMap<>();
        integerHashMap.put("page", 1);

        ResponseCallback<GankData<List<GankLastData>>> gankLastDataResponseCallback = new ResponseCallbackImpl<GankData<List<GankLastData>>>() {
            @Override
            public void onSuccess(GankData<List<GankLastData>> response) {
                Log.d("GankActivity", "onSuccess: "+response.getResults().get(0).getDesc()+"  " +
                        "\n"+response.getResults().get(0).getCreatedAt());
                getMvpView().showData(response);
            }
        };

        baseGankRequest.setIntegerHashMap(integerHashMap);
        baseGankRequest.setHashMap(stringHashMap);
        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        RequestNormalData(baseGankRequest);

    }


}
