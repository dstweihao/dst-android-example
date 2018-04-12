package com.jweihao.jdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.ui.activity.book.AndroidMenuActivity;
import com.jweihao.jdemo.ui.activity.book.JavaMenuActivity;
import com.jweihao.jdemo.ui.activity.example.ExampleActivity;
import com.jweihao.jdemo.ui.activity.java.JavaThreadActivity;
import com.jweihao.jdemo.ui.activity.layout.LayoutActivity;
import com.jweihao.jdemo.ui.activity.md.MaterialDesignActivity;
import com.jweihao.jdemo.ui.activity.property.ViewStubActivity;
import com.jweihao.jdemo.ui.activity.sdk.SDKActivity;
import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button_custom, R.id.button_http, R.id.button_layout, R.id.button_animation,
            R.id.button_md, R.id.button_property, R.id.button_example, R.id.button_canvas,
            R.id.button_sdk,  R.id.button_android, R.id.button_java
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // Android书籍目录
            case R.id.button_android:
                GoToActivityUtil.goToActivity(this, AndroidMenuActivity.class);
                break;
            // Java书籍目录
            case R.id.button_java:
                GoToActivityUtil.goToActivity(this, JavaMenuActivity.class);
                break;
            case R.id.button_custom:

                break;
            case R.id.button_http:
                break;
            case R.id.button_layout:
                GoToActivityUtil.goToActivity(this, LayoutActivity.class);
                break;
            case R.id.button_animation:
//                GoToActivityUtil.goToActivity(this, AnimationActivity.class);
                break;
            case R.id.button_canvas:
//                GoToActivityUtil.goToActivity(this, CanvasActivity.class);
                break;
            case R.id.button_md:
                GoToActivityUtil.goToActivity(this, MaterialDesignActivity.class);
                break;

            case R.id.button_property:
                GoToActivityUtil.goToActivity(this, ViewStubActivity.class);
                break;

            case R.id.button_sdk:
                GoToActivityUtil.goToActivity(this, SDKActivity.class);
                break;
            case R.id.button_example:
                GoToActivityUtil.goToActivity(this, ExampleActivity.class);
                break;
            default:
                break;

        }
    }

    @OnClick(R.id.button_java)
    public void onViewClicked() {
    }
}
