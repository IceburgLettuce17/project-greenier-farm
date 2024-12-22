package com.gameloft.android2d.iap.p042a.p051h;

import p001a.p004b.p005a.p006a.C0012k;

final class C0413e extends Thread {
    C0413e() {
    }

    @Override
    public final void run() {
        C0012k.m41c("IAP-SamsungBilling", "Verification: new thread started");
        try {
            C0412d.acx.mo2267rE();
        } catch (Exception e) {
            C0012k.m41c("IAP-SamsungBilling", "Verification - Exception: " + e);
        }
    }
}
