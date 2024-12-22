package com.gameloft.android2d.iap.p042a.p047e;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import p001a.p004b.p005a.p006a.C0012k;

public class C0399u {
    final C0388j abm;

    C0399u(C0388j c0388j) {
        this.abm = c0388j;
    }

    public void m2354a(C0370aa c0370aa, C0403y c0403y) {
        C0012k.m41c("IAP-GoogleBilling", "Consumption finished. Purchase: " + c0370aa + ", result: " + c0403y);
        if (c0403y.m2358rX()) {
            C0012k.m41c("IAP-GoogleBilling", "Consumption successful. Provisioning.");
            C0388j c0388j = this.abm;
            C0388j.m2334f(c0370aa.abt, true);
            C0414f.m2380co(c0370aa.abs);
            C0414f.m2377cm(c0370aa.abv);
            C0012k.m41c("IAP-GoogleBilling", "Saved OrderId for Google Billing Version 3: " + c0370aa.abs);
            C0012k.m41c("IAP-GoogleBilling", "Saved NotifyID for Google Billing Version 3: " + c0370aa.abu);
            new Thread(new RunnableC0389k(this)).start();
        } else {
            C0012k.m41c("IAP-GoogleBilling", "Error while consuming: " + c0403y);
            C0463b.setResult(3);
        }
        C0012k.m41c("IAP-GoogleBilling", "End consumption flow.");
    }
}
