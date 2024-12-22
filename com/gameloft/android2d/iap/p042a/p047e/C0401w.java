package com.gameloft.android2d.iap.p042a.p047e;

import com.gameloft.android2d.iap.C0463b;
import p001a.p004b.p005a.p006a.C0012k;

public class C0401w {
    final C0388j abm;

    C0401w(C0388j c0388j) {
        this.abm = c0388j;
    }

    public void m2356a(C0403y c0403y) {
        C0392n c0392n;
        C0012k.m41c("IAP-GoogleBilling", "Setup finished.");
        if (!c0403y.m2358rX()) {
            C0012k.m41c("IAP-GoogleBilling", "Problem setting up in-app billing: " + c0403y);
            C0463b.setResult(3);
        } else {
            boolean unused = C0388j.aaG = true;
            C0012k.m41c("IAP-GoogleBilling", "Setup successful. Querying inventory.");
            c0392n = C0388j.aaE;
            c0392n.m2349a(this.abm.aaH);
        }
    }
}
