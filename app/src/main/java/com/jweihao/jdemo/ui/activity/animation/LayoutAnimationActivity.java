package com.jweihao.jdemo.ui.activity.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jweihao.jdemo.utils.ScreenUtil;
import com.wh.customcontrol.R;

import java.lang.reflect.Proxy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LayoutAnimationActivity extends AppCompatActivity {

    @BindView(R.id.la_ll)
    LinearLayout mLaLl;
    @BindView(R.id.button_addview)
    Button mButtonAddview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.button_addview)
    public void onViewClicked() {

        //设置过渡动画
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(2000);
        //设置布局动画的显示属性

        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5F);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //为ViewGroup设置布局动画
        mLaLl.setLayoutAnimation(lac);
        mLaLl.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(this);
        textView.setTextSize(18);
        textView.setGravity(Gravity.CENTER);
        textView.setText("梅长苏");
        textView.setTextColor(Color.BLACK);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.mipmap.meichangsu);
        int screenWidthPx = ScreenUtil.getScreenWidthPx(this);
        //下面必须使用LinearLayout，如果使用ViewGroup的LayoutParams，则会报空指针异常。
        //方式一：
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                screenWidthPx, LinearLayout.LayoutParams.WRAP_CONTENT);
        //方式二：使用MarginLayoutParams可以适用LinearLayout和RelativeLayout布局。
        ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(
                screenWidthPx, LinearLayout.LayoutParams.WRAP_CONTENT);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setMaxWidth(screenWidthPx);
        imageView.setMaxHeight(screenWidthPx);
        mLaLl.addView(imageView);
        mLaLl.addView(textView);


    }
}
