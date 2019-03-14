package com.maple.example.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SPUtils;
import com.github.vivchar.viewpagerindicator.ViewPagerIndicator;
import com.jess.arms.di.component.AppComponent;
import com.maple.commonsdk.base.BaseActivity;
import com.maple.commonsdk.base.BaseFragment;
import com.maple.example.R;
import com.maple.example.app.config.AppContent;
import com.maple.example.app.config.RouterHubApp;
import com.maple.example.mvp.ui.adapter.WelcomePagerAdapter;
import com.maple.example.mvp.ui.fragment.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = RouterHubApp.APP_WELCOMEACTIVITY)
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.vp_indicator)
    ViewPagerIndicator vpIndicator;

    private List<BaseFragment> mList;

    @Override
    protected boolean useTransStateBar() {
        return true;
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_welcome;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        SPUtils.getInstance().put(AppContent.SaveInfoKey.HASWECLOME, true);
        mList = new ArrayList<>();
        mList.add(WelcomeFragment.newInstance(0));
        mList.add(WelcomeFragment.newInstance(1));
        mList.add(WelcomeFragment.newInstance(2));
        vp.setAdapter(new WelcomePagerAdapter(this.getSupportFragmentManager(),mList));
        vpIndicator.setupWithViewPager(vp);
        //vpIndicator.addOnPageChangeListener(mOnPageChangeListener);

    }
}
