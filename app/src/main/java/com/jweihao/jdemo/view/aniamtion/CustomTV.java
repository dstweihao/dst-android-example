package com.jweihao.jdemo.view.aniamtion;

import android.graphics.Matrix;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * 模拟电视关闭的动画
 * Created by weihao on 2018/2/5.
 */

public class CustomTV extends Animation {


    private int mCenterWidth;
    private int mCenterHeight;


    //用对象的尺寸来初始化这个动画。
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        //设置默认时长
        setDuration(1000);
        //动画结束后保留状态
        setFillAfter(true);
        //设置默认插值器
        setInterpolator(new AccelerateInterpolator());
        mCenterWidth = width / 2;
        mCenterHeight = height / 2;

    }



    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = t.getMatrix();
        matrix.preScale(
                1,
                1 - interpolatedTime,
                mCenterWidth,
                mCenterHeight
        );

    }
}
