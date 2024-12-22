package com.gameloft.android2d.iap.p042a.p051h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.p026c.p027a.p028a.AbstractBinderC0147b;
import com.p026c.p027a.p028a.InterfaceC0146a;
import p001a.p004b.p005a.p006a.C0012k;

final class ServiceConnectionC0416h implements ServiceConnection {
    private C0414f acC;
    private InterfaceC0421m acD;

    ServiceConnectionC0416h(C0414f c0414f, InterfaceC0421m interfaceC0421m) {
        this.acC = c0414f;
        this.acD = interfaceC0421m;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        InterfaceC0146a interfaceC0146a;
        this.acC.acy = AbstractBinderC0147b.m277c(iBinder);
        interfaceC0146a = this.acC.acy;
        if (interfaceC0146a == null || this.acD == null) {
            this.acC.acz = false;
            this.acD.mo2406fb(2);
        } else {
            this.acC.acz = true;
            this.acD.mo2406fb(0);
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        C0012k.m39a("SamsungIAB", "IAP Service Disconnected...");
        this.acC.acy = null;
    }
}
