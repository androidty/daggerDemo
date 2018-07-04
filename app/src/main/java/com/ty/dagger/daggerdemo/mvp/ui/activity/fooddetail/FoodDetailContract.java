package com.ty.dagger.daggerdemo.mvp.ui.activity.fooddetail;

import com.ty.dagger.daggerdemo.mvp.entity.FoodDetail;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

/**
 * Created by ty on 2018/7/2.
 */

public class FoodDetailContract {
    public interface View extends MvpView{

        void returnFoodDetail(FoodDetail foodDetail);
    }

    public interface Presenter<V extends View> extends MvpPresenter<V>{
        void requestFoodDetailById(int id);
    }
}
