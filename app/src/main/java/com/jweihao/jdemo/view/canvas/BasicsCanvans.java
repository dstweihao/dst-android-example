package com.jweihao.jdemo.view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.jweihao.jdemo.utils.ScreenUtil;
import com.wh.customcontrol.R;

/**
 * Created by weihao on 2018/2/12.
 */

public class BasicsCanvans extends View {

    private Paint mPaint1;
    private Paint mPaint2;
    private Paint mPaint3;
    private boolean useCenter;

    public BasicsCanvans(Context context) {
        super(context);
        initView();
    }


    public BasicsCanvans(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BasicsCanvans(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public BasicsCanvans(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {


        mPaint1 = new Paint();
        mPaint1.setColor(ContextCompat.getColor(getContext(), R.color.blue));
        mPaint1.setStyle(Paint.Style.STROKE);
        mPaint1.setStrokeWidth(50);
        //取消锯齿
        mPaint1.setAntiAlias(true);

        mPaint2 = new Paint();
        mPaint2.setColor(ContextCompat.getColor(getContext(), R.color.green));
        mPaint2.setStyle(Paint.Style.FILL);
        mPaint2.setStrokeWidth(5);
        //取消锯齿
        mPaint2.setAntiAlias(true);

        //绘制扇形
        mPaint3 = new Paint();
        mPaint3.setColor(ContextCompat.getColor(getContext(), android.R.color.holo_blue_bright));
        mPaint3.setStyle(Paint.Style.FILL);
        mPaint3.setStrokeWidth(5);
        //取消锯齿
        mPaint3.setAntiAlias(true);


    }


    @Override
    protected void onDraw(Canvas canvas) {
        //空心矩形
        canvas.drawRect(
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 130),
                ScreenUtil.dip2px(getContext(), 130),
                mPaint1
        );
        //实心矩形
        canvas.drawRect(
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 160),
                ScreenUtil.dip2px(getContext(), 130),
                ScreenUtil.dip2px(getContext(), 260),
                mPaint2
        );
        //绘制点
        canvas.drawPoint(
                ScreenUtil.dip2px(getContext(), 80),
                ScreenUtil.dip2px(getContext(), 300),
                mPaint1
        );
        //绘制直线,使用ScreenUtil.dip2px()方法，将dp转换成坐标系xy的位置。
        canvas.drawLine(
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 320),
                ScreenUtil.dip2px(getContext(), 150),
                ScreenUtil.dip2px(getContext(), 320),
                mPaint2
        );

        //绘制多条直线
        float[] pts = {
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 340),
                ScreenUtil.dip2px(getContext(), 150),
                ScreenUtil.dip2px(getContext(), 340),
                ScreenUtil.dip2px(getContext(), 150),
                ScreenUtil.dip2px(getContext(), 340),
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 360),
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 360),
                ScreenUtil.dip2px(getContext(), 150),
                ScreenUtil.dip2px(getContext(), 360),
        };
        canvas.drawLines(pts, mPaint2);

        //绘制圆角矩形
        canvas.drawRoundRect(
                ScreenUtil.dip2px(getContext(), 30),
                ScreenUtil.dip2px(getContext(), 380),
                ScreenUtil.dip2px(getContext(), 130),
                ScreenUtil.dip2px(getContext(), 480),
                ScreenUtil.dip2px(getContext(), 15),
                ScreenUtil.dip2px(getContext(), 15),
                mPaint2
        );

        //绘制圆
        canvas.drawCircle(
                ScreenUtil.dip2px(getContext(), 80),
                ScreenUtil.dip2px(getContext(), 520),
                ScreenUtil.dip2px(getContext(), 25),
                mPaint2
        );

        //绘制扇形
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;

        /**
         * 使用指定的坐标创建一个新的矩形。
         * 注意：没有范围检查执行，因此调用方法必须确保:left<=right、top<=bottom
         *
         * @param left   矩形左边的X坐标
         * @param top    矩形顶部的Y坐标
         * @param right  矩形右边的X坐标
         * @param bottom 矩形底部的Y坐标
         */
        RectF oval = new RectF(x, y, getWidth() - x, getHeight() - y);
        /*
        * oval：定义圆弧的形状和大小的范围
        * startAngle：设置圆弧是从哪个角度来顺时针绘画的
        * sweepAngle：设置圆弧扫过的角度
        * useCenter: 设置我们的圆弧在绘画的时候，是否经过圆形，这个参数在我们设置为描边属性时，是没有效果的。
        *
        * */
        canvas.drawArc(
                oval,
                360,
                140,
                true,
                mPaint3
        );

        super.onDraw(canvas);
    }
}
