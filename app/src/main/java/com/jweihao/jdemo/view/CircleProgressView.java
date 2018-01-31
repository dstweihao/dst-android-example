package com.jweihao.jdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.wh.customcontrol.R;

/**
 * Created by weihao on 2018/1/31.
 */

public class CircleProgressView extends View {

    private int mMeasureWidth;
    private int mMeasureHeight;
    private float mCircleXY;
    private float mRadius;
    private Paint mCirclePaint;
    private RectF mArcRectF;
    private float mSweepValue = 50;
    private float mSweepAngle;
    private Paint mArcPaint;
    private String mShowText;
    private float mShowTextSize;
    private Paint mTextPaint;


    public CircleProgressView(Context context) {
        super(context);

    }


    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //从所提供的测量规范中提取尺寸。
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        //测量宽度和高度，如果这不这样做，那么将触发一个测量时间异常。
        setMeasuredDimension(mMeasureWidth, mMeasureHeight);

        initView();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆
        canvas.drawCircle(
                mCircleXY,
                mCircleXY,
                mRadius,
                mCirclePaint
        );

        //绘制弧线
        canvas.drawArc(
                mArcRectF,
                270,
                mSweepAngle,
                false,
                mArcPaint
        );

        //绘制文字
        canvas.drawText(
                mShowText,
                0,
                mShowText.length(),
                mCircleXY,
                mCircleXY + (mShowTextSize / 4),
                mTextPaint
        );

    }

    private void initView() {
        float length = 0;
        if (mMeasureHeight >= mMeasureWidth) {
            length = mMeasureWidth;
        } else {
            length = mMeasureHeight;
        }

        //绘制圆需要的参数
        mCircleXY = length / 2;

        //设置圆的半径
        mRadius = (float) (length * 0.5 / 2);

        //创建圆的画笔
        mCirclePaint = new Paint();
        //设置圆的颜色
        mCirclePaint.setColor(ContextCompat.getColor(getContext(), R.color.green));

        //绘制椭圆外接矩形的参数
        mArcRectF = new RectF(
                (float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.9),
                (float) (length * 0.9)

        );

        mSweepAngle = (mSweepValue / 100f) * 360f;

        //创建外接矩形的画笔
        mArcPaint = new Paint();
        //设置抗锯齿
        mArcPaint.setAntiAlias(true);
        //设置矩形颜色
        mArcPaint.setColor(ContextCompat.getColor(getContext(), android.R.color.holo_blue_bright));
        //设置画笔宽度
        mArcPaint.setStrokeWidth((float) (length * 0.1));
        //设置绘制轮廓，描边
        mArcPaint.setStyle(Paint.Style.STROKE);

        //设置文字的参数
        mShowText = setShowText();
        mShowTextSize = setShowTextSize();

        //创建文字的画笔
        mTextPaint = new Paint();
        //设置文字的颜色
        mTextPaint.setColor(ContextCompat.getColor(getContext(), android.R.color.white));
        //设置文字大小
        mTextPaint.setTextSize(mShowTextSize);
        //设置排列在中间
        mTextPaint.setTextAlign(Paint.Align.CENTER);


    }

    private float setShowTextSize() {
        this.invalidate();
        return 50;
    }

    private String setShowText() {
        this.invalidate();
        return "Android Skill";
    }

    public void forceInvalidate() {
        this.invalidate();
    }

    public void setSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            mSweepValue = sweepValue;
        } else {
            mSweepValue = 25;
        }

        this.invalidate();
    }
}
