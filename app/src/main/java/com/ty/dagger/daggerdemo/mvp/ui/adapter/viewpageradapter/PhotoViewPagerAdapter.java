package com.ty.dagger.daggerdemo.mvp.ui.adapter.viewpageradapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;
import com.ty.dagger.daggerdemo.R;
import com.ty.dagger.daggerdemo.mvp.utils.GlideApp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ty on 2018/2/12.
 */

public class PhotoViewPagerAdapter extends PagerAdapter {
    List<String> mUrls;
    Context mContext;
    LayoutInflater mInflater;
    List<PhotoView> mPhotoViews = new ArrayList<>();
    private PhotoItemOnClickListener mPhotoItemOnClickListener;
    int nextPosition = 1;


    public PhotoViewPagerAdapter(List<String> urls, Context context) {
        this.mUrls = urls;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = mInflater.inflate(R.layout.item_photoview, null);
        PhotoView photoView = view.findViewById(R.id.item_photoview);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPhotoItemOnClickListener.onPhotoClick();
            }
        });
        GlideApp.with(mContext).load(mUrls.get(position)).optionalCenterCrop().into(photoView);
        ViewGroup parent = (ViewGroup) photoView.getParent();
        if (parent != null) {
            parent.removeAllViews();
        }
        container.addView(photoView);

        return photoView;
    }

    public interface PhotoItemOnClickListener {
        void onPhotoClick();
    }

    public void setPhotoItemOnClickListener(PhotoItemOnClickListener photoItemOnClickListener) {
        mPhotoItemOnClickListener = photoItemOnClickListener;
    }


    public void setNextPosition(int nextPosition) {
        this.nextPosition = nextPosition;
    }

    public int getNextPosition() {
        return nextPosition;
    }


}
