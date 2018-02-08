package com.jweihao.jdemo.ui.activity.md;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import static android.util.Pair.*;

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
        mIntent = new Intent(this, TransitionsToActivity.class);
        mIntent.putExtra("flag", 1);
        startActivity(
                mIntent,
                ActivityOptions
                        .makeSceneTransitionAnimation(this)
                        .toBundle()
        );
    }

    /*
    * 淡出，通过改变屏幕上视图的不透明度达到添加或者移除视图
    * */
    public void fade(View view) {
        mIntent = new Intent(this, TransitionsToActivity.class);
        mIntent.putExtra("flag", 2);
        startActivity(
                mIntent,
                ActivityOptions
                        .makeSceneTransitionAnimation(this)
                        .toBundle()
        );
    }

    /*
    * 共享元素，
    * */
    public void share(View view) {

        View fab = (ImageView) findViewById(R.id.fab_imageview);
        mIntent = new Intent(this, TransitionsToActivity.class);
        mIntent.putExtra("flag", 3);

        // 创建单个共享元素
//        startActivity(
//                mIntent,
//                ActivityOptions
//                        .makeSceneTransitionAnimation(
//                                this,
//                                fab,
//                                "fab"
//                        )
//                        .toBundle()
//        );

        //创建多个共享元素
        //Pair.create(view,string)里面传入的是View,所以需要将图片控件ImageView更改为View,不然报错。
        startActivity(
                mIntent,
                ActivityOptions
                        .makeSceneTransitionAnimation(
                                this,
                                Pair.create(view, "share"),
                                Pair.create(fab, "fab")
                        )
                        .toBundle()
        );
    }
}