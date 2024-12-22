package com.gameloft.android2d.iap.p042a.p047e;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.p023b.p024a.p025a.AbstractBinderC0141b;

final class ServiceConnectionC0393o implements ServiceConnection {
    private C0401w aaY;
    private C0392n aaZ;

    ServiceConnectionC0393o(C0392n c0392n, C0401w c0401w) {
        this.aaZ = c0392n;
        this.aaY = c0401w;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.aaZ.m2351cd("Billing service connected.");
        if (C0388j.m2335rS()) {
            return;
        }
        this.aaZ.aaS = AbstractBinderC0141b.m269a(iBinder);
        String packageName = this.aaZ.mContext.getPackageName();
        try {
            this.aaZ.m2351cd("Checking for in-app billing 3 support.");
            int mo264a = this.aaZ.aaS.mo264a(3, packageName, "inapp");
            if (mo264a != 0) {
                if (this.aaY != null) {
                    this.aaY.m2356a(new C0403y(mo264a, "Error checking for billing v3 support."));
                }
                this.aaZ.aaP = false;
                return;
            }
            this.aaZ.m2351cd("In-app billing version 3 supported for " + packageName);
            int mo264a2 = this.aaZ.aaS.mo264a(3, packageName, "subs");
            if (mo264a2 == 0) {
                this.aaZ.m2351cd("Subscriptions AVAILABLE.");
                this.aaZ.aaP = true;
            } else {
                this.aaZ.m2351cd("Subscriptions NOT AVAILABLE. Response: " + mo264a2);
            }
            this.aaZ.aaO = true;
            if (this.aaY != null) {
                this.aaY.m2356a(new C0403y(0, "Setup successful."));
            }
        } catch (RemoteException e) {
            if (this.aaY != null) {
                this.aaY.m2356a(new C0403y(-1001, "RemoteException while setting up in-app billing."));
            }
            e.printStackTrace();
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        this.aaZ.m2351cd("Billing service disconnected.");
        this.aaZ.aaS = null;
    }
}
