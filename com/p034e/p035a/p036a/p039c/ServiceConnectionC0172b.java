package com.p034e.p035a.p036a.p039c;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.p029d.p030a.AbstractBinderC0153b;
import com.p029d.p030a.InterfaceC0152a;
import com.p034e.p035a.p036a.C0162b;

final class ServiceConnectionC0172b implements ServiceConnection {
    private C0171a aih;

    ServiceConnectionC0172b(C0171a c0171a) {
        this.aih = c0171a;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Activity activity;
        boolean m311a;
        C0162b c0162b;
        Activity activity2;
        InterfaceC0152a m281e = AbstractBinderC0153b.m281e(iBinder);
        try {
            C0171a.aid = m281e.getPackageName();
            C0171a.aie = m281e.mo280tI();
            C0171a c0171a = this.aih;
            activity = this.aih.aif;
            m311a = c0171a.m311a(activity, C0162b.m297tJ(), C0162b.m299tL(), C0171a.m315d(this.aih));
            if (m311a) {
                return;
            }
            c0162b = this.aih.aig;
            activity2 = this.aih.aif;
            c0162b.m300a(activity2, C0171a.m314c(this.aih), 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        C0162b c0162b;
        Activity activity;
        c0162b = this.aih.aig;
        activity = this.aih.aif;
        c0162b.m300a(activity, C0171a.m314c(this.aih), 0);
    }
}
