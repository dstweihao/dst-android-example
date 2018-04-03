package com.jweihao.jdemo.ui.activity.diyihang;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wh.customcontrol.R;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VoiceActivity extends AppCompatActivity {

    @BindView(R.id.play)
    Button mPlay;
    @BindView(R.id.pause)
    Button mPause;
    @BindView(R.id.stop)
    Button mStop;

    private MediaPlayer mMediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);
        ButterKnife.bind(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            //初始化Mediaplayer
            initMediaPlayer();
        }
    }

    private void initMediaPlayer() {


        try {
            File file = new File(Environment.getExternalStorageDirectory(), "music.mp3");
            //指定音频文件路径
            mMediaPlayer.setDataSource(file.getPath());
            //让MediaPlauer 进入到准备状态
            mMediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initMediaPlayer();
                } else {
                    Toast.makeText(this, "拒绝权限将无法使用程序", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.play, R.id.pause, R.id.stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.play:
                if (!mMediaPlayer.isPlaying()) {
                    //开始播放
                    mMediaPlayer.start();
                }
                break;
            case R.id.pause:
                if (mMediaPlayer.isPlaying()) {
                    //暂停播放
                    mMediaPlayer.pause();
                }
                break;
            case R.id.stop:
                if (mMediaPlayer.isPlaying()) {
                    //停止播放
                    mMediaPlayer.reset();
                    initMediaPlayer();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
    }
}
