package com.jweihao.jdemo.ui.activity.book;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.ui.activity.book.diyihang.DiYiHangActivity;
import com.jweihao.jdemo.ui.activity.book.hero.HeroMenuActivity;
import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AndroidMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_diyihang, R.id.button_hero, R.id.button_art})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //《第一行代码》
            case R.id.button_diyihang:
                GoToActivityUtil.goToActivity(this, DiYiHangActivity.class);
                break;
            //《Android群英传》
            case R.id.button_hero:
                GoToActivityUtil.goToActivity(this, HeroMenuActivity.class);
                break;
            //《Android开发艺术探索》
            case R.id.button_art:

                break;
            default:
                break;
        }
    }
}
