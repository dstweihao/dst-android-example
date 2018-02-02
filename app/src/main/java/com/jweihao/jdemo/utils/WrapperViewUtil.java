package com.jweihao.jdemo.utils;

import android.view.View;

/**
 * Created by weihao on 2018/2/2.
 */

public class WrapperViewUtil {
    private View mTarget;

    public WrapperViewUtil(View target) {
        mTarget = target;
    }

    public int getWidth() {
        return mTarget.getLayoutParams().width;
    }

    public void setWidth(int width) {

        mTarget.getLayoutParams().width = width;
        mTarget.requestLayout();
    }
}
