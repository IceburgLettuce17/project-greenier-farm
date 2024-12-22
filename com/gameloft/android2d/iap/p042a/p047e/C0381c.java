package com.gameloft.android2d.iap.p042a.p047e;

import android.os.Bundle;
import com.p023b.p024a.p025a.InterfaceC0143d;
import p001a.p004b.p005a.p006a.C0012k;

final class C0381c extends AbstractC0380b {
    private String aal;

    @Deprecated
    public C0381c(ServiceC0367a serviceC0367a) {
        super(serviceC0367a, -1);
        this.aal = null;
    }

    public C0381c(ServiceC0367a serviceC0367a, String str) {
        super(serviceC0367a, -1);
        this.aal = null;
        this.aal = str;
    }

    @Override
    protected final long mo2327rR() {
        InterfaceC0143d interfaceC0143d;
        Bundle bZ = m2323bZ("CHECK_BILLING_SUPPORTED");
        if (this.aal != null) {
            bZ.putString("ITEM_TYPE", this.aal);
        }
        interfaceC0143d = ServiceC0367a.aaf;
        int i = interfaceC0143d.mo270a(bZ).getInt("RESPONSE_CODE");
        C0012k.m41c("IAP-BillingService", "CheckBillingSupported response code: " + EnumC0387i.m2329eX(i));
        C0375af.m2312b(i == EnumC0387i.RESULT_OK.ordinal(), this.aal);
        return C0385g.aaq;
    }
}
