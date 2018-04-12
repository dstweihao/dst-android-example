package com.jweihao.jdemo.ui.activity.book;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jweihao.jdemo.ui.activity.java.JavaThreadActivity;
import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class JavaMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_menu);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_thread)
    public void onViewClicked() {
        //《Java多线程编程核心技术》
        GoToActivityUtil.goToActivity(this, JavaThreadActivity.class);
    }
}
