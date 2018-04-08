package com.jweihao.jdemo.ui.activity.book.hero.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


import com.jweihao.JToolBar;
import com.wh.customcontrol.R;


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
        mJToolBar.setButtonVisable(JToolBar.LEFT_BUTTON, true);
        mJToolBar.setButtonVisable(JToolBar.RIGHT_BUTTON,true);

    }


}
