package com.jweihao.jdemo.ui.activity.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValueAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.button_value)
    Button mButtonValue;
    @BindView(R.id.imageview)
    ImageView mImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_value)
    public void onViewClicked() {

         ValueAnimator valueAnimator = ValueAnimator
                .ofFloat(
                        0,100
                );
        valueAnimator.setTarget(mImageview);
        valueAnimator.setDuration(1000).start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();

            }
        });
    }
}
