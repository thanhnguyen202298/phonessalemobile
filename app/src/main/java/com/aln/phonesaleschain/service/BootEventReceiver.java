package com.aln.phonesaleschain.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootEventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent goToService = new Intent(context,TestService.class);
        context.startService(goToService);
    }
}
