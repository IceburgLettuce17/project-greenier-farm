package com.gameloft.android2d.iap.p042a.p049f;

import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0405a extends AbstractC0358a {
    long abY = 0;
    long abZ = 25000;
    private boolean aca = false;

    public C0405a() {
        this.f2744Zq = "http_2d";
    }

    @Override
    public final void mo2253bp(String str) {
        C0012k.m41c("IAP-HTTPBilling", "HTTPBilling an item");
        String str2 = this.profileId;
        String str3 = this.f2750Zw;
        String str4 = this.f2751Zx;
        String m2530qC = C0463b.m2530qC();
        String m2529qB = C0463b.m2529qB();
        String m2531qD = C0463b.m2531qD();
        String str5 = C0463b.m2528qA().aeU;
        String str6 = this.url;
        C0012k.m41c("IAP-HTTPBilling", "URL:             " + str6);
        C0012k.m41c("IAP-HTTPBilling", "ContentID:       " + str);
        C0012k.m41c("IAP-HTTPBilling", "ProfileID:       " + str2);
        C0012k.m41c("IAP-HTTPBilling", "Proxy Server:    " + str3);
        C0012k.m41c("IAP-HTTPBilling", "Proxy Port:      " + str4);
        C0012k.m41c("IAP-HTTPBilling", "Demo Code:       " + m2530qC);
        C0012k.m41c("IAP-HTTPBilling", "Download Code:   " + m2531qD);
        C0012k.m41c("IAP-HTTPBilling", "Unlock Code:     " + m2529qB);
        if (!m2229bq(str6) || !m2229bq(str2) || !m2229bq(m2530qC) || !m2229bq(m2529qB)) {
            C0012k.m40b("IAP-HTTPBilling", "IAP_INVALID_REQUEST (-5)");
            C0463b.setResult(-5);
        } else if (m2229bq(str)) {
            C0463b.setResult(1);
            new C0406b(this, str3, str4, str6, str, str2, m2530qC, m2529qB, m2531qD, str5).start();
        } else {
            C0012k.m40b("IAP-HTTPBilling", "IAP_ERROR_ITEM_NOT_AVAILABLE (-2)");
            C0463b.setResult(-2);
        }
    }
}
