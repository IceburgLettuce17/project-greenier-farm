package com.gameloft.android2d.iap.p042a.p045c;

import android.app.Activity;
import android.os.Handler;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.p042a.p047e.AbstractC0373ad;
import com.gameloft.android2d.iap.p042a.p047e.EnumC0386h;
import com.gameloft.android2d.iap.p042a.p047e.EnumC0387i;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

final class C0364b extends AbstractC0373ad {
    public C0364b(C0363a c0363a, Handler handler) {
        super((Activity) C0488o.getContext(), handler);
    }

    @Override
    public final void mo2287a(EnumC0386h enumC0386h, String str) {
        C0012k.m41c("IAP-BlackBerryBilling", "onPurchaseStateChange: " + enumC0386h + " - itemId: " + str);
        if (C0463b.f2819Zi == 1) {
            C0463b.setResult(3);
            C0463b.m2558rc();
        }
    }

    @Override
    public final void mo2288a(EnumC0387i enumC0387i) {
        try {
            C0463b.m2559rd();
        } catch (Exception e) {
            C0012k.m41c("IAP-BlackBerryBilling", "Bill Exception : " + e.getMessage());
        }
        if (C0463b.f2819Zi == 1) {
            C0463b.setResult(3);
            return;
        }
        C0012k.m41c("IAP-BlackBerryBilling", "onRequestPurchaseResponse");
        if (enumC0387i == EnumC0387i.RESULT_OK) {
            C0463b.setResult(7);
            C0463b.m2552qY();
            C0414f.m2379cn(new StringBuilder().append(C0463b.m2554qz()).toString());
        } else if (enumC0387i != EnumC0387i.RESULT_USER_CANCELED) {
            C0463b.setResult(3);
        } else {
            C0463b.setResult(10);
            C0463b.m2558rc();
        }
    }

    @Override
    public final void mo2289rI() {
    }
}
