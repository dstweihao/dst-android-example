package com.jweihao.jdemo.ui.activity.sdk;

import android.app.Application;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by weihao on 2018/3/12.
 */

public class BaiduApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);

        //初始化X5WebView内核
        //搜索本地tba内核信息并上报服务器，服务器返回结果决定使用哪个内核
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {
                //x5内核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会
                //自动切换到系统内核
                Log.d("app", "onViewInitFinished is " + b);

            }
        };

        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);

    }
}
