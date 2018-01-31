package com.jweihao.jdemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by weihao on 2018/1/31.
 */

public class ArcView extends View {

    public ArcView(Context context) {
        super(context);

    }


    public ArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }


    private void initView() {
        //设置好绘制三种图形的参数
        //圆

    }
}
