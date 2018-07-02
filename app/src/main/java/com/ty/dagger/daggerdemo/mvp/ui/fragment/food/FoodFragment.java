package com.ty.dagger.daggerdemo.mvp.ui.fragment.food;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.entity.Food;
import com.ty.dagger.daggerdemo.mvp.ui.adapter.recyclerviewadapter.FoodAdapter;
import com.ty.dagger.daggerdemo.mvp.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by ty on 2018/2/6.
 */

public class FoodFragment extends BaseFragment implements FoodContract.View {

    @Inject
    FoodPresenter<FoodContract.View> mPresenter;
    @BindView(R.id.food_recyclerview)
    RecyclerView mFoodRecyclerview;
    @BindView(R.id.food_swipeRefreshLayout)
    SwipeRefreshLayout mFoodSwipeRefreshLayout;
    Unbinder unbinder;
    FoodAdapter mFoodAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_food;
    }

    @Override
    public void initViews() {
        mFoodRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mFoodAdapter = new FoodAdapter(R.layout.item_food,new ArrayList<Food>());
        mFoodRecyclerview.setAdapter(mFoodAdapter);
        mPresenter.requestFoods();
    }

    @Override
    public void injectView() {
        getActivityComponent().inject(this);
        mPresenter.onAttach(this);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDetach();
    }

    @Override
    public void returnFoods(List<Food> foodList) {
        if(foodList!=null&&!foodList.isEmpty()){
            for (int i = 0; i <foodList.size() ; i++) {
                Food food = foodList.get(i);
                Log.d("returnfoods", "returnFoods: "+food.getTitle()+"  "+food.getContent()+"  "+food
                        .getImgUrl());
            }
            mFoodAdapter.setNewData(foodList);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
