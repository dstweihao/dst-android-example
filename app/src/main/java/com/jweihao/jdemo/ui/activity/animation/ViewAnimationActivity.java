package com.jweihao.jdemo.ui.activity.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jweihao.jdemo.utils.ScreenUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAnimationActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_alpha, R.id.button_rotate, R.id.button_translate, R.id.button_scale, R.id.button_set})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //透明
            case R.id.button_alpha:
                AlphaAnimation aa = new AlphaAnimation(0, 1);
                aa.setDuration(2000);
                mImageview.startAnimation(aa);
                break;
            //旋转
            case R.id.button_rotate:
                //参数为，旋转的起始角度，旋转中心点的坐标。(这里设置的是旋转参考系为自身中心点)
                RotateAnimation ra = new RotateAnimation(
                        0,
                        360,
                        RotateAnimation.RELATIVE_TO_SELF,
                        0.5F,
                        RotateAnimation.RELATIVE_TO_SELF,
                        0.5F
                );
                ra.setDuration(2000);
                mImageview.startAnimation(ra);
                break;
            //位移
            case R.id.button_translate:
                TranslateAnimation ta = new TranslateAnimation(
                        0,
                        100,
                        0,
                        800
                );
                ta.setDuration(3000);

                //使用位移来实现监听事件功能
                ta.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(ViewAnimationActivity.this, "开始 TranslateAnimation", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(ViewAnimationActivity.this, "结束 TranslateAnimation", Toast.LENGTH_SHORT).show();
                    }

                    //通知动画的重复
                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                mImageview.startAnimation(ta);
                break;
            //缩放
            case R.id.button_scale:
                //(设置参数缩放的中心点为自身中心点，从0放大到2倍)
                ScaleAnimation sa = new ScaleAnimation(
                        0,
                        2,
                        0,
                        2,
                        Animation.RELATIVE_TO_SELF,
                        0.5F,
                        Animation.RELATIVE_TO_SELF,
                        0.5F
                );
                sa.setDuration(3000);
                mImageview.startAnimation(sa);
                break;
            //动画集合，通过AnimationSet，可以将动画以组合的形式展现出来。
            case R.id.button_set:
                //动画集合
                AnimationSet as = new AnimationSet(true);
                as.setDuration(3000);
                //透明
                AlphaAnimation alpha = new AlphaAnimation(0, 1);
                alpha.setDuration(3000);
                as.addAnimation(alpha);
                //位移
                TranslateAnimation translate = new TranslateAnimation(0, 100, 0, 800);
                translate.setDuration(3000);
                as.addAnimation(translate);
                mImageview.startAnimation(as);
                break;
            default:
                break;

        }
    }
}
