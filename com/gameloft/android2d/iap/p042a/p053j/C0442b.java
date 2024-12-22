package com.gameloft.android2d.iap.p042a.p053j;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

final class C0442b extends Thread {
    private C0441a adw;

    C0442b(C0441a c0441a) {
        this.adw = c0441a;
    }

    @Override
    public final void run() {
        String rp;
        boolean bq;
        String str;
        C0012k.m41c("IAP-SMSBilling", "buy: new thread started");
        try {
            rp = this.adw.m2274rp();
            C0441a c0441a = this.adw;
            bq = C0441a.m2229bq(rp);
        } catch (Throwable th) {
            C0463b.m2502ae(false);
            C0414f.m2387r(InterfaceC0357a.f2724wS[0], "0");
            C0463b.setResult(3);
            C0463b.m2521eV(-1);
            C0012k.m41c("IAP-SMSBilling", "buy: SMS sent failed! Exception: " + th.toString());
        }
        if (!bq) {
            C0012k.m40b("IAP-SMSBilling", "IAP_INVALID_REQUEST (-5): Invalid Server Number");
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            return;
        }
        C0012k.m41c("IAP-SMSBilling", "buy: sms address: " + rp);
        PendingIntent broadcast = PendingIntent.getBroadcast(C0488o.getContext(), 0, new Intent("SMS_SENT"), 0);
        C0488o.getContext().registerReceiver(new C0444d(this.adw), new IntentFilter("SMS_SENT"));
        SmsManager smsManager = SmsManager.getDefault();
        str = this.adw.f2775wM;
        smsManager.sendTextMessage(rp, null, str, broadcast, null);
        C0012k.m41c("IAP-SMSBilling", "buy: sendTextMessage done!");
        C0463b.m2500ad(false);
        C0012k.m41c("IAP-SMSBilling", "buy: SMS Thread ended!");
    }
}
