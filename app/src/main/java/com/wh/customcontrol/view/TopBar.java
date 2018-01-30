package com.wh.customcontrol.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wh.customcontrol.R;

import org.w3c.dom.Attr;

/**
 * Created by weihao on 2018/1/30.
 */

public class TopBar extends RelativeLayout {


    private Drawable mLeftBackground;
    private int mLeftTextColor;
    private String mLeftText;
    private Drawable mRightBackground;
    private int mRightTextColor;
    private String mRightText;
    private float mTitleSize;
    private int mTitleTextColor;
    private String mTitle;
    private Button mLeftButton;
    private Button mRightButton;
    private TextView mTitleView;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;
    private topbarClickListener mListener;


    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //通过这个方法，将你在attrs.xml中定义的declare-styleable的所有属性的值
        //存储到TypedArray中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        //从TypedArray中取出对应的值来为要设置的属性赋值
        //左边按钮属性获取
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor, 0);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);
        //右边按钮属性获取
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor, 0);
        mRightText = ta.getString(R.styleable.TopBar_rightText);
        //标题属性获取
        mTitleSize = ta.getDimension(R.styleable.TopBar_titleTextSize, 10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor, 0);
        mTitle = ta.getString(R.styleable.TopBar_title);
        //获取完TypeArray的值后，一般都要调用recyle方法避免重新创建的时候的错误。
        ta.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        //为创建的组件元素赋值
        //值来源于我们在引用的xml文件中给对应属性的赋值
        //左边按钮属性设置
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        //右边按钮属性设置
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        //标题栏属性设置
        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleSize);

        //为组件元素设置相应的布局元素
        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        //为该控件设置在RelativeLayout中的位置
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //添加到ViewGroup，添加一个带有指定布局参数的子视图。
        addView(mLeftButton, mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);

        addView(mRightButton, mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParams);

        //按钮的点击事件，不需要具体的实现
        //只需调用接口的方法，回调的时候，会有具体的实现
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.leftClick();
            }
        });

        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });


    }

    //暴露一个方法给调用者来注册接口回调
    //通过接口来获得回调者对接口方法的实现
    public void setOnTopbarClickListener(topbarClickListener mListener) {
        this.mListener = mListener;
    }




    //接口对象，实现回到机制，在回调方法中
    //通过映射的接口对象调用接口中的方法
    //不用去考虑如何实现，具体的实现由调用者去创建
    public interface topbarClickListener {

        //左按钮点击事件
        void leftClick();

        //右按钮点击事件
        void rightClick();


    }


}
