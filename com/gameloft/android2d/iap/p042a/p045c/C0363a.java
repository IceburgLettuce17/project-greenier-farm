package com.gameloft.android2d.iap.p042a.p045c;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.AbstractC0358a;
import com.gameloft.android2d.iap.p042a.p047e.C0375af;
import com.gameloft.android2d.iap.p042a.p047e.ServiceC0367a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

public final class C0363a extends AbstractC0358a {
    private C0364b aac;
    private ServiceC0367a aad;
    private Handler mHandler;

    public C0363a() {
        this.f2744Zq = "blackberry";
    }

    @Override
    public final void mo2253bp(String str) {
        try {
            C0463b.m2559rd();
        } catch (Exception e) {
            C0012k.m41c("IAP-BlackBerryBilling", "Bill Exception : " + e.getMessage());
        }
        if (C0463b.f2819Zi == 1) {
            C0463b.setResult(3);
            return;
        }
        C0012k.m41c("IAP-BlackBerryBilling", "BlackBerryBilling an item:" + this.f2740ZP);
        Activity activity = (Activity) C0488o.getContext();
        try {
            Looper.prepare();
            this.mHandler = new Handler();
        } catch (Exception e2) {
            C0012k.m41c("IAP-BlackBerryBilling", "Bill Exception : " + e2.getMessage());
        }
        this.aac = new C0364b(this, this.mHandler);
        this.aad = new ServiceC0367a();
        this.aad.setContext(activity);
        C0375af.m2309a(this.aac);
        if (!this.aad.m2300rK()) {
            C0463b.setResult(3);
        } else if (!this.aad.m2298bY("subs")) {
            C0463b.setResult(3);
        } else {
            this.aad.m2299f(this.f2740ZP, "inapp", "");
            C0463b.setResult(1);
        }
    }

    @Override
    public final boolean mo2269rG() {
        C0012k.m41c("IAP-BlackBerryBilling", "[ isPendingTransaction] ");
        try {
            String m2395si = C0414f.m2395si();
            String m2396sj = C0414f.m2396sj();
            C0012k.m41c("IAP-BlackBerryBilling", "mSavedNotify: " + m2395si + " Pending State: " + m2396sj);
            if (m2395si == null || m2396sj == null) {
                C0414f.m2377cm("");
                C0414f.m2379cn("");
                return false;
            }
            C0012k.m41c("IAP-BlackBerryBilling", "Restore last purchase state: " + m2396sj);
            C0463b.setResult(C0488o.m2641ap(m2396sj));
            return true;
        } catch (Exception e) {
            C0012k.m41c("IAP-BlackBerryBilling", "Exception in CheckPendingTransaction: " + e);
            C0414f.m2377cm("");
            C0414f.m2379cn("");
            return false;
        }
    }
}
