package com.jweihao.jdemo.ui.activity.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jweihao.jdemo.utils.WrapperViewUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimatorActivity extends AppCompatActivity {

    @BindView(R.id.button_alpha)
    Button mButtonAlpha;
    @BindView(R.id.button_rotate)
    Button mButtonRotate;
    @BindView(R.id.button_translate)
    Button mButtonTranslate;
    @BindView(R.id.button_scale)
    Button mButtonScale;
    @BindView(R.id.button_set)
    Button mButtonSet;
    @BindView(R.id.imageview)
    ImageView mImageview;
    @BindView(R.id.button_wrapper)
    Button mButtonWrapper;
    @BindView(R.id.button_xml)
    Button mButtonXml;
    @BindView(R.id.button_animate)
    Button mButtonAnimate;
    private boolean isStart = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_alpha, R.id.button_rotate, R.id.button_translate,
            R.id.button_scale, R.id.button_set, R.id.imageview, R.id.button_wrapper, R.id.button_xml,
            R.id.button_animate
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //透明
            case R.id.button_alpha:
                if (isStart) {
                    ObjectAnimator alpha = ObjectAnimator.ofFloat(
                            mImageview,
                            "alpha",
                            //动画将在一段时间内激活的一组值。
                            0
                    );
                    alpha.setDuration(1000);

                    //动画的监听方式一
                    alpha.addListener(new Animator.AnimatorListener() {
                        //开始
                        @Override
                        public void onAnimationStart(Animator animation) {
                            Toast.makeText(ObjectAnimatorActivity.this, "开始", Toast.LENGTH_SHORT).show();

                        }

                        //结束
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            Toast.makeText(ObjectAnimatorActivity.this, "结束", Toast.LENGTH_SHORT).show();
                        }

                        //取消
                        @Override
                        public void onAnimationCancel(Animator animation) {
                            Toast.makeText(ObjectAnimatorActivity.this, "取消", Toast.LENGTH_SHORT).show();
                        }

                        //重复
                        @Override
                        public void onAnimationRepeat(Animator animation) {
                            Toast.makeText(ObjectAnimatorActivity.this, "重复", Toast.LENGTH_SHORT).show();
                        }
                    });

                    //动画监听方式二，可以选择性的选择监听方法
                    alpha.addListener(new AnimatorListenerAdapter() {
                        //取消
                        @Override
                        public void onAnimationCancel(Animator animation) {
                            super.onAnimationCancel(animation);
                        }

                        //结束
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                        }

                        //重复
                        @Override
                        public void onAnimationRepeat(Animator animation) {
                            super.onAnimationRepeat(animation);
                        }

                        //开始
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                        }

                        //暂停
                        @Override
                        public void onAnimationPause(Animator animation) {
                            super.onAnimationPause(animation);
                        }

                        //恢复
                        @Override
                        public void onAnimationResume(Animator animation) {
                            super.onAnimationResume(animation);
                        }
                    });
                    alpha.start();
                    isStart = false;
                } else {

                    ObjectAnimator alpha = ObjectAnimator.ofFloat(
                            mImageview,
                            "alpha",
                            //动画将在一段时间内激活的一组值。
                            1
                    );
                    alpha.setDuration(1000);
                    alpha.start();
                    isStart = true;
                }

                break;
            /*
            * 旋转
            * 设置rotation 为2D旋转
            * 设置rotationX 为3D以X方向为轴旋转
            * 设置rotationY 为3D以Y方向为轴旋转
            *
            * */
            case R.id.button_rotate:
                if (isStart) {
                    ObjectAnimator translation = ObjectAnimator.ofFloat(
                            mImageview,
                            "rotationY",
                            //图片旋转360° 十次。
                            3600
                    );
                    translation.setDuration(5000);
                    translation.start();
                    isStart = false;
                } else {
                    ObjectAnimator translation = ObjectAnimator.ofFloat(
                            mImageview,
                            "rotationY",
                            //动画将在一段时间内激活的一组值。
                            0
                    );
                    translation.setDuration(5000);
                    translation.start();
                    isStart = true;
                }
                break;
            //平移
            case R.id.button_translate:
                if (isStart) {
                    ObjectAnimator translation = ObjectAnimator.ofFloat(
                            mImageview,
                            "translationY",
                            //动画将在一段时间内激活的一组值。
                            800
                    );
                    translation.setDuration(1000);
                    translation.start();
                    isStart = false;
                } else {
                    ObjectAnimator translation = ObjectAnimator.ofFloat(
                            mImageview,
                            "translationY",
                            //动画将在一段时间内激活的一组值。
                            100
                    );
                    translation.setDuration(1000);
                    translation.start();
                    isStart = true;
                }

                break;
            //围绕支点进行2D缩放
            case R.id.button_scale:
                if (isStart) {
                    ObjectAnimator translation = ObjectAnimator.ofFloat(
                            mImageview,
                            "scaleX",
                            //图片旋转360° 十次。
                            2
                    );
                    translation.setDuration(1000);
                    translation.start();
                    isStart = false;
                } else {
                    ObjectAnimator translation = ObjectAnimator.ofFloat(
                            mImageview,
                            "scaleX",
                            //动画将在一段时间内激活的一组值。
                            1
                    );
                    translation.setDuration(1000);
                    translation.start();
                    isStart = true;
                }
                break;

            //旋转和缩放变换处理
            case R.id.button_set:
                Animation aa = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
                mImageview.startAnimation(aa);
                break;
            case R.id.button_wrapper:
                if (isStart) {
                    WrapperViewUtil wrapper = new WrapperViewUtil(mImageview);
                    ObjectAnimator
                            .ofInt(wrapper, "width", 500)
                            .setDuration(1000)
                            .start();
                    isStart = false;
                } else {
                    WrapperViewUtil wrapper = new WrapperViewUtil(mImageview);
                    ObjectAnimator
                            .ofInt(wrapper, "width", 100)
                            .setDuration(1000)
                            .start();
                    isStart = true;

                }

                break;
            case R.id.button_xml:
                Animator animator = AnimatorInflater.loadAnimator(this, R.animator.scalex);
                animator.setTarget(mImageview);
                animator.start();
                break;
            case R.id.button_animate:
                mImageview.animate()
                        .alpha(0)
                        .y(600)
                        .setDuration(2000)
                        .withStartAction(new Runnable() {
                            @Override
                            public void run() {

                            }
                        })
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {

                            }
                        })
                        .start();
                break;

            default:
                break;

        }
    }


}
