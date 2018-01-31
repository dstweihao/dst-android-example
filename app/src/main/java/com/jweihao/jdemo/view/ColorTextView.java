package com.jweihao.jdemo.view;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by weihao on 2018/1/23.
 */

public class ColorTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint1, mPaint2;

    public ColorTextView(Context context) {
        super(context);
        initView();
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ColorTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }


    private void initView() {

        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        //在回调父类方法前，实现自己的逻辑，对TextView来说即是在绘制文本内容前
        //绘制外层矩形
        canvas.drawRect(
                0,
                0,
                getMeasuredWidth(),
                getMeasuredHeight(),
                mPaint1
        );

        //绘制内层矩形
        canvas.drawRect(
                10,
                10,
                getMeasuredWidth() - 10,
                getMeasuredHeight() - 10,
                mPaint2
        );
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10, 0);

        //父类完成的方法，即绘制文本。
        super.onDraw(canvas);
        canvas.restore();

        //在回调父类方法后，实现自己的逻辑，对TextView来说，即是在绘制文本内容后。

    }
}
