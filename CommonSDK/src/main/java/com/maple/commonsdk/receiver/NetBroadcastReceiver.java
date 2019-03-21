package com.maple.commonsdk.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;

import com.blankj.utilcode.util.NetworkUtils;

/**
 * author: gaogq
 * time: 2019/3/18 11:34
 * description:
 */
public class NetBroadcastReceiver extends BroadcastReceiver {

    public NetChangeListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            @SuppressLint("MissingPermission")
            boolean isConnected = NetworkUtils.isConnected();
            @SuppressLint("MissingPermission")
            String type = NetworkUtils.getNetworkType().name();
            // 当网络发生变化，判断当前网络状态，并通过NetEvent回调当前网络状态
            if (mListener != null) {
                mListener.onChangeListener(isConnected,type);
            }
        }
    }

    // 自定义接口
    public interface NetChangeListener {
        void onChangeListener(boolean isConnected,String type);
    }

    public void setNetChangeListener(NetChangeListener listener){
        this.mListener = listener;
    }
}
