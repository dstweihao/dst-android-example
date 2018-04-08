package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.service.MyService;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceTestActivity extends AppCompatActivity {

    private MyService.DownLoadBinder mDownLoadBinder;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownLoadBinder = (MyService.DownLoadBinder) service;
            mDownLoadBinder.startDownLoad();
            mDownLoadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.start_service, R.id.stop_service, R.id.bind_service, R.id.unbind_service})
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
            //绑定Service
            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, mConnection, BIND_AUTO_CREATE);
                break;
            //解绑Service
            case R.id.unbind_service:
                unbindService(mConnection);
                break;
            default:
                break;
        }
    }
}
