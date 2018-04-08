package com.jweihao.jdemo.ui.activity.book.hero.custom;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.jweihao.jdemo.utils.GoToActivityUtil;
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
    @BindView(R.id.button_incident)
    Button mButtonIncident;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_3menu, R.id.button_square, R.id.button_framlayout, R.id.button_view,
            R.id.button_text_color, R.id.button_text_shine, R.id.button_jtoolbar, R.id.button_circle,
            R.id.button_volume, R.id.button_scroll,R.id.button_incident
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_3menu:
                GoToActivityUtil.goToActivity(this, Level3MenuActivity.class);
                break;
            case R.id.button_square:
                GoToActivityUtil.goToActivity(this, DragSquareActivity.class);
                break;
            case R.id.button_framlayout:
                GoToActivityUtil.goToActivity(this, DragFramLayoutActivity.class);
                break;
            case R.id.button_view:
                GoToActivityUtil.goToActivity(this, MeasureActivity.class);
                break;
            case R.id.button_text_color:
                GoToActivityUtil.goToActivity(this, ColorTextActivity.class);
                break;
            case R.id.button_text_shine:
                GoToActivityUtil.goToActivity(this, ShineTextViewActivity.class);
                break;
            case R.id.button_jtoolbar:
                GoToActivityUtil.goToActivity(this, JToolBarActivity.class);
                break;

            case R.id.button_circle:
                GoToActivityUtil.goToActivity(this, CircleProgressActivity.class);
                break;
            case R.id.button_volume:
                GoToActivityUtil.goToActivity(this, VolumeActivity.class);
                break;
            case R.id.button_scroll:
                GoToActivityUtil.goToActivity(this, ReboundScrollActivity.class);
                break;
            case R.id.button_incident:
                GoToActivityUtil.goToActivity(this, ViewActivity.class);
                break;
            default:
                break;
        }
    }
}
