package com.jweihao.jdemo.ui.activity.sdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDKActivity extends AppCompatActivity {

    @BindView(R.id.button_baidu)
    Button mButtonBaidu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdk);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_baidu)
    public void onViewClicked() {
        GoToActivityUtil.goToActivity(this, BaiduActivity.class);
    }
}
