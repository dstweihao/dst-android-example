package com.wh.customcontrol.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

/**
 * Created by weihao on 2018/1/22.
 */

public class DragSquareView extends View {

    private int lastX;
    private int lastY;
    private Scroller mScroller;

    public DragSquareView(Context context) {
        super(context);
        initView(context);
    }


    public DragSquareView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DragSquareView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        //给View设置背景颜色，便于观察
        setBackgroundColor(Color.BLUE);

        mScroller = new Scroller(context);

    }

    //1,,,视图坐标方式
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                //记录触摸点坐标
//                lastX = x;
//                lastY = y;
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                //计算偏移量
//                int offsetX = x - lastX;
//                int offsetY = y - lastY;
//                //在当前left,top,right,bottom的基础上加上偏移量。
//                layout(
//                        getLeft() + offsetX,
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY);
//
//                //另一种方式，同layout(......)方法
////                offsetLeftAndRight(offsetX);
////                offsetTopAndBottom(offsetY);
//
//                break;
//        }
//
//        return true;
//    }


    //2,,,绝对坐标方式
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        int rawX = (int) event.getRawX();
//        int rawY = (int) event.getRawY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                //记录触摸点坐标
//                lastX = rawX;
//                lastY = rawY;
//                break;
//
//            case MotionEvent.ACTION_MOVE:
//                //计算偏移量
//                int offsetX = rawX - lastX;
//                int offsetY = rawY - lastY;
//                //在当前left,top,right,bottom的基础上加上偏移量
//                layout(getLeft() + offsetX,
//                        getTop() + offsetY,
//                        getRight() + offsetX,
//                        getBottom() + offsetY
//                );
////                offsetLeftAndRight(offsetX);
////                offsetTopAndBottom(offsetY);
//
//                //重新设置初始坐标
//                lastX = rawX;
//                lastY = rawY;
//        }
//        return true;
//    }

    //3,,,通过Layoutparams方式

//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = x;
//                lastY = y;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int offsetX = x - lastX;
//                int offsetY = y - lastY;
//                //LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                //4,,,通过MarginParams
//                ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);
//                break;
//        }
//        return true;
//    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        //判断Scroller是否执行完毕
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(
                    mScroller.getCurrX(),
                    mScroller.getCurrY()

            );
            //通过重绘来不断调用computeScroll
            invalidate();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;

            case MotionEvent.ACTION_UP:
                //手指离开时，执行滑动过程
                View viewGroup = (View) getParent();
                mScroller.startScroll(
                        viewGroup.getScrollX(),
                        viewGroup.getScrollY(),
                        -viewGroup.getScrollX(),
                        -viewGroup.getScrollY(), 3000
                );
                invalidate();

            default:
                break;
        }
        return true;
    }
}
