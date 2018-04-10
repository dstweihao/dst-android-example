package com.jweihao.jdemo.ui.activity.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_twitter, R.id.button_pay, R.id.button_glass, R.id.button_html, R.id.button_sling})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_twitter:
                GoToActivityUtil.goToActivity(this, TwitterActivity.class);
                break;
            case R.id.button_pay:
                GoToActivityUtil.goToActivity(this, PayActivity.class);
                break;
            case R.id.button_glass:
                GoToActivityUtil.goToActivity(this, GlassActivity.class);
                break;
            case R.id.button_html:
                GoToActivityUtil.goToActivity(this, HTMLActivity.class);
                break;
            case R.id.button_sling:
                GoToActivityUtil.goToActivity(this, SlingActivity.class);
                break;
            default:
                break;
        }
    }
}
