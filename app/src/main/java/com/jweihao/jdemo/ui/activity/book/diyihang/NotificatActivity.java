package com.jweihao.jdemo.ui.activity.book.diyihang;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificatActivity extends AppCompatActivity {

    @BindView(R.id.button_send_notice)
    Button mButtonSendNotice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificat);
        ButterKnife.bind(this);
//        //写法二：跳转后，系统状态栏上的图标消失：

//        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//        manager.cancel(1);

    }

    @OnClick(R.id.button_send_notice)
    public void onViewClicked() {
        //从通知跳转到新界面步骤：1
        Intent intent = new Intent(this, NotificatDetailsActivity.class);
        // 2
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("This is content titile")
                .setContentText("This is content text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher))
                // 3
                .setContentIntent(pi)
                //写法一：跳转后，系统状态栏上的图标消失
                .setAutoCancel(true)
//                //设置通知的声音效果
//                .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
//                //设置通知到来时振动时长
//                .setVibrate(new long[]{0, 1000, 1000, 1000})
//                //设置LED灯以绿色的灯光一闪一闪的效果
//                .setLights(Color.GREEN, 1000, 1000)
                //设置默认的通知效果
                .setDefaults(NotificationCompat.DEFAULT_ALL)
//                //设置封装长文字信息（这两方法只会显示一种）
//                .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications,send and sync data,and use voice actions.Get the official Android IED and developer tools to build apps for Android ."))
                //设置在通知里显示一张大图
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.mipmap.meichangsu)))
                //设置通知的重要程度，这里设置最高，此时，通知不是在系统状态栏显示一个小图标了，而是弹出一个横幅。
                //并附带了通知的详细内容，表示这是一条非常重要的通知。不管用户现在是在玩游戏还是看电影，这条通知都会显示在最上方，以此引起用户的注意。
                //当然，使用这类通知一定要小心，确保你的通知内容的确是至关重要的，不然如果让用户产生反感的话，很有可能会导致我们的应用程序被卸载。
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .build();

        manager.notify(1, notification);
    }
}
