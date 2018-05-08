package com.ty.dagger.daggerdemo.mvp.ui.activity.gank;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.api.TestApi;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;
import com.ty.dagger.daggerdemo.mvp.wallet.gate.BuildGate;
import com.ty.dagger.daggerdemo.mvp.wallet.gate.entity.GateBalance;
import com.ty.dagger.daggerdemo.mvp.wallet.huobi.HuoBiSign;
import com.ty.dagger.daggerdemo.mvp.wallet.huobi.entity.HuoBiAccount;

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
//        getHuobi();
        getGateBalance();
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


    /**
     * 获取火币accountid
     */
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

    public void getGateBalance(){
        BaseRequest<GateBalance> baseRequest = new BaseRequest<>();
        ResponseCallback<GateBalance> gateBalanceResponseCallback = new ResponseCallbackImpl<GateBalance>() {
            @Override
            public void onSuccess(GateBalance response) {
                Log.d(TAG, "onSuccess: "+response.getResult());
                getMvpView().showToast(response.getResult());
            }
        };
        baseRequest.setObservable(mApiService.getGateBalance(BuildGate.getHeaders(),BuildGate.getUrl()));
        baseRequest.setResponseCallback(gateBalanceResponseCallback);
        requestData(baseRequest);
    }


}
