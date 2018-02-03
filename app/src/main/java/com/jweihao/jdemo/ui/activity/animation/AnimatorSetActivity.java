package com.jweihao.jdemo.ui.activity.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorSetActivity extends AppCompatActivity {

    @BindView(R.id.button_animatorset)
    Button mButtonAnimatorset;
    @BindView(R.id.imageview)
    ImageView mImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_set);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_animatorset)
    public void onViewClicked() {

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageview, "translationX", 300f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageview, "scaleX", 1f, 0f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageview, "scaleY", 1f, 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animator1, animator2, animator3);
        set.start();
    }
}
