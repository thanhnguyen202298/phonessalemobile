package com.aln.phonesaleschain.service;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.aln.phonesaleschain.gps.MyLocationListener;
import com.aln.phonesaleschain.notification.InotifySskey;
import com.aln.phonesaleschain.notification.SSkeyNotify;

public class TestService extends Service implements MyLocationListener.afterSendLoc {
    public final static int SServiceID = 12397;
    private Context CTx;
    String empCode;

    private static LocationManager locationManager;
    private static MyLocationListener listener;
    private Location previousBestLocation;
    private InotifySskey noti;

    @Override
    public boolean requestMyLoc() {
        return requestLocation();
    }

    @Override
    public void repeatMyLoc() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CTx = this;
        empCode = WakeServiceSSk.empCode;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        listener = new MyLocationListener(CTx, this);
        noti = new SSkeyNotify(this);
        requestMyLoc();
        WakeServiceSSk.cancelAlarrm(this);

        BroadcastReceiver serviceReceiver = new BootEventReceiver();
        IntentFilter broadfilter = new IntentFilter(WakeServiceSSk.MYBOOT_ACTION);
        CTx.registerReceiver(serviceReceiver, broadfilter);
    }

    @Override
    public void setLooping() {
        setLoops();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        noti.setUpBlk();
        startForeground(noti.getNotifyID(), noti.getNotification());
        repeatMyLoc();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    /**
     * Checks whether two providers are the same
     */

    @Override
    public void onDestroy() {
        Log.e("<<thanhserver", "destroy");
        setLooping();
    }

    @Override
    public void cancelNow() {
        stopSelf();
    }

    private void setLoops() {
        Intent it = new Intent(CTx, TestService.class);
        PendingIntent peservcie = PendingIntent.getService(CTx, SServiceID, it, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alm = (AlarmManager) CTx.getSystemService(Context.ALARM_SERVICE);
        alm.cancel(peservcie);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            alm.setAlarmClock(new AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 90000, peservcie), peservcie);
        alm.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 90000, peservcie);

    }


    private boolean requestLocation() {
        if (ActivityCompat.checkSelfPermission(CTx, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(CTx, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.e("<<RetrieGPS", "no permission");

        } else {
            Log.e("<<RetrieGPS", "start request" + android.os.Process.myUid());
            locationManager.removeUpdates(listener);
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MyLocationListener.PER_TIME, MyLocationListener.MIN_DISTANCE, (LocationListener) listener);
            else
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MyLocationListener.PER_TIME, MyLocationListener.MIN_DISTANCE, listener);
            return true;
        }
        return false;
    }
}
