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
    @BindView(R.id.button_property)
    Button mButtonProperty;
    @BindView(R.id.button_value)
    Button mButtonValue;
    @BindView(R.id.button_animatorset)
    Button mButtonAnimatorset;
    @BindView(R.id.button_layout)
    Button mButtonLayout;
    @BindView(R.id.button_custom)
    Button mButtonCustom;
    @BindView(R.id.button_svg)
    Button mButtonSvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_view_animation, R.id.button_objectanimator,
            R.id.button_property, R.id.button_value, R.id.button_animatorset,
            R.id.button_layout, R.id.button_custom,R.id.button_svg
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_view_animation:
                GoToActivityUtil.goToActivity(this, ViewAnimationActivity.class);
                break;
            case R.id.button_objectanimator:
                GoToActivityUtil.goToActivity(this, ObjectAnimatorActivity.class);
                break;
            case R.id.button_property:
                GoToActivityUtil.goToActivity(this, PropertyActivity.class);
                break;
            case R.id.button_value:
                GoToActivityUtil.goToActivity(this, ValueAnimatorActivity.class);
                break;
            case R.id.button_animatorset:
                GoToActivityUtil.goToActivity(this, AnimatorSetActivity.class);
                break;
            case R.id.button_layout:
                GoToActivityUtil.goToActivity(this, LayoutAnimationActivity.class);
                break;
            case R.id.button_custom:
                GoToActivityUtil.goToActivity(this, CustomAnimationActivity.class);
                break;
            case R.id.button_svg:
                GoToActivityUtil.goToActivity(this, SVGActivity.class);
                break;
            default:
                break;

        }
    }
}
