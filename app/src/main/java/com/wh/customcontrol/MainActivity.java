package com.wh.customcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wh.customcontrol.ui.activity.classroom.Level3MenuActivity;
import com.wh.customcontrol.ui.activity.herobook.ColorTextActivity;
import com.wh.customcontrol.ui.activity.herobook.DragFramLayoutActivity;
import com.wh.customcontrol.ui.activity.herobook.DragSquareActivity;
import com.wh.customcontrol.ui.activity.herobook.MeasureActivity;
import com.wh.customcontrol.ui.activity.herobook.ShineTextViewActivity;
import com.wh.customcontrol.ui.activity.herobook.TopBarActivity;
import com.wh.customcontrol.utils.GoToActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


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
    @BindView(R.id.button_topbar)
    Button mButtonTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button_3menu, R.id.button_square, R.id.button_framlayout, R.id.button_view, R.id.button_text_color, R.id.button_text_shine,R.id.button_topbar})
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
            case R.id.button_topbar:
                GoToActivity.goToActivity(this, TopBarActivity.class);
            default:
                break;


        }
    }


}
