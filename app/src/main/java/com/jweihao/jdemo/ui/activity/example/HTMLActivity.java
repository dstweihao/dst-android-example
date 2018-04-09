package com.jweihao.jdemo.ui.activity.example;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.wh.customcontrol.R;

public class HTMLActivity extends AppCompatActivity {

    private WebView mContentWebView;
    private Button mButtom;
    private Button mButton2;


    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_html);
        mContentWebView = (WebView) findViewById(R.id.webview);
        mButtom = (Button) findViewById(R.id.button);
        mButton2 = (Button) findViewById(R.id.button2);


        //启用jacascript
        mContentWebView.getSettings().setJavaScriptEnabled(true);
        //从assets目录下面加载html
        mContentWebView.loadUrl("file:///android_asset/web.html");
        //加入js界面 参数一：将Java对象插入到WebView的JavaScript中，参数二：用于在JavaScript中公开对象的名称
        mContentWebView.addJavascriptInterface(this, "android");


        //从Button1按钮，无参调用HTML js方法
        mButtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //无参数调用JS的方法
                mContentWebView.loadUrl("javascript:javacalljs()");

            }
        });

        //Button2按钮，有参数调用HTML js方法
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //传递参数调用js的方法
                mContentWebView.loadUrl("javascript:javacalljswith(" + "'http://blog.csdn.net/Leejizhou'" + ")");
            }
        });

    }

    //由于安全原因，targetSdkVersion >= 17 需要加 @JavascriptInterface
    //JS调用Android JAVA方法名和HTML中的按钮 onClick后的别名后面的名字对应

    @JavascriptInterface
    public void startFunction() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(HTMLActivity.this, "show", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @JavascriptInterface
    public void startFunction(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(HTMLActivity.this).setMessage(text).show();
            }
        });
    }
}
