package com.jweihao.jdemo.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import static android.support.v4.widget.ViewDragHelper.Callback;
import static android.support.v4.widget.ViewDragHelper.create;

/**
 * Created by weihao on 2018/1/23.
 */

public class DragFramLayoutView extends FrameLayout {

    private ViewDragHelper mViewDragHelper;
    private View mMenuView, mMainView;
    private int mWidth;

    public DragFramLayoutView(@NonNull Context context) {
        super(context);
        initView();
    }


    public DragFramLayoutView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragFramLayoutView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    //获取子View
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    //获取View的宽度，如果需要根据View的宽带来处理滑动后的效果，可以使用这个值进行判断。
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mMenuView.getMeasuredWidth();

    }


    //重写事件拦截，将事件传递给ViewDragHelper进行处理
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将触摸事件传递给ViewDragHelper,此操作必不可少。
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    private void initView() {
        mViewDragHelper = create(this, callback);
    }

    private Callback callback = new Callback() {

        //何时开始检测触摸事件
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            //如果当前触摸的child是mMainView时开始检测
            return mMainView == child;
        }

        //触摸到View后回调

        @Override
        public void onViewCaptured(View capturedChild, int activePointerId) {
            super.onViewCaptured(capturedChild, activePointerId);
        }

        //当拖拽状态改变，比如idle(闲置),dragging
        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        //当位置改变的时候调用，常用与滑动时更改scale等
        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);

        }

        //处理垂直滑动
        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return top;
        }
        //处理水平滑动,使用水平滑动，只需把clampViewPositionVertical()方法return 0;
        //并且将clampViewPositionHorizontal()方法return left;即可。
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return 0;
        }
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);


            //方式一：处理垂直滑动。

            //手指抬起后缓慢移动到指定位置
            if (mMainView.getTop() < 500) {
                //关闭菜单
                //相当于Scroller的startScroll方法
                mViewDragHelper.smoothSlideViewTo(mMainView, 0, 0);
                ViewCompat.postInvalidateOnAnimation(DragFramLayoutView.this);
            } else {
                //打开菜单
                mViewDragHelper.smoothSlideViewTo(mMainView, 0, 600);
                ViewCompat.postInvalidateOnAnimation(DragFramLayoutView.this);

            }

            //方式二：处理水平滑动
            //手指抬起后缓慢移动到指定位置
//            if (mMainView.getLeft()< 500) {
//                //关闭菜单
//                //相当于Scroller的startScroll方法
//                mViewDragHelper.smoothSlideViewTo(mMainView, 0, 0);
//                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
//            } else {
//                //打开菜单
//                mViewDragHelper.smoothSlideViewTo(mMainView, 300, 0);
//                ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
//
//            }
        }
    };

    //ViewDragHelper内部也是通过Scroller来实现平滑移动的。
    @Override
    public void computeScroll() {
        if (mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }



}
