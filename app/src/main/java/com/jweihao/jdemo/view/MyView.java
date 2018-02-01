package com.jweihao.jdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by weihao on 2018/2/1.
 */

public class MyView extends ViewGroup {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d("xys", "View onTouchEvent" + event.getAction());
        return super.onTouchEvent(event);
    }

    //下发,将触摸屏幕运动事件向下传递到目标视图，或者该视图是否为目标。

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xys", "View dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    //拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("xys", "View onInterceptTouchEvent" + ev.getAction());
        return true;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
