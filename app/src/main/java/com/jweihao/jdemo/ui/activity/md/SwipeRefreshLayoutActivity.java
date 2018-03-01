package com.jweihao.jdemo.ui.activity.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.jweihao.jdemo.ui.activity.example.WeiBoActivity;
import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    @BindView(R.id.button_swipeRefresh_base)
    Button mButtonSwipeRefreshBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_swipeRefresh_base)
    public void onViewClicked() {
        GoToActivityUtil.goToActivity(this, WeiBoActivity.class);
    }
}
