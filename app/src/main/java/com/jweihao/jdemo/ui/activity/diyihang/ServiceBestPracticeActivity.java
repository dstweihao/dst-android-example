package com.jweihao.jdemo.ui.activity.diyihang;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


import com.jweihao.jdemo.service.DownloadService;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceBestPracticeActivity extends AppCompatActivity {

    private DownloadService.DownloadBinder mDownloadBinder;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mDownloadBinder = (DownloadService.DownloadBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_best_practice);
        ButterKnife.bind(this);
        Intent intent = new Intent(this, DownloadService.class);
        startService(intent); //启动服务
        bindService(intent, mConnection, BIND_AUTO_CREATE); //绑定服务
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }


    }

    @OnClick({R.id.start_download, R.id.pause_download, R.id.cancel_download})
    public void onViewClicked(View view) {
        if (mDownloadBinder == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.start_download:
                String url = "https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe";
                mDownloadBinder.startDownload(url);
                break;
            case R.id.pause_download:
                mDownloadBinder.pauseDownload();
                break;
            case R.id.cancel_download:
                mDownloadBinder.cancelDownload();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
