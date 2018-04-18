package com.ty.dagger.daggerdemo.mvp.ui.adapter.otheradapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.entity.ImgList;
import com.ty.dagger.daggerdemo.mvp.utils.GlideApp;

import java.util.List;

/**
 * Created by ty on 2018/4/18.
 */

public class OtherAdapter extends BaseQuickAdapter<ImgList, BaseViewHolder> {

    public OtherAdapter(int layoutResId, @Nullable List<ImgList> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ImgList item) {
            ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
            layoutParams.height = (int)(500+Math.random()*500);
            helper.itemView.setLayoutParams(layoutParams);

        GlideApp.with(mContext).load(item.getUrl()).into((ImageView) helper
                .getView(R.id.item_other_img));

        helper.getView(R.id.item_other_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
