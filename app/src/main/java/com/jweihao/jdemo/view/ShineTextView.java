package com.jweihao.jdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;

/**
 * Created by weihao on 2018/1/23.
 */

public class ShineTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint;
    private Matrix mGradientMatrix;
    private LinearGradient mLinearGradient;
    private int mTranslate = 0;
    private int mViewWidth = 0;

    public ShineTextView(Context context) {
        super(context);
    }

    public ShineTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.BLUE,
                                0xffffffff,
                                Color.RED
                        },
                        null,
                        Shader.TileMode.CLAMP
                );
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();


            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}
