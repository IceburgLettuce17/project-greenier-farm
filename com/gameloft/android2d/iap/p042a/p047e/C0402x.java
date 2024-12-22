package com.gameloft.android2d.iap.p042a.p047e;

import android.app.Activity;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.utils.C0488o;
import java.util.ArrayList;
import p001a.p004b.p005a.p006a.C0012k;

public class C0402x {
    final C0388j abm;

    C0402x(C0388j c0388j) {
        this.abm = c0388j;
    }

    public void m2357a(C0403y c0403y, C0404z c0404z) {
        C0392n c0392n;
        String str;
        String str2;
        String str3;
        C0392n c0392n2;
        int i = 0;
        C0012k.m41c("IAP-GoogleBilling", "Query inventory finished.");
        if (c0403y.isFailure()) {
            C0012k.m41c("IAP-GoogleBilling", "Failed to query inventory: " + c0403y);
            if (c0403y.abn != 9) {
                C0463b.setResult(3);
                return;
            } else {
                boolean unused = C0388j.aaG = false;
                this.abm.m2338rT();
                return;
            }
        }
        C0012k.m41c("IAP-GoogleBilling", "Query inventory was successful.");
        ArrayList arrayList = new ArrayList(c0404z.abq.keySet());
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                C0012k.m41c("IAP-GoogleBilling", "Initial inventory query finished.");
                if (C0463b.f2806YX) {
                    return;
                }
                C0012k.m41c("IAP-GoogleBilling", "Launching purchase flow for item.");
                c0392n = C0388j.aaE;
                Activity activity = (Activity) C0488o.getContext();
                str = this.abm.aaF;
                c0392n.m2347a(activity, str, "inapp", 10001, this.abm.aaI, "");
                return;
            }
            str2 = (String) arrayList.get(i2);
            if (str2 != null && !str2.equals("")) {
                C0012k.m41c("IAP-GoogleBilling", "Item already owned: " + str2);
                str3 = this.abm.aaF;
                if (str2.equals(str3)) {
                    break;
                }
                C0388j c0388j = this.abm;
                if (C0388j.m2333ca(str2)) {
                    break;
                }
            }
            i = i2 + 1;
        }
        C0012k.m41c("IAP-GoogleBilling", "Item already owned. Consuming: " + str2);
        c0392n2 = C0388j.aaE;
        c0392n2.m2348a(c0404z.abq.get(str2), this.abm.aaJ);
    }
}
