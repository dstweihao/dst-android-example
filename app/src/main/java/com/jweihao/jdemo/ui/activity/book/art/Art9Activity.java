package com.jweihao.jdemo.ui.activity.book.art;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wh.customcontrol.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Art9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art9);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_9, R.id.button_10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_9:
                break;
            case R.id.button_10:
                break;
            default:
                break;
        }
    }
}
