package com.jweihao.jdemo.ui.activity.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 动画特效
*
* */

public class AnimEffectsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_effects);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_menu, R.id.button_timer, R.id.button_unfold})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            //灵动菜单
            case R.id.button_menu:
                GoToActivityUtil.goToActivity(this, MenuActivity.class);
                break;
            //计时器
            case R.id.button_timer:
                GoToActivityUtil.goToActivity(this, TimerActivity.class);
                break;
            //下拉展开动画
            case R.id.button_unfold:
                GoToActivityUtil.goToActivity(this, PullDownActivity.class);
                break;

            default:
                break;
        }
    }
}
