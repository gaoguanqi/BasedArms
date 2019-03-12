package com.maple.example.mvp.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.maple.commonsdk.base.BaseFragment;

import java.util.List;

/**
 * author: gaogq
 * time: 2019/3/12 17:01
 * description:
 */
public class WelcomePagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mList;

    public WelcomePagerAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        if (mList != null && mList.size() > 0) {
            return mList.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null ? 0: mList.size();
    }
}
