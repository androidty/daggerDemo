package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.TestApi;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.huobi.HuoBiSign;
import com.ty.dagger.daggerdemo.mvp.huobi.entity.HuoBiAccount;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.ArrayList;
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
        getHuobi();
    }

    @Override
    public void getBanners() {
        List<String> imgs = new ArrayList<>();
        imgs.add(TestApi.img1);
        imgs.add(TestApi.img2);
        imgs.add(TestApi.img3);
        imgs.add(TestApi.img4);
        getMvpView().showBanners(imgs);
    }

    public void getHuobi(){
        BaseRequest<HuoBiAccount> baseGankRequest = new BaseRequest<HuoBiAccount>();
        ResponseCallback<HuoBiAccount> gankLastDataResponseCallback = new
                ResponseCallbackImpl<HuoBiAccount>() {
            @Override
            public void onSuccess(HuoBiAccount response) {
//                getMvpView().returnMoreImgList(response);

                Log.d(TAG, "onSuccess: "+response.getStatus());
                if(response.getStatus().equals("error")){
                    getMvpView().showToast(response.getErrmsg().toString());
                }else{

                getMvpView().showToast(response.getData().get(0).getId()+response.getData().get(0).getState());
                }
            }
        };
        baseGankRequest.setObservable(mApiService.getHuoBiAccount(HuoBiSign.getUrl()));
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        requestData(baseGankRequest);
    }


}
