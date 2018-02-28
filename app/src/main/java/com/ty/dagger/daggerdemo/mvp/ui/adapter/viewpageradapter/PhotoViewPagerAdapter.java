package com.ty.dagger.daggerdemo.mvp.ui.adapter.viewpageradapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.ty.dagger.daggerdemo.R;

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
        Log.d("instantiateItem", "destroyItem:    " + position);
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = mInflater.inflate(R.layout.item_photoview, null);
        PhotoView photoView = view.findViewById(R.id.item_photoview);
        Log.d("instantiateItem", "instantiateItem: load " + position + "   count " + container
                .getChildCount());
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("instantiateItem", "onClick: " + position + "   count=" + container.getChildCount());
//                    container.removeViewAt(nextPosition);
                mPhotoItemOnClickListener.onPhotoClick();
            }
        });
        Glide.with(mContext).load(mUrls.get(position)).centerCrop().into(photoView);
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
