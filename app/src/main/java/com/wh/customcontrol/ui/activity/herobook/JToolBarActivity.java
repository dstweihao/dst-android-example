package com.wh.customcontrol.ui.activity.herobook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wh.customcontrol.R;
import com.wh.jtoolbar.JToolBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JToolBarActivity extends AppCompatActivity {

    @BindView(R.id.jtoolbar)
    JToolBar mJToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);
        ButterKnife.bind(this);

        mJToolBar.setOnTopbarClickListener(new JToolBar.jToolBarClickListener() {
            @Override
            public void leftClick() {
                Toast.makeText(JToolBarActivity.this, "LeftButton", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(JToolBarActivity.this, "RightButton", Toast.LENGTH_SHORT).show();

            }
        });
        mJToolBar.setButtonVisable(JToolBar.LEFT_BUTTON, false);
        mJToolBar.setButtonVisable(JToolBar.RIGHT_BUTTON,true);

    }


}
