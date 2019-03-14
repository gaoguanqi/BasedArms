package com.maple.example.mvp.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.SPUtils;
import com.jess.arms.di.component.AppComponent;
import com.maple.commonsdk.base.BaseActivity;
import com.maple.commonsdk.utils.Utils;
import com.maple.example.R;
import com.maple.example.app.config.AppContent;
import com.maple.example.app.config.RouterHubApp;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

@Route(path = RouterHubApp.APP_SPLASHACTIVITY)
public class SplashActivity extends BaseActivity {


    @Override
    protected boolean useTransStateBar() {
        return true;
    }

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_splash;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Observable.timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if(!SPUtils.getInstance().getBoolean(AppContent.SaveInfoKey.HASWECLOME)){
                            Utils.navigation(SplashActivity.this, RouterHubApp.APP_MAINACTIVITY);
                        }else {
                            Utils.navigation(SplashActivity.this, RouterHubApp.APP_WELCOMEACTIVITY);
                        }
                        finish();
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    }
                });
    }
}
