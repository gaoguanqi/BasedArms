package com.maple.example.app.config;

/**
 * author: gaogq
 * time: 2018/12/14 17:21
 * description:
 */
public interface AppContent {


    /**
     * 需要以键值对持久化到SharePerference文件中的Key常量值
     */
    public static class SaveInfoKey {
        public static final String HASWECLOME = "hasWeclome";
    }

    /**
     * Bundle中需要作为Key传递的常量EXTRA开头
     */
    public static class BundleKey {


        public static final String EXTRA_INDEX = "index";
    }
}
