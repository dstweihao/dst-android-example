package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.wh.customcontrol.R;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.video_view)
    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_APN_SETTINGS}, 1);
        } else {
            //初始化MediaPlayer
            initVideoPath();
        }

    }

    private void initVideoPath() {
        File file = new File(Environment.getExternalStorageDirectory(), "movie.mp4");
        //指定视频文件的路径
        mVideoView.setVideoPath(file.getPath());

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initVideoPath();
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.video_play, R.id.video_pause, R.id.video_replay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.video_play:
                if (!mVideoView.isPlaying()) {
                    //开始播放
                    mVideoView.start();
                }
                break;
            case R.id.video_pause:
                if (mVideoView.isPlaying()) {
                    //暂停播放
                    mVideoView.pause();
                }
                break;
            case R.id.video_replay:
                if (mVideoView.isPlaying()) {
                    //重新播放
                    mVideoView.resume();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mVideoView != null) {
            //挂起
            mVideoView.suspend();
        }
    }
}
