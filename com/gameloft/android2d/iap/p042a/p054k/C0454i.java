package com.gameloft.android2d.iap.p042a.p054k;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import com.gameloft.android2d.iap.C0463b;
import com.gameloft.android2d.iap.InterfaceC0357a;
import com.gameloft.android2d.iap.p042a.p051h.C0414f;
import com.gameloft.android2d.iap.utils.C0488o;
import p001a.p004b.p005a.p006a.C0012k;

final class C0454i extends Thread {
    private C0446a adF;

    C0454i(C0446a c0446a) {
        this.adF = c0446a;
    }

    @Override
    public final void run() {
        String str;
        boolean bq;
        String str2;
        String str3;
        String str4;
        C0012k.m41c("IAP-UMPBilling", "sendMO2: new thread started");
        try {
            C0446a c0446a = this.adF;
            str = this.adF.adz;
            bq = C0446a.m2229bq(str);
        } catch (Throwable th) {
            C0463b.m2502ae(false);
            C0414f.m2387r(InterfaceC0357a.f2724wS[0], "0");
            C0463b.setResult(3);
            C0463b.m2521eV(-1);
            C0012k.m41c("IAP-UMPBilling", "sendMO2: SMS sent failed! Exception: " + th.toString());
        }
        if (!bq) {
            C0012k.m40b("IAP-UMPBilling", "IAP_INVALID_REQUEST (-5): Invalid Server Number");
            C0463b.setResult(3);
            C0463b.m2521eV(-5);
            return;
        }
        StringBuilder sb = new StringBuilder("sendMO2: server address: ");
        str2 = this.adF.adz;
        C0012k.m41c("IAP-UMPBilling", sb.append(str2).toString());
        PendingIntent broadcast = PendingIntent.getBroadcast(C0488o.getContext(), 0, new Intent("MO2_SENT"), 0);
        C0488o.getContext().registerReceiver(new C0458m(this.adF), new IntentFilter("MO2_SENT"));
        SmsManager smsManager = SmsManager.getDefault();
        str3 = this.adF.adz;
        str4 = this.adF.adB;
        smsManager.sendTextMessage(str3, null, str4, broadcast, null);
        C0012k.m41c("IAP-UMPBilling", "sendMO2: sendTextMessage done!");
        C0463b.m2500ad(false);
        C0012k.m41c("IAP-UMPBilling", "sendMO2: SMS Thread ended!");
    }
}
