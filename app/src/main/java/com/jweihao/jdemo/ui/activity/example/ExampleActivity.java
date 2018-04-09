package com.jweihao.jdemo.ui.activity.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExampleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button_pay, R.id.button_glass, R.id.button_sling, R.id.button_twitter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_pay:
                GoToActivityUtil.goToActivity(this, PayActivity.class);
                break;
            case R.id.button_glass:
                break;
            case R.id.button_sling:
                break;
            case R.id.button_twitter:
                GoToActivityUtil.goToActivity(this, TwitterActivity.class);
                break;
            default:
                break;
        }
    }
}
