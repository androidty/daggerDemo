package com.ty.dagger.daggerdemo.mvp.ui.adapter.viewpageradapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ty on 2018/2/7.
 */

public class GankPagerAdapter extends FragmentStatePagerAdapter{
    String[] tabs = {"首页","Android","IOS","其他"};
    private List<Fragment> mFragments = new ArrayList<>();
    public GankPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
