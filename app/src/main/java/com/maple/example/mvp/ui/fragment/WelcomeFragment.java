package com.maple.example.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.utils.ArmsUtils;
import com.maple.commonsdk.base.BaseFragment;
import com.maple.commonsdk.imgaEngine.config.CommonImageConfigImpl;
import com.maple.commonsdk.utils.Utils;
import com.maple.example.R;
import com.maple.example.app.config.AppContent;
import com.maple.example.app.global.RouterHubApp;
import com.maple.example.mvp.ui.activity.SplashActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * author: gaogq
 * time: 2019/3/12 17:04
 * description:
 */
public class WelcomeFragment extends BaseFragment {

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.btn_start)
    Button btnStart;

    private ImageLoader mImageLoader;
    private int mIndex;

    public static WelcomeFragment newInstance(int index) {
        WelcomeFragment fragment = new WelcomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(AppContent.BundleKey.EXTRA_INDEX, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome, container, false);
        return view;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mIndex = getArguments().getInt(AppContent.BundleKey.EXTRA_INDEX);
        AppComponent mAppComponent = ArmsUtils.obtainAppComponentFromContext(getActivity());
        mImageLoader = mAppComponent.imageLoader();
        String url;
        switch (mIndex) {
            case 0:
                url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2059324361,2516966890&fm=26&gp=0.jpg";
                setUI(url, false);
                break;
            case 1:
                url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=4022829865,3519379100&fm=26&gp=0.jpg";
                setUI(url, false);
                break;
            case 2:
                url = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=508405853,1332232464&fm=26&gp=0.jpg";
                setUI(url, true);
                break;
            default:
                break;
        }
    }

    @Override
    public void setData(@Nullable Object data) {


    }

    private void setUI(String url, boolean has) {
        if (has) {
            btnStart.setVisibility(View.VISIBLE);
        } else {
            btnStart.setVisibility(View.GONE);
        }
        mImageLoader.loadImage(getActivity(),
                CommonImageConfigImpl
                        .builder()
                        .url(url)
                        .imageView(ivImg)
                        .build());
    }



    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        Utils.navigation(getActivity(), RouterHubApp.APP_MAINACTIVITY);
        this.getActivity().finish();
    }
}
