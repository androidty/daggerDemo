package com.ty.dagger.daggerdemo.mvp.ui.adapter.recyclerviewadapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankLastData;
import com.ty.dagger.daggerdemo.mvp.ui.activity.photo.PhotoActivity;

import java.util.List;

/**
 * Created by ty on 2018/2/7.
 */

public class HomeAdapter extends BaseQuickAdapter<GankLastData, BaseViewHolder> {
    public HomeAdapter(int layoutResId, @Nullable List<GankLastData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final GankLastData item) {
        helper.setText(R.id.item_author_tv, item.getWho()).setText(R.id.item_type_tv, item.getType()).setText
                (R.id.item_desc_tv, item.getDesc()).setText(R.id.item_time_tv, item.getCreatedAt());
        Glide.with(mContext).load(item.getSource()).asBitmap().centerCrop().into((ImageView) helper
                .getView(R.id.item_img_iv));
        helper.getView(R.id.item_img_iv).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PhotoActivity.class);
                intent.putExtra("imgUrl",item.getSource());
                view.getContext().startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation((Activity) view.getContext(), view,
                                "sharedView").toBundle());
            }
        });
        if (helper.getAdapterPosition() == 3) {
            helper.setText(R.id.item_collect_tv, "已收藏");
        } else {
            helper.setText(R.id.item_collect_tv, "收藏");
        }
    }
}
