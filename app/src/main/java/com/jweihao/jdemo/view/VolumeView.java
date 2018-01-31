package com.jweihao.jdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by weihao on 2018/1/31.
 */

public class VolumeView extends View {

    private Paint mPaint;
    private int mRectCount;
    private int mWidth;
    private int mRectHeight;
    private int mRectWidth;
    private LinearGradient mLinearGradient;
    private double mRandom;
    //设置条形之间的间距
    private double offset = 5;

    public VolumeView(Context context) {
        super(context);
        initView();
    }


    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {

        //创建画笔
        mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.BLUE);
        //设置绘制类型，填充
        mPaint.setStyle(Paint.Style.FILL);
        //条形数目
        mRectCount = 12;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //视图的宽度
        mWidth = getWidth();
        //条形的高度
        mRectHeight = getHeight();
        //条形的宽度
        mRectWidth = (int) (mWidth * 0.6 / mRectCount);
        //创建一个在直线上绘制线性渐变的着色器。
        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.RED,
                Color.GREEN,
                Shader.TileMode.CLAMP
        );
        //设置或清除着色器对象.
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();
            //获取条形随机高度
            float currentHeight = (float) (mRectHeight * mRandom);

            //绘制条目
            canvas.drawRect(
                    (float) (mWidth * 0.4 / 2 + mRectWidth * i + offset),
                    currentHeight,
                    (float) (mWidth * 0.4 / 2 + mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint
            );
        }
        //延迟View的重绘
        postInvalidateDelayed(300);
    }
}

























