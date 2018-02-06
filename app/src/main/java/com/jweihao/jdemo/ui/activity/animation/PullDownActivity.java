package com.jweihao.jdemo.ui.activity.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PullDownActivity extends AppCompatActivity {

    @BindView(R.id.app_icon)
    ImageView mAppIcon;
    @BindView(R.id.tv_hidden)
    TextView mTvHidden;
    @BindView(R.id.hidden_view)
    LinearLayout mHiddenView;
    private float mDensity;
    private int mHiddenViewMeasuredHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_down);
        ButterKnife.bind(this);

        //获取像素密度
        mDensity = getResources().getDisplayMetrics().density;
        /*
        * 优化方案，通过view.post()方法，获取view的高度来赋值，而不是直接写75固定高度
        * 但是，因为，获取到mHiddenView的高度是263，不知道为什么不准确，后期再优化。
        * */
        mHiddenView.post(new Runnable() {
            @Override
            public void run() {
                int height = mHiddenView.getHeight();
                mHiddenView.setVisibility(View.GONE);
            }
        });
        //获取布局的高度
        mHiddenViewMeasuredHeight = (int) (mDensity * 75 + 0.5);


    }

    public void llClick(View view) {
        if (mHiddenView.getVisibility() == View.GONE) {
            //打开动画
            animateOpen(mHiddenView);
        } else {
            animateClose(mHiddenView);

        }
    }

    private void animateOpen(final View view) {
        view.setVisibility(View.VISIBLE);
        ValueAnimator animator = createDropAnimator(view, 0, mHiddenViewMeasuredHeight);
        animator.start();
    }


    private void animateClose(final View view) {
        int origHeight = view.getHeight();
        ValueAnimator animator = createDropAnimator(view, origHeight, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);

            }
        });
        animator.start();

    }


    private ValueAnimator createDropAnimator(final View view, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer value = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = value;
                view.setLayoutParams(layoutParams);

            }
        });

        return animator;
    }


}
