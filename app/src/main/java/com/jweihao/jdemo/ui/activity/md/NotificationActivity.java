package com.jweihao.jdemo.ui.activity.md;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RemoteViews;

import com.wh.customcontrol.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.button_basic)
    Button mButtonBasic;
    @BindView(R.id.button_collapsed)
    Button mButtonCollapsed;
    @BindView(R.id.button_headsup)
    Button mButtonHeadsup;
    @BindView(R.id.radio_public)
    RadioButton mRadioPublic;
    @BindView(R.id.radio_private)
    RadioButton mRadioPrivate;
    @BindView(R.id.radio_secret)
    RadioButton mRadioSecret;
    @BindView(R.id.radiogroup)
    RadioGroup mRadiogroup;
    @BindView(R.id.button_visibility)
    Button mButtonVisibility;
    private int NOTIFICATION_ID_BASIC = 1;
    private int NOTIFICATION_ID_COLLAPSE = 2;
    private int NOTIFICATION_ID_HEADSUP = 3;
    private int NOTIFICATION_ID_VISIBILITY = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.button_basic, R.id.button_collapsed, R.id.button_headsup, R.id.radio_public, R.id.radio_private, R.id.radio_secret, R.id.radiogroup, R.id.button_visibility})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            /*
            * 基本的Notification
            *
            * */
            case R.id.button_basic:
                Intent basicIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                //构造PendingIntent
                PendingIntent piBasic = PendingIntent.getActivity(this, 0, basicIntent, 0);
                //创建Notification对象
                Notification.Builder basicBuilder = new Notification.Builder(this);
                //设置Notification的各种属性
                basicBuilder.setSmallIcon(R.drawable.ic_launcher);
                basicBuilder.setContentIntent(piBasic);
                basicBuilder.setAutoCancel(true);
                basicBuilder.setLargeIcon(
                        BitmapFactory.decodeResource(
                                getResources(), R.drawable.ic_launcher
                        )
                );
                basicBuilder.setContentTitle("Basic Notifications");
                basicBuilder.setContentText("I am a basic notification");
                basicBuilder.setSubText("it is really basic");
                //通过NotificationManager来发出Notification
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID_BASIC, basicBuilder.build());
                break;
            /*
            * 折叠的Notification
            *
            * */
            case R.id.button_collapsed:
                Intent collapsedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sina.com"));
                PendingIntent piCollapsed = PendingIntent.getActivity(this, 0, collapsedIntent, 0);
                Notification.Builder collapsedBuilder = new Notification.Builder(this);
                collapsedBuilder.setSmallIcon(R.drawable.ic_launcher);
                collapsedBuilder.setContentIntent(piCollapsed);
                collapsedBuilder.setAutoCancel(true);
                collapsedBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
                //通过RemoteViews来创建自定义的Notification视图
                RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.notification);
                contentView.setTextViewText(R.id.tv_collapsed, "show me when collapsed");
                Notification notification = collapsedBuilder.build();
                notification.contentView = contentView;
                //通过RemoteViews来创建自定义的Notification视图
                RemoteViews expandedView = new RemoteViews(getPackageName(), R.layout.notification_expanded);
                notification.bigContentView = expandedView;
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(NOTIFICATION_ID_COLLAPSE, notification);
                break;
            /*
            *
            * 悬挂式Notification
            *
            * */
            case R.id.button_headsup:
                Notification.Builder headsupBuilder = new Notification.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setPriority(Notification.PRIORITY_DEFAULT)
                        .setCategory(Notification.CATEGORY_MESSAGE)
                        .setContentTitle("Headsup Notification")
                        .setContentText("I am a Headsup notification.");
                Intent push = new Intent();
                push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                push.setClass(this, NotificationActivity.class);
                PendingIntent piHeadsup = PendingIntent.getActivity(this, 0, push, PendingIntent.FLAG_CANCEL_CURRENT);
                headsupBuilder.setContentText("Head-Up Notification on Android 5.0")
                        .setFullScreenIntent(piHeadsup, true);
                NotificationManager nmHeadsup = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nmHeadsup.notify(NOTIFICATION_ID_HEADSUP, headsupBuilder.build());
                break;
            /*
            *
            * 显示等级的Notification
            *
            * */
            case R.id.button_visibility:
                Notification.Builder visibilityBuilder = new Notification.Builder(this)
                        .setContentTitle("Notification for Visibility Test");
                switch (mRadiogroup.getCheckedRadioButtonId()) {
                    case R.id.radio_public:
                        visibilityBuilder.setVisibility(Notification.VISIBILITY_PUBLIC);
                        visibilityBuilder.setContentText("Public");
                        visibilityBuilder.setSmallIcon(R.drawable.ic_public);
                        break;
                    case R.id.radio_private:
                        visibilityBuilder.setVisibility(Notification.VISIBILITY_PRIVATE);
                        visibilityBuilder.setContentText("Private");
                        visibilityBuilder.setSmallIcon(R.drawable.ic_private);
                        break;
                    case R.id.radio_secret:
                        visibilityBuilder.setVisibility(Notification.VISIBILITY_SECRET);
                        visibilityBuilder.setContentText("Secret");
                        visibilityBuilder.setSmallIcon(R.drawable.ic_secret);
                    default:
                        break;
                }

                NotificationManager nmVisibility = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nmVisibility.notify(NOTIFICATION_ID_VISIBILITY, visibilityBuilder.build());

                break;
            default:
                break;
        }
    }
}
