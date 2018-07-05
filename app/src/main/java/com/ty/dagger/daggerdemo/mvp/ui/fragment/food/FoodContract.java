package com.ty.dagger.daggerdemo.mvp.ui.fragment.food;

import com.ty.dagger.daggerdemo.mvp.entity.Food;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpPresenter;
import com.ty.dagger.daggerdemo.mvp.ui.mvp.MvpView;

import java.util.List;

/**
 * Created by ty on 2018/6/28.
 */

public class FoodContract {
    interface View extends MvpView{
        void returnFoods(List<Food> foodList);
    }

    interface Presenter<V extends View> extends MvpPresenter<V>{
        void requestFoods();
    }
}
