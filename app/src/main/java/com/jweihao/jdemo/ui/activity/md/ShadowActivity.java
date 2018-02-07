package com.jweihao.jdemo.ui.activity.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
* 视图与阴影
*
* */
public class ShadowActivity extends AppCompatActivity {

    @BindView(R.id.imageview_shadow)
    TextView mImageviewShadow;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.imageview_shadow)
    public void onViewClicked() {
        if (flag) {
            /*
            *  translationZ(10)  设置阴影区域的大小为10
            *  translationY(100) 将视图view向下移动100像素
            *  translationX(100) 将视图view向右移动100像素
            * */
            mImageviewShadow.animate().translationZ(100);
            flag = false;
        } else {
            mImageviewShadow.animate().translationZ(0);
            flag = true;
        }

    }
}
