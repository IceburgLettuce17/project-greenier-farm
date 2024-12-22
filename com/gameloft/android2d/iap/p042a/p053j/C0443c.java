package com.gameloft.android2d.iap.p042a.p053j;

import android.content.Context;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0488o;
import java.util.Timer;
import java.util.TimerTask;
import p001a.p004b.p005a.p006a.C0012k;

final class C0443c extends TimerTask {

    private static Timer f2776dZ;

    C0443c() {
    }

    public static void m2456a(long j) {
        C0012k.m41c("IAP-SMSBilling", "Timer Waiting Response Start");
        Timer timer = new Timer();
        f2776dZ = timer;
        timer.schedule(new C0443c(), 30000L);
    }

    public static void stop() {
        C0012k.m41c("IAP-SMSBilling", "Timer Waiting Response Stop");
        f2776dZ.cancel();
    }

    @Override
    public final void run() {
        C0445e c0445e;
        C0012k.m41c("IAP-SMSBilling", "Timer Waiting Response Run (Reached time)");
        try {
            Context context = C0488o.getContext();
            c0445e = C0441a.adv;
            context.unregisterReceiver(c0445e);
            C0012k.m41c("IAP-SMSBilling", "AwaitResponseTimer:SMSResponseReceiver Unregistered");
        } catch (Exception e) {
            e.printStackTrace();
        }
        C0463b.setResult(2);
    }
}
