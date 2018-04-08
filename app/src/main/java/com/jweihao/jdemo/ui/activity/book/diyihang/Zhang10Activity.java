package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Zhang10Activity extends AppCompatActivity {

    @BindView(R.id.button_ui)
    Button mButtonUi;
    @BindView(R.id.button_async)
    Button mButtonAsync;
    @BindView(R.id.button_service)
    Button mButtonService;
    @BindView(R.id.button_intent_service)
    Button mButtonIntentService;
    @BindView(R.id.button_practice)
    Button mButtonPractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang10);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_ui, R.id.button_async, R.id.button_service, R.id.button_intent_service,R.id.button_practice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_ui:
                GoToActivityUtil.goToActivity(this, UpdateUIActivity.class);
                break;
            case R.id.button_async:
                GoToActivityUtil.goToActivity(this, AsyncTaskActivity.class);
                break;
            case R.id.button_service:
                GoToActivityUtil.goToActivity(this, ServiceTestActivity.class);
                break;
            case R.id.button_intent_service:
                GoToActivityUtil.goToActivity(this, IntentServiceTestActivity.class);
                break;
            case R.id.button_practice:
                GoToActivityUtil.goToActivity(this, ServiceBestPracticeActivity.class);
                break;
            default:
                break;
        }
    }
}
