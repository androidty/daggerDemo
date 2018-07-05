package com.ty.dagger.daggerdemo.mvp.ui.fragment.food;

import android.util.Log;

import com.ty.dagger.daggerdemo.mvp.data.remote.ResponseCallbackImpl;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseData;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.BaseRequest;
import com.ty.dagger.daggerdemo.mvp.entity.Food;
import com.ty.dagger.daggerdemo.mvp.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ty on 2018/6/28.
 */

public class FoodPresenter<V extends FoodContract.View> extends BasePresenter<V> implements FoodContract
        .Presenter<V>{
    @Inject
    public FoodPresenter() {

    }

    @Override
    public void requestFoods() {
        BaseRequest<BaseData<List<Food>>>  baseDataBaseRequest = new BaseRequest<>();
        baseDataBaseRequest.setResponseCallback(new ResponseCallbackImpl<BaseData<List<Food>>>() {
            @Override
            public void onSuccess(BaseData<List<Food>> response) {
                Log.d("requestFoods", "onSuccess: "+response.getResults().get(0).getContent());
                getMvpView().returnFoods(response.getResults());
            }
        });
        baseDataBaseRequest.setObservable(mApiService.getFoods());
        baseDataBaseRequest.setMethod("GET");
        requestData(baseDataBaseRequest);
    }
}
