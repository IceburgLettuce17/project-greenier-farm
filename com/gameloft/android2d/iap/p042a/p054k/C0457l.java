package com.gameloft.android2d.iap.p042a.p054k;

import android.content.Context;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0488o;
import java.util.Timer;
import java.util.TimerTask;
import p001a.p004b.p005a.p006a.C0012k;

final class C0457l extends TimerTask {
    public static void stop() {
        C0012k.m41c("IAP-UMPBilling", "Timer Waiting Response Stop");
        Timer timer = null;
        timer.cancel();
    }

    @Override
    public final void run() {
        C0460o c0460o;
        C0012k.m41c("IAP-UMPBilling", "Timer Waiting Response Run (Reached time)");
        try {
            Context context = C0488o.getContext();
            c0460o = C0446a.adE;
            context.unregisterReceiver(c0460o);
            C0012k.m41c("IAP-UMPBilling", "AwaitResponseTimer:SMSResponseReceiver Unregistered");
        } catch (Exception e) {
            e.printStackTrace();
        }
        C0463b.setResult(2);
    }
}
