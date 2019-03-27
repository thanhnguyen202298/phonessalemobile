package com.aln.phonesaleschain.service;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.List;

public class WakeServiceSSk {
    public static String MYBOOT_ACTION = "android.intent.action.BOOT_COMPLETED";
    public static String MYPACKAGE_ACTION = "android.intent.action.PACKAGE_ADDED";
    public static String empCode;
//    public static BootEventReceiver serviceReceiver = new BootEventReceiver();

    public WakeServiceSSk() {

    }

    public static void onWWake(Context context, String code) {
//        if (Build.VERSION.SDK_INT > 26) {
//            if (context.checkSelfPermission(Manifest.permission.RECEIVE_BOOT_COMPLETED.toString()) > 0) {
//
//            }
//        }
        Log.e("<<Alarm", "start in alarm");

        Intent it = new Intent(context, TestService.class);
        empCode = code;

        try {

            ActivityManager manager = ActivityCompat.getSystemService(context, ActivityManager.class);
            List<ActivityManager.RunningServiceInfo> svicIn = manager.getRunningServices(Integer.MAX_VALUE);
            if(svicIn!=null)
                for (ActivityManager.RunningServiceInfo si:svicIn) {
                    if(si.service.getClassName().equals(TestService.class.getName()))
                        return;
                }

            if (Build.VERSION.SDK_INT >= 26)
                context.startForegroundService(it);
            else context.startService(it);

        }catch (Exception ex) {
            PendingIntent peservcie = PendingIntent.getService(context, TestService.SServiceID, it, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager alm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alm.cancel(peservcie);
            alm.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 3000, 60000, peservcie);
        }
//        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP)
//            alm.setAlarmClock(new AlarmManager.AlarmClockInfo(System.currentTimeMillis()+2000,peservcie),peservcie);
//        else alm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+2000, peservcie);

    }

    public static void cancelAlarrm(Context context){
        Intent it = new Intent(context, TestService.class);
//        Intent it = new Intent(MYSERVICE_ACTION);
        PendingIntent peservcie = PendingIntent.getService(context, TestService.SServiceID, it, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alm.cancel(peservcie);
        Log.e("<<cancel Alarm", "can s");
    }

}
