package com.jweihao.jdemo.ui.activity.md;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
*
* 视图裁剪
*
* */
public class ClippingActivity extends AppCompatActivity {

    @BindView(R.id.tv_rect)
    View mTvRect;
    @BindView(R.id.tv_circle)
    View mTvCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clipping);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_rect, R.id.tv_circle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_rect:
                //获取Outline
                ViewOutlineProvider rect = new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        //修改outline为特定形状
                        outline.setRoundRect(
                                0,
                                0,
                                view.getWidth(),
                                view.getHeight(),
                                30
                        );
                    }
                };
                //重新设置形状
                mTvRect.setOutlineProvider(rect);
                break;
            case R.id.tv_circle:
                //获取Outline
                ViewOutlineProvider circle = new ViewOutlineProvider() {
                    @Override
                    public void getOutline(View view, Outline outline) {
                        //修改outline为特定形状
                        outline.setOval(
                                0,
                                0,
                                view.getWidth(),
                                view.getHeight()
                        );
                    }
                };
                //重新设置形状
                mTvCircle.setOutlineProvider(circle);
                break;
            default:
                break;
        }
    }
}
