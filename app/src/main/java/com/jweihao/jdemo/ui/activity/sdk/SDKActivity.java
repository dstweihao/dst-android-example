package com.jweihao.jdemo.ui.activity.sdk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SDKActivity extends AppCompatActivity {

    @BindView(R.id.button_baidu)
    Button mButtonBaidu;
    @BindView(R.id.button_gaode)
    Button mButtonGaode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdk);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button_baidu, R.id.button_gaode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_baidu:
                GoToActivityUtil.goToActivity(this, BaiduActivity.class);
                break;
            case R.id.button_gaode:
                GoToActivityUtil.goToActivity(this, GaoDeActivity.class);
                break;
            default:
                break;
        }
    }
}
