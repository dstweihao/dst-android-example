package com.jweihao.jdemo.ui.activity.book.hero.custom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jweihao.jdemo.view.CircleProgressView;
import com.wh.customcontrol.R;

public class CircleProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_progress);

        CircleProgressView circleprogress = (CircleProgressView) findViewById(R.id.circleprogress);
        //设置外矩形值的大小
        circleprogress.setSweepValue(55);

    }
}
