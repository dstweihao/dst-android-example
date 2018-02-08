package com.jweihao.jdemo.ui.activity.md;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CircularRevealActivity extends AppCompatActivity {

    @BindView(R.id.oval)
    ImageView mOval;
    @BindView(R.id.rect)
    ImageView mRect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.oval, R.id.rect})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.oval:
                //以图片中心为基点，圆形收缩图片至消失。
                Animator ovalAnim = ViewAnimationUtils.createCircularReveal(
                        mOval,
                        mOval.getWidth() / 2,
                        mOval.getHeight() / 2,
                        mOval.getWidth(),
                        0
                );
                ovalAnim.setInterpolator(
                        new AccelerateDecelerateInterpolator()
                );
                ovalAnim.setDuration(3000);
                ovalAnim.start();
                break;
            case R.id.rect:
                //以图片左上角，也就是原点为基点，圆形收缩图片至消失。
                Animator rectAnim = ViewAnimationUtils.createCircularReveal(
                        mRect,
                        0,
                        0,
                        (float) Math.hypot(mRect.getWidth(), mRect.getHeight()),
                        0
                );
                rectAnim.setInterpolator(
                        new AccelerateDecelerateInterpolator()
                );
                rectAnim.setDuration(3000);
                rectAnim.start();
//                mRect.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }
}
