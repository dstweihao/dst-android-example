package com.jweihao.jdemo.ui.activity.layout;

import android.content.res.Resources;
import android.os.Bundle;

import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.jweihao.jdemo.adapter.FragPagerAdapter;
import com.jweihao.jdemo.utils.ScreenUtil;
import com.jweihao.jdemo.view.JudgeNestedScrollView;
import com.wh.customcontrol.R;

/*
* NestedScrollView + Tablayout + ViewPager + RecyclerView
*
* */

public class NTVRActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private TabLayout mTabLayout_top;
    private JudgeNestedScrollView mScrollView;
    private int mToolbarPositionY;
    private android.support.v7.widget.Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ntvr);
        initView();
    }
    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        mTabLayout_top = (TabLayout) findViewById(R.id.tablayout_top);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_name);
        mScrollView = (JudgeNestedScrollView) findViewById(R.id.scrollView);
        //将viewPager和Fragment绑定
        FragPagerAdapter fragPagerAdapter = new FragPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(fragPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout_top.setupWithViewPager(mViewPager);
        mToolbar.post(new Runnable() {
            @Override
            public void run() {
                mToolbarPositionY = mToolbar.getHeight() + getStatusBarHeight();
                ViewGroup.LayoutParams params = mViewPager.getLayoutParams();
                int screenHeightPx = ScreenUtil.getScreenHeightPx(getApplicationContext());
                params.height = screenHeightPx - mToolbarPositionY - mTabLayout.getHeight() + 1;
                mViewPager.setLayoutParams(params);

            }
        });
        mScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int[] location = new int[2];
                mTabLayout.getLocationOnScreen(location);
                int xPosition = location[0];
                float yPosition = (float) location[1];
                if (yPosition < mToolbarPositionY) {
                    mTabLayout_top.setVisibility(View.VISIBLE);
                    mScrollView.setNeedScroll(false);
                } else {
                    mTabLayout_top.setVisibility(View.GONE);
                    mScrollView.setNeedScroll(true);
                }


            }
        });

    }

    //状态栏高度
    public static int getStatusBarHeight() {
        return Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
    }


}
