package com.jweihao.jdemo.ui.activity.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jweihao.jdemo.view.aniamtion.CustomAnimation;
import com.jweihao.jdemo.view.aniamtion.CustomTV;
import com.wh.customcontrol.R;

public class CustomAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_animation);
    }

    public void btnAnim(View view) {
        CustomAnimation customAnimation = new CustomAnimation();
        customAnimation.setRotateY(30);
        view.startAnimation(customAnimation);

    }

    public void imgClose(View view) {

        CustomTV customTV = new CustomTV();
        view.startAnimation(customTV);

    }
}
