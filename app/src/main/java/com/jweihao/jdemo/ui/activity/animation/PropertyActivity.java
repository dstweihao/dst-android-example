package com.jweihao.jdemo.ui.activity.animation;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PropertyActivity extends AppCompatActivity {

    @BindView(R.id.button_translate)
    Button mButtonTranslate;
    @BindView(R.id.imageview)
    ImageView mImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_translate)
    public void onViewClicked() {
        /*
        * 分别使用PropertyValuesHolder对象控制transltionX,scaleX,scaleY这三个属性
        * 最后调用ObjectAnimator.ofPropertyValuesHolder方法实现多属性的共同作用。
        * 整个实现方法非常类似AnimationSet的使用。
        * */
        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300f);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator
                .ofPropertyValuesHolder(mImageview, pvh1, pvh2, pvh3)
                .setDuration(1000)
                .start();

    }
}
