package com.jweihao.jdemo.ui.activity.diyihang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.service.MyService;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.start_service, R.id.stop_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start_service:
                Intent srartIntent = new Intent(this, MyService.class);
                //启动服务
                startService(srartIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent);
                break;
            default:
                break;
        }
    }
}
