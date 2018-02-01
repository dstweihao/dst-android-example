package com.jweihao.jdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by weihao on 2018/2/1.
 */

public class MyViewGroupB extends ViewGroup {
    public MyViewGroupB(Context context) {
        super(context);
    }

    public MyViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyViewGroupB(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("xys", "ViewGroupB dispatchTouchEvent" + ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d("xys", "ViewGroupB onInterceptTouchEvent" + ev.getAction());
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.d("xys", "ViewGroupB onTouchEvent" + ev.getAction());
        return super.onTouchEvent(ev);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }
}
