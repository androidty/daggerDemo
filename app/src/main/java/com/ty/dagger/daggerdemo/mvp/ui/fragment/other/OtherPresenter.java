package com.ty.dagger.daggerdemo.mvp.ui.fragment.other;

import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.entity.ImgList;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2018/4/17.
 */

public class OtherPresenter<V extends OtherContract.View> extends BasePresenter<V> implements OtherContract
        .Presenter<V> {

    @Inject
    public OtherPresenter(){

    }

    @Override
    public void requestImgList() {
        BaseRequest<BaseData<List<ImgList>>> baseGankRequest = new BaseRequest<BaseData<List<ImgList>>>();
        ResponseCallback<BaseData<List<ImgList>>> gankLastDataResponseCallback = new ResponseCallbackImpl<BaseData<List<ImgList>>>() {
            @Override
            public void onSuccess(BaseData<List<ImgList>> response) {
                getMvpView().returnImgList(response);
            }
        };
        baseGankRequest.setObservable(mApiService.getImgList(0,6));
        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        requestData(baseGankRequest);
    }

    @Override
    public void loadMoreImgList(int from,int count) {
        BaseRequest<BaseData<List<ImgList>>> baseGankRequest = new BaseRequest<BaseData<List<ImgList>>>();
        ResponseCallback<BaseData<List<ImgList>>> gankLastDataResponseCallback = new ResponseCallbackImpl<BaseData<List<ImgList>>>() {
            @Override
            public void onSuccess(BaseData<List<ImgList>> response) {
                getMvpView().returnMoreImgList(response);
            }
        };
        baseGankRequest.setObservable(mApiService.getImgList(from,count));
        baseGankRequest.setMethod("GET");
        baseGankRequest.setResponseCallback(gankLastDataResponseCallback);
        requestData(baseGankRequest);
    }
}
