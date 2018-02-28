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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ty on 2018/2/7.
 */

public class HomeAdapter extends BaseQuickAdapter<GankLastData, BaseViewHolder> {


//    http://ohp3wewhw.bkt.clouddn.com/imgurls.json


    String url1="http://t2.hddhhn.com/uploads/tu/201709/9999/21f0e3c5fa.jpg";
    String url2="http://t2.hddhhn.com/uploads/tu/201709/9999/c734324707.jpg";
    String url3="http://t2.hddhhn.com/uploads/tu/201709/9999/8650d67f8c.jpg";
    String url4="http://t2.hddhhn.com/uploads/tu/201709/9999/b0d28560cf.jpg";
    String url5="http://t2.hddhhn.com/uploads/tu/201709/9999/5402b82eba.jpg";
    String url6="http://t2.hddhhn.com/uploads/tu/201709/9999/8af9b2ffce.jpg";
    String url7="http://t2.hddhhn.com/uploads/tu/201709/9999/ea6b603bf0.jpg";
    String url8="http://t2.hddhhn.com/uploads/tu/201709/9999/7ec9470fd3.jpg";
    String url9="http://t2.hddhhn.com/uploads/tu/201709/9999/824fc9349a.jpg";
    String url10="http://t2.hddhhn.com/uploads/tu/201709/9999/5f6944bfc4.jpg";
    String url11="http://t2.hddhhn.com/uploads/tu/201709/9999/7e358fbf1f.jpg";
    String url12="http://t2.hddhhn.com/uploads/tu/201709/9999/300b3009c2.jpg";
    String url13="http://t2.hddhhn.com/uploads/tu/201709/9999/9328c516cb.jpg";
    String url14="http://t2.hddhhn.com/uploads/tu/201709/9999/07229c8431.jpg";
    String url15="http://t2.hddhhn.com/uploads/tu/201709/9999/e47c667395.jpg";
    String url16="http://t2.hddhhn.com/uploads/tu/201709/9999/2d70c2509e.jpg";
    String url17="http://t2.hddhhn.com/uploads/tu/201709/9999/fae5025fd0.jpg";
    String url18="http://t2.hddhhn.com/uploads/tu/201709/9999/14f6798c1d.jpg";
    String url19="http://t2.hddhhn.com/uploads/tu/201709/9999/dabcfc7c05.jpg";
    String url20="http://t2.hddhhn.com/uploads/tu/201709/9999/e500db865d.jpg";
    String [] urls ={
            url1,url2,url3,url4,url5,
            url6,url7,url8,url9,url10,
            url11,url12,url13,url14,url15,
            url16,url17,url18,url19,url20,
    };
    ArrayList<String> urlList = new ArrayList<>();


    public HomeAdapter(int layoutResId, @Nullable List<GankLastData> data) {
        super(layoutResId, data);

        for(int i =0;i<urls.length;i++){
            urlList.add(urls[i]);
        }
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
                intent.putExtra("type",0);
                intent.putExtra("imgUrl",item.getSource());
//                intent.putStringArrayListExtra("imgUrls",urlList);
//                view.getContext().startActivity(intent);
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
