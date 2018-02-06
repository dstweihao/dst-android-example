package com.jweihao.jdemo.ui.activity.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TimerActivity extends AppCompatActivity {

    @BindView(R.id.tv_timer)
    TextView mTvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_timer)
    public void onViewClicked() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTvTimer.setText("" + (Integer) animation.getAnimatedValue());
            }
        });
        valueAnimator.setDuration(5000);
        valueAnimator.start();
    }
}
