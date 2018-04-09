package com.jweihao.jdemo.ui.activity.book.hero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.ui.activity.example.Game2048Activity;
import com.jweihao.jdemo.ui.activity.example.JigsawActivity;
import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Hero13Activity extends AppCompatActivity {

    @BindView(R.id.button_jigsaw)
    Button mButtonJigsaw;
    @BindView(R.id.button_2048)
    Button mButton2048;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero13);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_jigsaw, R.id.button_2048})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_jigsaw:
                GoToActivityUtil.goToActivity(this, JigsawActivity.class);
                break;
            case R.id.button_2048:
                GoToActivityUtil.goToActivity(this, Game2048Activity.class);
                break;

            default:
                break;
        }
    }

}
