package com.gameloft.android2d.iap.p042a.p047e;

import android.os.Bundle;
import com.p023b.p024a.p025a.InterfaceC0143d;

final class C0382d extends AbstractC0380b {
    private String[] aam;

    public C0382d(ServiceC0367a serviceC0367a, int i, String[] strArr) {
        super(serviceC0367a, i);
        this.aam = strArr;
    }

    @Override
    protected final long mo2327rR() {
        InterfaceC0143d interfaceC0143d;
        Bundle bZ = m2323bZ("CONFIRM_NOTIFICATIONS");
        bZ.putStringArray("NOTIFY_IDS", this.aam);
        interfaceC0143d = ServiceC0367a.aaf;
        Bundle mo270a = interfaceC0143d.mo270a(bZ);
        m2320a("confirmNotifications", mo270a);
        return mo270a.getLong("REQUEST_ID", C0385g.aaq);
    }
}
