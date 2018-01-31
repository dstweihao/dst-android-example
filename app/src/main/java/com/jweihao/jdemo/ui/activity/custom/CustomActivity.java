package com.jweihao.jdemo.ui.activity.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivity;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomActivity extends AppCompatActivity {

    @BindView(R.id.button_3menu)
    Button mButton3menu;
    @BindView(R.id.button_square)
    Button mButtonSquare;
    @BindView(R.id.button_framlayout)
    Button mButtonFramlayout;
    @BindView(R.id.button_view)
    Button mButtonView;
    @BindView(R.id.button_text_color)
    Button mButtonTextColor;
    @BindView(R.id.button_text_shine)
    Button mButtonTextShine;
    @BindView(R.id.button_jtoolbar)
    Button mButtonJToolbar;
    @BindView(R.id.button_circle)
    Button mButtonCircle;
    @BindView(R.id.button_volume)
    Button mButtonVolume;
    @BindView(R.id.button_scroll)
    Button mButtonScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_3menu, R.id.button_square, R.id.button_framlayout, R.id.button_view, R.id.button_text_color, R.id.button_text_shine, R.id.button_jtoolbar, R.id.button_circle, R.id.button_volume,R.id.button_scroll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_3menu:
                GoToActivity.goToActivity(this, Level3MenuActivity.class);
                break;
            case R.id.button_square:
                GoToActivity.goToActivity(this, DragSquareActivity.class);
                break;
            case R.id.button_framlayout:
                GoToActivity.goToActivity(this, DragFramLayoutActivity.class);
                break;
            case R.id.button_view:
                GoToActivity.goToActivity(this, MeasureActivity.class);
                break;
            case R.id.button_text_color:
                GoToActivity.goToActivity(this, ColorTextActivity.class);
                break;
            case R.id.button_text_shine:
                GoToActivity.goToActivity(this, ShineTextViewActivity.class);
                break;
            case R.id.button_jtoolbar:
                GoToActivity.goToActivity(this, JToolBarActivity.class);
                break;

            case R.id.button_circle:
                GoToActivity.goToActivity(this, CircleProgressActivity.class);
                break;
            case R.id.button_volume:
                GoToActivity.goToActivity(this, VolumeActivity.class);
                break;
            case R.id.button_scroll:
                GoToActivity.goToActivity(this, ReboundScrollActivity.class);
                break;
            default:
                break;

        }
    }


}
