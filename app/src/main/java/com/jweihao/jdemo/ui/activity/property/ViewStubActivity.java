package com.jweihao.jdemo.ui.activity.property;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewStubActivity extends AppCompatActivity {

    @BindView(R.id.button_visible)
    Button mButtonVisible;
    @BindView(R.id.button_inflate)
    Button mButtonInflate;
    @BindView(R.id.viewstub)
    ViewStub mViewstub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_visible, R.id.button_inflate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /*
            * 通过调用ViewStub的setVisibility()方法来显示这个View
            *
            * */
            case R.id.button_visible:
                mViewstub.setVisibility(View.VISIBLE);
                break;
           /*
            * 通过调用ViewStub的inflate()方法来显示这个View
            *
            * */
            case R.id.button_inflate:
                View inflate = mViewstub.inflate();
                TextView textView = (TextView) inflate.findViewById(R.id.viewstub_tv);
                textView.setText("Haha!");
                break;
            default:
                break;
        }
    }
}
