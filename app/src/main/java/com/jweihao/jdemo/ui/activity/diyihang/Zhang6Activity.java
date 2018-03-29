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

public class Zhang6Activity extends AppCompatActivity {

    @BindView(R.id.button_file)
    Button mButtonFile;
    @BindView(R.id.button_sp)
    Button mButtonSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang6);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_file, R.id.button_sp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_file:
                GoToActivityUtil.goToActivity(this, FileStoreActivity.class);
                break;
            case R.id.button_sp:
                break;
            default:
                break;
        }
    }
}
