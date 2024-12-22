package com.gameloft.android2d.iap.p042a.p054k;

import java.util.Timer;
import java.util.TimerTask;
import p001a.p004b.p005a.p006a.C0012k;

final class C0456k extends TimerTask {
    private static C0446a adI;
    private static int adt;

    private static Timer f2784dZ;

    C0456k() {
    }

    public static void m2489a(long j, int i, C0446a c0446a) {
        C0012k.m41c("IAP-UMPBilling", "Timer Waiting Billing Response Start");
        adt = i;
        adI = c0446a;
        Timer timer = new Timer();
        f2784dZ = timer;
        timer.schedule(new C0456k(), 5L);
    }

    @Override
    public final void run() {
        C0012k.m41c("IAP-UMPBilling", "Timer Waiting Billing Response Run (Reached time)");
        adI.m2488fc(adt);
    }
}
