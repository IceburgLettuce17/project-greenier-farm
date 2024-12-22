package com.gameloft.android2d.iap.p042a.p047e;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import com.p023b.p024a.p025a.InterfaceC0143d;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0384f extends AbstractC0380b {
    private ServiceC0367a aak;
    private String aal;
    private String aao;
    private String aap;

    public C0384f(ServiceC0367a serviceC0367a, String str, String str2, String str3) {
        super(serviceC0367a, -1);
        this.aak = serviceC0367a;
        this.aao = str;
        this.aap = str3;
        this.aal = str2;
    }

    @Override
    protected final void mo2322b(EnumC0387i enumC0387i) {
        ServiceC0367a serviceC0367a = this.aak;
        C0375af.m2310a(this, enumC0387i);
    }

    @Override
    public final int mo2324rO() {
        return super.mo2324rO();
    }

    @Override
    public final boolean mo2325rP() {
        return super.mo2325rP();
    }

    @Override
    public final boolean mo2326rQ() {
        return super.mo2326rQ();
    }

    @Override
    protected final long mo2327rR() {
        InterfaceC0143d interfaceC0143d;
        Bundle bZ = m2323bZ("REQUEST_PURCHASE");
        bZ.putString("ITEM_ID", this.aao);
        bZ.putString("ITEM_TYPE", this.aal);
        if (this.aap != null) {
            bZ.putString("DEVELOPER_PAYLOAD", this.aap);
        }
        interfaceC0143d = ServiceC0367a.aaf;
        Bundle mo270a = interfaceC0143d.mo270a(bZ);
        PendingIntent pendingIntent = (PendingIntent) mo270a.getParcelable("PURCHASE_INTENT");
        if (pendingIntent == null) {
            C0012k.m40b("IAP-BillingService", "Error with requestPurchase");
            return C0385g.aaq;
        }
        C0375af.m2311b(pendingIntent, new Intent());
        return mo270a.getLong("REQUEST_ID", C0385g.aaq);
    }
}
