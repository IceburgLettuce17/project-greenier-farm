package com.gameloft.android2d.iap.p042a.p047e;

import android.os.Bundle;
import android.os.RemoteException;
import com.p023b.p024a.p025a.InterfaceC0143d;
import java.util.HashMap;
import java.util.LinkedList;
import p001a.p004b.p005a.p006a.C0012k;

abstract class AbstractC0380b {
    private final int aai;
    private long aaj;
    private ServiceC0367a aak;

    public AbstractC0380b(ServiceC0367a serviceC0367a, int i) {
        this.aak = serviceC0367a;
        this.aai = i;
    }

    protected static void m2320a(String str, Bundle bundle) {
        C0012k.m40b("IAP-BillingService", str + " received " + EnumC0387i.m2329eX(bundle.getInt("RESPONSE_CODE")).toString());
    }

    protected void mo2321a(RemoteException remoteException) {
        C0012k.m42d("IAP-BillingService", "remote billing service crashed");
        ServiceC0367a.m2290a((InterfaceC0143d) null);
    }

    protected void mo2322b(EnumC0387i enumC0387i) {
    }

    protected final Bundle m2323bZ(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("BILLING_REQUEST", str);
        if (System.getProperty("os.name").equals("qnx")) {
            C0012k.m41c("IAP-BillingService", "makeRequestBundle - Blackberry billing - API version 1");
            bundle.putInt("API_VERSION", 1);
        } else {
            C0012k.m41c("IAP-BillingService", "makeRequestBundle - Google billing - API version 2");
            bundle.putInt("API_VERSION", 2);
        }
        bundle.putString("PACKAGE_NAME", this.aak.getPackageName());
        return bundle;
    }

    public int mo2324rO() {
        return this.aai;
    }

    public boolean mo2325rP() {
        boolean m2294rJ;
        LinkedList linkedList;
        if (mo2326rQ()) {
            return true;
        }
        m2294rJ = this.aak.m2294rJ();
        if (!m2294rJ) {
            return false;
        }
        linkedList = ServiceC0367a.aag;
        linkedList.add(this);
        return true;
    }

    public boolean mo2326rQ() {
        InterfaceC0143d interfaceC0143d;
        HashMap hashMap;
        C0012k.m39a("IAP-BillingService", getClass().getSimpleName());
        interfaceC0143d = ServiceC0367a.aaf;
        if (interfaceC0143d != null) {
            try {
                this.aaj = mo2327rR();
                C0012k.m39a("IAP-BillingService", "request id: " + this.aaj);
                if (this.aaj >= 0) {
                    hashMap = ServiceC0367a.aah;
                    hashMap.put(Long.valueOf(this.aaj), this);
                }
                return true;
            } catch (RemoteException e) {
                mo2321a(e);
            }
        }
        return false;
    }

    protected abstract long mo2327rR();
}
