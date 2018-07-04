package com.ty.dagger.daggerdemo.mvp.ui.activity.fooddetail;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.entity.FoodDetail;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by ty on 2018/7/2.
 */

public class FoodDetailPresenter <V extends FoodDetailContract.View> extends BasePresenter<V> implements
        FoodDetailContract.Presenter<V>{
    @Inject
    public FoodDetailPresenter(){

    }

    @Override
    public void requestFoodDetailById(int id) {
        BaseRequest<BaseData<FoodDetail>> baseRequest = new BaseRequest<>();
        baseRequest.setMethod("POST");
        baseRequest.setResponseCallback(new ResponseCallbackImpl<BaseData<FoodDetail>>() {
            @Override
            public void onSuccess(BaseData<FoodDetail> response) {
                Log.d("fooddetail", "onSuccess: ");
                Log.d("fooddetail", "onSuccess: "+response.getResults().getDetail());
                getMvpView().returnFoodDetail(response.getResults());

            }
        });
        baseRequest.setObservable(mApiService.getFoodDetailById(id));
        requestData(baseRequest);
    }
}
