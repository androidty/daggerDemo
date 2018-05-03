package com.ty.dagger.daggerdemo.mvp.ui.adapter.recyclerviewadapter;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.data.remote.gank.GankData;
import com.ty.dagger.daggerdemo.mvp.ui.activity.x5webview.X5WebViewActivity;
import com.ty.dagger.daggerdemo.mvp.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ty on 2018/2/7.
 */

public class HomeAdapter extends BaseQuickAdapter<GankData, BaseViewHolder> {

//    http://ohp3wewhw.bkt.clouddn.com/imgurls.json

    List<String> urlList = new ArrayList<>();

    public HomeAdapter(int layoutResId, @Nullable List<GankData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final GankData item) {
        helper.setText(R.id.item_author_tv, item.getWho()).setText(R.id.item_type_tv, item.getType()).setText
                (R.id.item_desc_tv, item.getDesc()).setText(R.id.item_time_tv, item.getCreatedAt());
        GlideApp.with(mContext).load(item.getSource()).centerCrop().into((ImageView) helper
                .getView(R.id.item_img_iv));
        helper.getView(R.id.item_img_iv).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), X5WebViewActivity.class);
                intent.putExtra("url",item.getUrl());
                mContext.startActivity(intent);

            }
        });
        if (helper.getAdapterPosition() == 3) {
            helper.setText(R.id.item_collect_tv, "已收藏");
        } else {
            helper.setText(R.id.item_collect_tv, "收藏");
        }
    }

    public void setImgs(List<String> img) {
        urlList = img;
    }
}
