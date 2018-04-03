package com.jweihao.jdemo.ui.activity.diyihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Zhang8Activity extends AppCompatActivity {

    @BindView(R.id.button_notification)
    Button mButtonNotification;
    @BindView(R.id.button_camera)
    Button mButtonCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang8);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_notification, R.id.button_camera})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_notification:
                GoToActivityUtil.goToActivity(this, NotificatActivity.class);
                break;
            case R.id.button_camera:
                GoToActivityUtil.goToActivity(this, CameraActivity.class);
                break;
            default:
                break;
        }
    }
}
