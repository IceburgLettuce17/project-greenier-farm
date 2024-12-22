package com.gameloft.android2d.iap.p042a.p047e;

import android.os.Bundle;
import android.os.RemoteException;
import com.p023b.p024a.p025a.InterfaceC0143d;

final class C0383e extends AbstractC0380b {
    private String[] aam;
    private long aan;

    public C0383e(ServiceC0367a serviceC0367a, int i, String[] strArr) {
        super(serviceC0367a, i);
        this.aam = strArr;
    }

    @Override
    protected final void mo2321a(RemoteException remoteException) {
        super.mo2321a(remoteException);
        C0377ah.m2318i(this.aan);
    }

    @Override
    protected final long mo2327rR() {
        InterfaceC0143d interfaceC0143d;
        this.aan = C0377ah.m2319rZ();
        Bundle bZ = m2323bZ("GET_PURCHASE_INFORMATION");
        bZ.putLong("NONCE", this.aan);
        bZ.putStringArray("NOTIFY_IDS", this.aam);
        interfaceC0143d = ServiceC0367a.aaf;
        Bundle mo270a = interfaceC0143d.mo270a(bZ);
        m2320a("getPurchaseInformation", mo270a);
        return mo270a.getLong("REQUEST_ID", C0385g.aaq);
    }
}
