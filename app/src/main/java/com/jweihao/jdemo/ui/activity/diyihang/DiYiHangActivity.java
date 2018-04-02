package com.jweihao.jdemo.ui.activity.diyihang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DiYiHangActivity extends AppCompatActivity {

    @BindView(R.id.button_6)
    Button mButton6;
    @BindView(R.id.button_7)
    Button mButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_di_yi_hang);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_6, R.id.button_7, R.id.button_8})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_6:
                GoToActivityUtil.goToActivity(this, Zhang6Activity.class);
                break;
            case R.id.button_7:
                GoToActivityUtil.goToActivity(this,zhang7Activity.class);
                break;
            case R.id.button_8:
                GoToActivityUtil.goToActivity(this, Zhang8Activity.class);
                break;
            default:
                break;
        }
    }
}
