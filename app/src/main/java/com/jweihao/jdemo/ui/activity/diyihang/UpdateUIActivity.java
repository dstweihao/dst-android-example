package com.jweihao.jdemo.ui.activity.diyihang;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateUIActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView mText;
    private static final int UPDATE_TEXT = 1;
    private  Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    //在这里可以进行UI操作
                    mText.setText("Nice to meet you ! ");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_ui);
        ButterKnife.bind(this);

    }

//    @OnClick(R.id.Change_text)
//    public void onViewClicked() {
//        /*
//        * 报错：Only the original thread that created a view hierarchy can touch its views.
//        * 报错：只有创建了视图层次结构的原始线程才能触及它的视图。意思就是只能在主线程更新UI。
//        * */
//      new Thread(new Runnable() {
//          @Override
//          public void run() {
//              mText.setText("Nice to meet you !");
//          }
//      }).start();
//    }

    @OnClick(R.id.Change_text)
    public void onViewClicked() {

        Message message = new Message();
        message.what = UPDATE_TEXT;
        //将Message 对象发送出去
        mHandler.sendMessage(message);
    }
}
