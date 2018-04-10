package com.jweihao.jdemo.ui.activity.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SlingActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sling);
        ButterKnife.bind(this);


        //启用jacascript
        mWebview.getSettings().setJavaScriptEnabled(true);
        //从assets目录下面加载html
        mWebview.loadUrl("file:///android_asset/kl2.html");
    }
}
