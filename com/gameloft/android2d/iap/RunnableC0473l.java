package com.gameloft.android2d.iap;

import android.os.SystemClock;
import com.gameloft.android2d.iap.utils.C0477d;
import com.gameloft.android2d.iap.utils.C0488o;
import com.gameloft.android2d.iap.utils.C0489p;
import p001a.p004b.p005a.p006a.C0012k;

final class RunnableC0473l implements Runnable {

    private C0463b f2850Zp;

    private RunnableC0473l(C0463b c0463b) {
        this.f2850Zp = c0463b;
    }

    RunnableC0473l(C0463b c0463b, byte b2) {
        this(c0463b);
    }

    @Override
    public final void run() {
        C0489p c0489p;
        String str;
        String str2;
        C0489p c0489p2;
        long j;
        try {
            if (!C0477d.m2593qg() && !C0463b.f2811Za) {
                C0012k.m39a("IAP-IAPLib", "Device have no connection, please turn on WIFI or 3G...");
                try {
                    Thread.sleep(3000L);
                } catch (Exception e) {
                }
                C0463b.setResult(11);
                C0463b.m2521eV(-6);
                return;
            }
            if (C0463b.f2792YJ.equals("USE_IAP_GOOGLE_BILLING") || C0463b.f2792YJ.equals("USE_IAP_BLACKBERRY_BILLING") || C0463b.f2792YJ.equals("USE_IAP_AMAZON_BILLING")) {
                C0463b.m2560re();
            }
            long unused = C0463b.f2798YP = SystemClock.elapsedRealtime();
            c0489p = this.f2850Zp.f2827Yn;
            str = this.f2850Zp.f2833Yu;
            if (!c0489p.m2658cM(str)) {
                StringBuilder sb = new StringBuilder("getUpdateProfileInfo false, customFeedURL =");
                str2 = this.f2850Zp.f2833Yu;
                C0012k.m39a("IAP-IAPLib", sb.append(str2).toString());
                C0463b.setResult(11);
                C0463b.m2521eV(-6);
                return;
            }
            c0489p2 = this.f2850Zp.f2827Yn;
            if (c0489p2.aeI.aeK.isEmpty()) {
                C0012k.m39a("IAP-IAPLib", "item list is empty");
                C0463b.setResult(11);
                C0463b.m2521eV(-7);
                return;
            }
            long unused2 = C0463b.f2797YO = C0488o.m2635H(C0463b.m2553qZ(), C0463b.m2556ra());
            StringBuilder sb2 = new StringBuilder("Count Down time: ");
            j = C0463b.f2797YO;
            C0012k.m39a("IAP-IAPLib", sb2.append(j).toString());
            C0463b.m2497a(this.f2850Zp, true);
            C0463b.f2795YM = true;
            C0463b.setResult(10);
            C0463b.m2521eV(0);
            if (C0463b.m2512cj()) {
                C0012k.m39a("IAP-IAPLib", "SMS sent switch to redeem screen");
                C0463b.setResult(2);
            }
            C0463b.m2519do();
        } catch (Exception e2) {
            C0463b.setResult(11);
            C0463b.m2521eV(-6);
            C0012k.m39a("IAP-IAPLib", "Exception when retrieve feed: " + e2.getMessage());
            e2.printStackTrace();
        }
    }
}
