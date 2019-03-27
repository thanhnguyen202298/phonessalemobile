package com.aln.phonesaleschain.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;

import com.aln.phonesaleschain.R;
import com.aln.phonesaleschain.screen.home.HomeActivity;
import com.aln.phonesaleschain.utilities.Constants;

public class SSkeyNotify implements InotifySskey {

    private Notification.Builder notifyBuider;
    private NotificationManager notiMaa;
    private Notification mnotification;
    private String ChannelID = "Kimnguyen-Hrm";
    private static int NotifyID = 12579;
    private String ChannelName = "Kimnguyen-Hrm";
    private String ChannelDescription = "Kimnguyen-Hrm thông báo đơn nghỉ phép";
    private Context ctx;

    public SSkeyNotify(Context context) {
        ctx = context;
        Snotification = this;
    }

    public static InotifySskey Snotification;


    @Override
    public int getNotifyID() {
        return NotifyID;
    }

    @Override
    public Notification getNotification() {
        return mnotification;
    }

    @Override
    public void showNotify() {
        notiMaa.notify(NotifyID, notifyBuider.build());
    }

    @Override
    public void setUpNotiSsk(String notifyText) {
        boolean not8 = true;
        Notification.BigPictureStyle style = new Notification.BigPictureStyle();
        if (Build.VERSION.SDK_INT >= 26) {
            notifyBuider = new Notification.Builder(ctx, ChannelID);

            NotificationChannel channel = new NotificationChannel(ChannelID, ChannelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(ChannelDescription);

            notiMaa = ctx.getSystemService(NotificationManager.class);
            notiMaa.createNotificationChannel(channel);
            Icon icon = Icon.createWithResource(ctx, R.mipmap.ic_launcher);
            style.bigLargeIcon(icon);
        } else {
            not8 = false;
            notifyBuider = new Notification.Builder(ctx);
            notiMaa = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        notifyBuider.setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(style.setBigContentTitle(notifyText))
                .setAutoCancel(true);

        setActionNotiSSk(not8);
        setPendingNotiSSk(not8,notifyText);

        mnotification = notifyBuider.build();
    }

    @Override
    public void setUpBlk() {
        boolean not8 = true;
        if (Build.VERSION.SDK_INT >= 26) {
            notifyBuider = new Notification.Builder(ctx, ChannelID);

            NotificationChannel channel = new NotificationChannel(ChannelID, ChannelName, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(ChannelDescription);

            notiMaa = ctx.getSystemService(NotificationManager.class);
            notiMaa.createNotificationChannel(channel);
        } else {
            not8 = false;
            notifyBuider = new Notification.Builder(ctx);
            notiMaa = (NotificationManager) ctx.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        notifyBuider.setSmallIcon(R.drawable.icon_add3x)
                .setContentTitle("Kim Nguyên")
                .setContentText("Ứng dụng quản lý nhân sự")
                .setAutoCancel(true);

        mnotification = notifyBuider.build();
    }

    @Override
    public void setStyleNotiSSk() {

    }

    @Override
    public void setPendingNotiSSk(boolean noti8, String notifyText) {
        Intent it = new Intent(ctx.getApplicationContext(), HomeActivity.class);
        it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        it.putExtra(Constants.StartFromDetail, "");
        it.putExtra(Constants.StartFromNotify, "");
        Intent[] mit = new Intent[1];
        mit[0] = it;
        PendingIntent pe = PendingIntent.getActivities(ctx.getApplicationContext(), NotifyID, mit, PendingIntent.FLAG_CANCEL_CURRENT);

        notifyBuider.setContentIntent(pe);
    }

    @Override
    public void setActionNotiSSk(boolean noti8) {

    }
}
