package com.jweihao.jdemo.ui.activity.diyihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Zhang10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang10);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_ui, R.id.button_async, R.id.button_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_ui:
                GoToActivityUtil.goToActivity(this, UpdateUIActivity.class);
                break;
            case R.id.button_async:
                GoToActivityUtil.goToActivity(this, AsyncTaskActivity.class);
                break;
            case R.id.button_service:
                break;
            default:
                break;
        }
    }

    @OnClick(R.id.button_async)
    public void onViewClicked() {
    }
}
