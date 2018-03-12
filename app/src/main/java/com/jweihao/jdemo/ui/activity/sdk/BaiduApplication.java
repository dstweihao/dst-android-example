package com.jweihao.jdemo.ui.activity.sdk;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by weihao on 2018/3/12.
 */

public class BaiduApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);

    }
}
