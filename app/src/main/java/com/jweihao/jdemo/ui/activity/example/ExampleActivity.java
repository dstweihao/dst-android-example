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

    @BindView(R.id.button_jigsaw)
    Button mButtonJigsaw;
    @BindView(R.id.button_2048)
    Button mButton2048;
    @BindView(R.id.button_weibo)
    Button mButtonWeibo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_jigsaw, R.id.button_2048,R.id.button_weibo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_jigsaw:
                GoToActivityUtil.goToActivity(this, JigsawActivity.class);
                break;
            case R.id.button_2048:
                GoToActivityUtil.goToActivity(this, Game2048Activity.class);
                break;
            case R.id.button_weibo:
                GoToActivityUtil.goToActivity(this, WeiBoActivity.class);
                break;
            default:
                break;
        }
    }

}
