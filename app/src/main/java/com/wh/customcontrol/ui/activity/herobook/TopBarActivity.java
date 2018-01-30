package com.wh.customcontrol.ui.activity.herobook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.Toolbar;

import com.wh.customcontrol.R;
import com.wh.customcontrol.view.TopBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TopBarActivity extends AppCompatActivity {

    @BindView(R.id.topbar)
    TopBar mTopbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);
        ButterKnife.bind(this);

        mTopbar.setOnTopbarClickListener(new TopBar.topbarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(TopBarActivity.this, "LeftButton", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(TopBarActivity.this, "RightButton", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
