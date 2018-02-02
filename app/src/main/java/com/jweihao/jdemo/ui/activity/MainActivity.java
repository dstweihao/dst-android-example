package com.jweihao.jdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.ui.activity.animation.AnimationActivity;
import com.jweihao.jdemo.ui.activity.custom.CustomActivity;
import com.jweihao.jdemo.ui.activity.layout.LayoutActivity;
import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button_custom)
    Button mButtonCustom;
    @BindView(R.id.button_http)
    Button mButtonHttp;
    @BindView(R.id.button_layout)
    Button mButtonLayout;
    @BindView(R.id.button_animation)
    Button mButtonAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button_custom, R.id.button_http, R.id.button_layout, R.id.button_animation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_custom:
                GoToActivityUtil.goToActivity(this, CustomActivity.class);
                break;
            case R.id.button_http:
                break;
            case R.id.button_layout:
                GoToActivityUtil.goToActivity(this, LayoutActivity.class);
                break;
            case R.id.button_animation:
                GoToActivityUtil.goToActivity(this, AnimationActivity.class);
                break;
            default:
                break;

        }
    }

    @OnClick(R.id.button_animation)
    public void onViewClicked() {
    }
}
