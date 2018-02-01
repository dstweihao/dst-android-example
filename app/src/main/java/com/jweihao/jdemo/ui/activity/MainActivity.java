package com.jweihao.jdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.ui.activity.custom.CustomActivity;
import com.jweihao.jdemo.ui.activity.layout.LayoutActivity;
import com.jweihao.jdemo.utils.GoToActivity;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.button_custom)
    Button mButtonCustom;
    @BindView(R.id.button_http)
    Button mButtonHttp;
    @BindView(R.id.button_layout)
    Button mButtonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button_custom, R.id.button_http, R.id.button_layout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_custom:
                GoToActivity.goToActivity(this, CustomActivity.class);
                break;
            case R.id.button_http:
                break;
            case R.id.button_layout:
                GoToActivity.goToActivity(this, LayoutActivity.class);
                break;
            default:
                break;

        }
    }
}
