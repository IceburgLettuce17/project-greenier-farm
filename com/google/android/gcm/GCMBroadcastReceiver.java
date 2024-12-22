package com.google.android.gcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class GCMBroadcastReceiver extends BroadcastReceiver {
    private static boolean ahq = false;

    @Override
    public final void onReceive(Context context, Intent intent) {
        String str = "onReceive: " + intent.getAction();
        if (!ahq) {
            ahq = true;
            String name = getClass().getName();
            if (!name.equals(GCMBroadcastReceiver.class.getName())) {
                GCMRegistrar.m2801db(name);
            }
        }
        String str2 = context.getPackageName() + ".GCMIntentService";
        String str3 = "GCM IntentService class: " + str2;
        GCMBaseIntentService.m2795a(context, intent, str2);
        setResult(-1, null, null);
    }
}
