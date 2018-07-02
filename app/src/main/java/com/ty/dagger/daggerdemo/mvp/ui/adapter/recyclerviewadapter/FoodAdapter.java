package com.ty.dagger.daggerdemo.mvp.ui.adapter.recyclerviewadapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.entity.Food;
import com.ty.dagger.daggerdemo.mvp.utils.GlideApp;

import java.util.List;

/**
 * Created by ty on 2018/6/28.
 */

public class FoodAdapter extends BaseQuickAdapter<Food, BaseViewHolder> {
    public FoodAdapter(int layoutResId, @Nullable List<Food> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Food item) {
        Log.d("foodsconvert", "convert: " + item.getTitle() + "  " + item.getContent() + "  " + item
                .getImgUrl());
        if (item != null) {
            Log.e("foodsconvert", "convert: " + (helper.getView(R.id.food_title) == null));
//            helper.setText(R.id.food_title,item.getTitle()).setText(R.id.food_content,item.getContent()
//            );
            helper.setText(R.id.food_title, (item.getTitle() == null) ? " " : item.getTitle())
                    .setText(R.id.food_content, (item.getContent() == null ? " " : item.getContent()));
            GlideApp.with(mContext).load(item.getImgUrl()).centerCrop().into((ImageView) helper
                    .getView(R.id.food_img));
        }
    }
}
