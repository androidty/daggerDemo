package com.ty.dagger.daggerdemo.mvp.ui.activity.photo;

import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallback;
import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.entity.Img;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2018/4/19.
 */

public class PhotoPresenter<V extends PhotoContract.View> extends BasePresenter<V> implements PhotoContract
        .Presenter<V> {
    @Inject
    public PhotoPresenter() {

    }

    @Override
    public void requestPhotos(int num) {
        BaseRequest<BaseData<List<Img>>> baseRequest = new BaseRequest<BaseData<List<Img>>>();
        ResponseCallback<BaseData<List<Img>>> responseCallback = new
                ResponseCallbackImpl<BaseData<List<Img>>>() {
            @Override
            public void onSuccess(BaseData<List<Img>> response) {
                getMvpView().returnPhotos(response);
            }
        };

        baseRequest.setObservable(mApiService.getImgsByNum(num));
        baseRequest.setMethod("POST");
        baseRequest.setResponseCallback(responseCallback);
        requestData(baseRequest);
    }
}
