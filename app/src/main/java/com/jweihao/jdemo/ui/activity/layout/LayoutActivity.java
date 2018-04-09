package com.jweihao.jdemo.ui.activity.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutActivity extends AppCompatActivity {

    @BindView(R.id.button_catvr)
    Button mButtonCatvr;
    @BindView(R.id.button_ntvr)
    Button mButtonNtvr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_catvr, R.id.button_ntvr})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_catvr:
                GoToActivityUtil.goToActivity(this, CATVRActivity.class);
                break;
            case R.id.button_ntvr:
                GoToActivityUtil.goToActivity(this, NTVRActivity.class);
                break;
            default:
                break;

        }
    }
}
