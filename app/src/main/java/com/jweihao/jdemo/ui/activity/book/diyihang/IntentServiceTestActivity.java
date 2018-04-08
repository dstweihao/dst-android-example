package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.jweihao.jdemo.service.MyIntentService;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IntentServiceTestActivity extends AppCompatActivity {

    @BindView(R.id.start_intent_service)
    Button mStartIntentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.start_intent_service)
    public void onViewClicked() {
        //打印主线程的id
        Log.d("IntentServiceTest","This id is " + Thread.currentThread().getId());
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
}
