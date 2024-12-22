package com.gameloft.android2d.iap.p042a.p047e;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import p001a.p004b.p005a.p006a.C0012k;

public class C0400v {
    final C0388j abm;

    C0400v(C0388j c0388j) {
        this.abm = c0388j;
    }

    public void m2355a(C0403y c0403y, C0370aa c0370aa, int i) {
        C0392n c0392n;
        String str;
        String str2;
        C0012k.m41c("IAP-GoogleBilling", "Purchase finished: " + c0403y + ", purchase: " + c0370aa + ", responseCode: " + i);
        if (i != 7) {
            C0012k.m41c("IAP-GoogleBilling", "Charged money.........");
            C0388j c0388j = this.abm;
            str = this.abm.aaF;
            C0388j.m2334f(str, false);
            C0388j c0388j2 = this.abm;
            str2 = this.abm.aaF;
            c0388j2.m2337a(str2, String.valueOf(C0414f.m2372cF()), C0414f.m2392sf());
        }
        if (!c0403y.isFailure()) {
            C0012k.m41c("IAP-GoogleBilling", "Purchase successful.");
            C0012k.m41c("IAP-GoogleBilling", "Purchase is item. Starting item consumption.");
            c0392n = C0388j.aaE;
            c0392n.m2348a(c0370aa, this.abm.aaJ);
            return;
        }
        if (i == 1) {
            C0012k.m41c("IAP-GoogleBilling", "Purchase Cancel by user...");
            C0463b.setResult(10);
        } else {
            C0012k.m41c("IAP-GoogleBilling", "Error purchasing: " + c0403y);
            C0463b.setResult(3);
        }
    }
}
