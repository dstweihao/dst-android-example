package com.jweihao.jdemo.ui.activity.md;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jweihao.jdemo.utils.GoToActivityUtil;
import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecyclerViewMenuActivity extends AppCompatActivity {

    @BindView(R.id.button_recycler)
    Button mButtonRecycler;
    @BindView(R.id.button_multitype)
    Button mButtonMultitype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_recycler, R.id.button_multitype})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_recycler:
                GoToActivityUtil.goToActivity(this, RecyclerActivity.class);
                break;
            case R.id.button_multitype:
                GoToActivityUtil.goToActivity(this, RecyclerViewMultiTypeActivity.class);
                break;
                default:
                    break;
        }
    }



}
