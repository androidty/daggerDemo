package com.ty.dagger.daggerdemo.mvp.ui.adapter.recyclerviewadapter;

import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.api.config.Constants;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;

import java.util.List;

/**
 * Created by ty on 2018/2/7.
 */

public class HomeAdapter extends BaseQuickAdapter<GankLastData, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<GankLastData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GankLastData item) {
//        Log.d("myname", "convert: " + item.getDesc());
        helper.setText(R.id.item_author_tv, item.getWho()).setText(R.id.item_type_tv, item.getType()).setText
                (R.id.item_desc_tv, item.getDesc()).setText(R.id.item_time_tv, item.getCreatedAt());
        if (item.getType().equals(Constants.FULI)) {
            Log.d("myname", "convert: "+item.getUrl());
            Glide.with(mContext).load(item.getUrl()).into((ImageView) helper
                    .getView(R.id.item_img_iv));
        }
        if(helper.getAdapterPosition()==3){
            helper.setText(R.id.item_collect_tv,"已收藏");
        }else{
            helper.setText(R.id.item_collect_tv,"收藏");
        }
    }
}
