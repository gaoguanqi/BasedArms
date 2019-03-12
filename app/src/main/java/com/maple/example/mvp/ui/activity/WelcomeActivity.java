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
import com.maple.example.app.global.RouterHubApp;
import com.maple.example.mvp.ui.adapter.WelcomePagerAdapter;
import com.maple.example.mvp.ui.fragment.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = RouterHubApp.APP_WELCOMEACTIVITY)
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.vp_indicator)
    ViewPagerIndicator vpIndicator;

    private List<BaseFragment> mList;



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
        mList.add(WelcomeFragment.newInstance());
        mList.add(WelcomeFragment.newInstance());
        mList.add(WelcomeFragment.newInstance());
        vp.setAdapter(new WelcomePagerAdapter(this.getSupportFragmentManager(),mList));
        vpIndicator.setupWithViewPager(vp);
        //vpIndicator.addOnPageChangeListener(mOnPageChangeListener);

    }
}