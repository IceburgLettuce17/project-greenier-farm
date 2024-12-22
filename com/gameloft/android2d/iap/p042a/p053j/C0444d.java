package com.gameloft.android2d.iap.p042a.p053j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

final class C0444d extends BroadcastReceiver {
    C0444d(C0441a c0441a) {
    }

    @Override
    public final void onReceive(Context context, Intent intent) {
        C0445e c0445e;
        switch (getResultCode()) {
            case -1:
                C0012k.m41c("IAP-SMSBilling", "SMS Sent Pending Intent: RESULT OK");
                C0463b.m2502ae(true);
                C0463b.setResult(12);
                Context context2 = C0488o.getContext();
                c0445e = C0441a.adv;
                context2.registerReceiver(c0445e, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
                C0443c.m2456a(30000L);
                C0414f.m2398sl();
                C0414f.m2387r(InterfaceC0357a.f2724wS[0], "1");
                C0414f.m2387r(InterfaceC0357a.f2724wS[1], C0463b.m2529qB());
                C0414f.m2387r(InterfaceC0357a.f2724wS[2], String.valueOf(C0463b.m2547qT()));
                C0414f.m2387r(InterfaceC0357a.f2724wS[6], C0463b.m2549qV());
                break;
            default:
                C0012k.m40b("IAP-SMSBilling", "SMS Sent Pending Intent: ERROR " + getResultCode());
                C0463b.m2502ae(false);
                C0463b.setResult(3);
                C0463b.m2521eV(-1);
                C0414f.m2387r(InterfaceC0357a.f2724wS[0], "0");
                break;
        }
        C0488o.getContext().unregisterReceiver(this);
    }
}
