package com.jweihao.jdemo.ui.activity.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimationActivity extends AppCompatActivity {

    @BindView(R.id.button_view_animation)
    Button mButtonViewAnimation;
    @BindView(R.id.button_objectanimator)
    Button mButtonObjectanimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_view_animation, R.id.button_objectanimator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_view_animation:
                GoToActivityUtil.goToActivity(this, ViewAnimationActivity.class);
                break;
            case R.id.button_objectanimator:
                break;
            default:
                break;

        }
    }
}
