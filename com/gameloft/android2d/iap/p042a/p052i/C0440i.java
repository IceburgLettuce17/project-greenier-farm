package com.gameloft.android2d.iap.p042a.p052i;

import java.util.Timer;
import java.util.TimerTask;
import p001a.p004b.p005a.p006a.C0012k;

final class C0440i extends TimerTask {
    private static int adt;
    private static C0432a adu;

    private static Timer f2774dZ;

    C0440i() {
    }

    public static void m2448a(long j, int i, C0432a c0432a) {
        C0012k.m41c("IAP-ShenzhoufuBilling", "Timer Waiting Billing Response Start");
        adt = i;
        adu = c0432a;
        Timer timer = new Timer();
        f2774dZ = timer;
        timer.schedule(new C0440i(), 5L);
    }

    @Override
    public final void run() {
        C0012k.m41c("IAP-ShenzhoufuBilling", "Timer Waiting Billing Response Run (Reached time)");
        adu.m2447fc(adt);
    }
}
