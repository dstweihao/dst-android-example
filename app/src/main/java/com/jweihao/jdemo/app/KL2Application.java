package com.jweihao.jdemo.app;
/*
 * 创建者 韦豪
 * 创建时间 2018/4/1 0001 21:53
 */

import android.app.Application;

import org.litepal.LitePal;

public class KL2Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);

    }
}
