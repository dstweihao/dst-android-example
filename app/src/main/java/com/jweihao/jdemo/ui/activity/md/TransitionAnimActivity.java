package com.jweihao.jdemo.ui.activity.md;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wh.customcontrol.R;

public class TransitionAnimActivity extends AppCompatActivity {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_anim);
    }

    /*
    * 分解，从屏幕中间进或出，移动视图
    * */
    public void explode(View view) {
        mIntent = new Intent(this, TransitionsToActivity.class);
        mIntent.putExtra("flag", 0);
        startActivity(
                mIntent,
                ActivityOptions
                        .makeSceneTransitionAnimation(this)
                        .toBundle()
        );
    }

    /*
    * 滑动，从屏幕边缘进或出，移动视图
    * */
    public void slide(View view) {

    }

    /*
    * 淡出，通过改变屏幕上视图的不透明度达到添加或者移除视图
    * */
    public void fade(View view) {

    }

    /*
    * 共享元素，
    * */
    public void share(View view) {
    }
}
