package com.jweihao.jdemo.ui.activity.example;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.wh.customcontrol.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class X5WebViewActivity extends AppCompatActivity {
    @BindView(R.id.progressBar1)
    ProgressBar mProgressBar1;
    private WebView mWebView;


    /*
     * 作为一个浏览器的示例展示出来，采用android + web 的模式
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5_web_view);
        ButterKnife.bind(this);


        // 网页中的视频，上屏幕的时候，可能出现闪烁的情况，需要如下设置
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        //避免输入法界面弹出后遮挡输入光标的问题
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mWebView = (WebView) findViewById(R.id.tbs_webview);
        webViewSetting();
        mWebView.loadUrl("http://www.qq.com/");
        mWebView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String s) {
                return false;
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);

            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            /*
             * 全屏播放配置
             * */

            @Override
            public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
                super.onShowCustomView(view, customViewCallback);
            }

            @Override
            public void onProgressChanged(WebView webView, int newProgress) {

                if (newProgress == 100) {
                    //加载完成网页进度条消失
                    mProgressBar1.setVisibility(View.GONE);

                } else {
                    //k开始加载网页时显示进度条
                    mProgressBar1.setVisibility(View.VISIBLE);
                    //设置进度值
                    mProgressBar1.setProgress(newProgress);
                }
            }
        });


    }

    private void webViewSetting() {

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //设置可以访问文件
        webSettings.setAllowFileAccess(true);
        //排版适应屏幕
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        //是否应该支持使用其屏幕缩放控件和手势缩放
        webSettings.setSupportZoom(true);
        //设置固定的缩放控制
        webSettings.setBuiltInZoomControls(true);
        //设置此属性，可任意比例缩放。
        webSettings.setUseWideViewPort(true);
        // 网页内容的宽度是否可大于WebView控件的宽度
        webSettings.setLoadWithOverviewMode(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportMultipleWindows(false);
        webSettings.setAppCacheEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setAppCacheMaxSize(Long.MAX_VALUE);
        webSettings.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSettings.setDatabasePath(this.getDir("databases", 0).getPath());
        webSettings.setGeolocationDatabasePath(this.getDir("geolocation", 0).getPath());
        webSettings.setPluginState(WebSettings.PluginState.ON_DEMAND);

        //以下接口禁止(直接或反射)调用，避免视频画面无法显示：
        //webView.setLayerType();
        mWebView.setDrawingCacheEnabled(true);

        //去除QQ浏览器推广广告
        getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                ArrayList<View> outView = new ArrayList<View>();
                getWindow().getDecorView().findViewsWithText(outView,"QQ浏览器",View.FIND_VIEWS_WITH_TEXT);
                if(outView.size()>0){
                    outView.get(0).setVisibility(View.GONE);
                }
            }
        });
    }

    /*
     * 按返回键返回上一页，而不是直接退出
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
